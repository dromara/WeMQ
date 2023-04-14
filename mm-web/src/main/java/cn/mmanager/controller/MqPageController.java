package cn.mmanager.controller;

import cn.mmanager.common.constant.PageConstants;
import cn.mmanager.common.core.domain.AjaxResult;
import cn.mmanager.common.core.page.TableData;
import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.model.pojo.MQPage;
import cn.mmanager.service.MQTT.MqPageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/13 14:51
 */
@Controller
@RequestMapping("/page")
public class MqPageController {
    private MqPageService mqPageService;
    @Autowired
    public void setMqPageService(MqPageService mqPageService) {
        this.mqPageService = mqPageService;
    }

    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list(@RequestParam("pageNum") int pageNum, @RequestParam(required = false) Integer pageId, @RequestParam(required = false) String pageName) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", pageId);
        params.put("pageName", pageName);
        List<MQPage> list = mqPageService.select(params);
        list.forEach(System.out::println);
        Page<Object> page = PageHelper.startPage(pageNum, PageConstants.DEFAULT_PAGE_SIZE);
        return AjaxResult.success(new TableData(list, pageNum, page.getPages()));
    }

    @GetMapping("/info/{id}")
    @ResponseBody
    public AjaxResult info(@PathVariable("id") int id) {
        MqPageDto pageDto = mqPageService.selectById((long) id);
        return AjaxResult.success(pageDto);
    }
}
