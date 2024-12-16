package org.dromara.controller;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.dromara.common.constant.UserConstants;
import org.dromara.common.core.controller.BaseController;
import org.dromara.mapper.NmqsMapper;
import org.dromara.model.dto.MqPageDto;
import org.dromara.model.pojo.Admin;
import org.dromara.model.pojo.NmqsToken;
import org.dromara.service.AdminService;
import org.dromara.service.LoginLogService;
import org.dromara.service.MqPageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import oshi.PlatformEnum;
import oshi.SystemInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/13 14:49
 */
@Controller
@RequiredArgsConstructor
public class ViewController extends BaseController {
    private final MqPageService mqPageService;
    private final NmqsMapper nmqsMapper;
    private final AdminService adminService;
    private final LoginLogService loginLogService;
    private final Environment environment;

    @GetMapping("/")
    public String index(Model model) {
        PlatformEnum currentPlatform = SystemInfo.getCurrentPlatform();
        CpuInfo cpuInfo = OshiUtil.getCpuInfo();

        // 设置 CPU 信息
        model.addAttribute("platform", currentPlatform);
        model.addAttribute("CPU", cpuInfo.getCpuModel());
        model.addAttribute("CPUUsage", cpuInfo.getUsed());

        // 获取内存信息
        long totalBytes = OshiUtil.getMemory().getTotal();
        long availableBytes = OshiUtil.getMemory().getAvailable();

        double total = Math.round(((double) totalBytes / 1024 / 1024 / 1024) * 100) / 100.0;
        double available = Math.round(((double) availableBytes / 1024 / 1024 / 1024) * 100) / 100.0;
        double used = Math.round((total - available) * 100.0) / 100.0;

        model.addAttribute("Memory", total);
        model.addAttribute("MemoryAvailable", available);
        model.addAttribute("MemoryUsage", ((used / total) * 100));
        model.addAttribute("MemoryUsed", used);

        // 获取 JRE 版本
        model.addAttribute("JRE", System.getProperty("java.version"));

        // 获取页面和管理员数量
        model.addAttribute("pageCount", mqPageService.count(new QueryWrapper<>()));
        model.addAttribute("adminCount", adminService.getAdminCountByMap(null));

        return "index";
    }

    @GetMapping("/login")
    public String login(String redirect, Model model) {
        if (!CharSequenceUtil.isEmpty(redirect)) {
            model.addAttribute("redirect", redirect);
        }
        return "login";
    }

    @PostMapping("/dologin")
    public String dologin(String username, String password, String redirect, HttpSession session, Model model, HttpServletRequest request) {
        if (CharSequenceUtil.isEmpty(username) || CharSequenceUtil.isEmpty(password)) {
            model.addAttribute("msg", "用户名或密码不能为空");
            return "login";
        }

        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        Admin admin = adminService.getAdminByMap(map);
        if (admin == null) {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }

        if (!adminService.checkPassword(password, admin.getPassword())) {
            model.addAttribute("msg", "用户名或密码错误");
            loginLogService.log(request, admin, 1);
            return "login";
        }

        //记录登录日志
        loginLogService.log(request, admin, 0);

        session.setAttribute(UserConstants.USER_SESSION, admin);
        model.addAttribute(UserConstants.USER_SESSION, admin);
        //设置session不过期
        session.setMaxInactiveInterval(-1);


        if (!StrUtil.isEmpty(redirect)) {
            return "redirect:" + redirect;
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(UserConstants.USER_SESSION);
        return "redirect:/login";
    }

    @GetMapping("/customers")
    public String customer() {
        return "customers";
    }

    @GetMapping("/pages")
    public String page() {
        return "pages";
    }

    @GetMapping("/tokens")
    public String nmqs() {
        return "nmqs";
    }

    @GetMapping("/admins")
    public String admin() {
        return "admin";
    }

    @GetMapping("/loginlogs")
    public String loginLog() {
        return "loginlog";
    }

    @GetMapping("/custommqtt")
    public String customMqtt() {
        return "custom_mqtt";
    }

    @GetMapping("/viewer")
    public String viewer() {
        return "viewer_pages";
    }

    @GetMapping("/common")
    public String common() {
        return "common";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/tools")
    public String tools() {
        return "tools";
    }

    @GetMapping("/mq/{url}")
    public ModelAndView mqttPage(@PathVariable("url") String url, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        if (CharSequenceUtil.isEmpty(url)){
            mav.setViewName("error/404");
            return mav;
        }
        MqPageDto mqPageDto = mqPageService.selectByURL(url);
        if (mqPageDto == null){
            mav.setViewName("error/404");
            return mav;
        }

        NmqsToken nmqsToken = nmqsMapper.selectById(mqPageDto.getNmqsTokenId());
        if (nmqsToken == null){
            mav.setViewName("error/404");
            return mav;
        }

        mav.addObject("pageId", mqPageDto.getId());
        mav.addObject("pageName", mqPageDto.getPageName());
        mav.addObject("params", mqPageDto.getMqParams());
        mav.addObject("token", nmqsToken.getToken());

        mav.addObject("sendTopic", mqPageDto.getSendTopic());
        mav.addObject("receiveTopic", mqPageDto.getReceiveTopic());
        mav.addObject("qos", mqPageDto.getQos());

        mav.addObject("serverInfo", (nmqsToken.getProtocol()==0?"ws://":"mqtt://")+nmqsToken.getMqttServer()+":"+nmqsToken.getMqttPort());

        if (StrUtil.isEmpty(mqPageDto.getPageFileName())){
            mav.setViewName("mqtt");
        } else {
            mav.setViewName(mqPageDto.getPageFileName());
        }

        //如果用户已登录，将已登录传递到前端
        Object attribute = request.getSession().getAttribute(UserConstants.USER_SESSION);
        if (attribute != null){
            mav.addObject("login", "true");
        }


        return mav;

    }

    @GetMapping("/statics/system/common.js")
    public ResponseEntity<String> commonJs() {
        String host = environment.getProperty("wemq.nmqs.host");
        String port = environment.getProperty("wemq.nmqs.port");

        String url = host + ":" + port;

        String js = "const url = \"" + url + "\";\n" +
                "function getNmqsAPI() {\n" +
                "    if (window.location.protocol === 'https:') {\n" +
                "        return `https://${url}`;\n" +
                "    }\n" +
                "    return `http://${url}`;\n" +
                "}\n" +
                "\n" +
                "function getNmqsWebsocket() {\n" +
                "    if (window.location.protocol === 'https:') {\n" +
                "        return `wss://${url}`;\n" +
                "    }\n" +
                "    return `ws://${url}`;\n" +
                "}";
        return ResponseEntity.ok(js);
    }
}
