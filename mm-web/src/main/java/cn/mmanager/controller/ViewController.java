package cn.mmanager.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.system.oshi.CpuInfo;
import cn.hutool.system.oshi.OshiUtil;
import cn.mmanager.common.constant.UserConstants;
import cn.mmanager.common.core.controller.BaseController;
import cn.mmanager.dao.MQTT.MqPageMapper;
import cn.mmanager.dao.MQTT.NmqsMapper;
import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.model.pojo.Admin;
import cn.mmanager.model.pojo.NmqsToken;
import cn.mmanager.service.MQTT.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import oshi.PlatformEnum;
import oshi.SystemInfo;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/13 14:49
 */
@Controller
public class ViewController extends BaseController {
    private MqPageMapper mqPageMapper;
    private NmqsMapper nmqsMapper;
    private AdminService adminService;

    @Autowired
    public void setMqPageMapper(MqPageMapper mqPageMapper) {
        this.mqPageMapper = mqPageMapper;
    }

    @Autowired
    public void setNmqsMapper(NmqsMapper nmqsMapper) {
        this.nmqsMapper = nmqsMapper;
    }

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/")
    public String index(Model model) {
        PlatformEnum currentPlatform = SystemInfo.getCurrentPlatform();
        CpuInfo cpuInfo = OshiUtil.getCpuInfo();
        //Intel(R) Core(TM) i5-8250U CPU @ 1.60GHz
        String cpuModel = cpuInfo.getCpuModel();
        cpuModel = cpuModel.substring(cpuModel.indexOf("Intel"), cpuModel.indexOf("GHz") + 3);
        cpuInfo.setCpuModel(cpuModel);
        model.addAttribute("platform", currentPlatform);
        //获取CPU型号
        model.addAttribute("CPU", cpuInfo.getCpuModel());
        //获取cpu占用率
        model.addAttribute("CPUUsage", cpuInfo.getUsed());
        //获取内存占用率，格式化为GB，保留两位小数
        double total = Math.round(((double) OshiUtil.getMemory().getTotal() / 1024 / 1024 / 1024) * 100) / 100.0;
        double available = Math.round(((double) OshiUtil.getMemory().getAvailable() / 1024 / 1024 / 1024) * 100) / 100.0;

        total = Math.round(total * 100.0) / 100.0;
        available = Math.round(available * 100.0) / 100.0;

        double used = total - available;
        used = Math.round(used * 100.0) / 100.0;


        model.addAttribute("Memory", total);
        model.addAttribute("MemoryAvailable", available);
        //获取内存占用率 oshi
        model.addAttribute("MemoryUsage", (total - available) / total * 100);
        //获取占用内存
        model.addAttribute("MemoryUsed", used);

        //获取JRE版本
        model.addAttribute("JRE", System.getProperty("java.version"));

        int count = mqPageMapper.count(0);
        model.addAttribute("pageCount", count);

        int adminCount = adminService.getAdminCountByMap(null);
        model.addAttribute("adminCount", adminCount);

        return "index";
    }

    @GetMapping("/login")
    public String login(String redirect, Model model) {
        if (!StrUtil.isEmpty(redirect)) {
            model.addAttribute("redirect", redirect);
        }
        return "login";
    }

    @PostMapping("/dologin")
    public String dologin(String username, String password, String redirect, HttpSession session, Model model) {
        if (StrUtil.isEmpty(username) || StrUtil.isEmpty(password)) {
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
            return "login";
        }

        session.setAttribute(UserConstants.USER_SESSION, admin);

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

    @GetMapping("/page/{url}")
    public ModelAndView mqttPage(@PathVariable("url") String url){
        ModelAndView mav = new ModelAndView();
        if (StrUtil.isEmpty(url)){
            mav.setViewName("error/404");
            return mav;
        }
        MqPageDto mqPageDto = mqPageMapper.selectByURL(url);
        if (mqPageDto == null){
            mav.setViewName("error/404");
            return mav;
        }

        NmqsToken nmqsToken = nmqsMapper.selectById(mqPageDto.getNmqsTokenID());
        if (nmqsToken == null){
            mav.setViewName("error/404");
            return mav;
        }

        mav.addObject("params", mqPageDto.getMqParams());
        mav.addObject("token", nmqsToken.getToken());

        mav.setViewName("mqtt");
        return mav;

    }
}
