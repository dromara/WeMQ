package cn.mmanager.controller;

import cn.mmanager.common.annotation.RepeatSubmit;
import cn.mmanager.common.constant.PageConstants;
import cn.mmanager.common.core.controller.BaseController;
import cn.mmanager.common.core.domain.AjaxResult;
import cn.mmanager.common.core.page.TableData;
import cn.mmanager.framework.utils.JSON;
import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.service.MQTT.MqPageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import oshi.PlatformEnum;
import oshi.SystemInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/3 13:17
 */
@Controller
public class TestController extends BaseController {

    private MqPageService mqPageService;

    @Autowired
    public void setMqPageService(MqPageService mqPageService) {
        this.mqPageService = mqPageService;
    }

    @GetMapping("/test")
    public String test(Model model) {
        return "12121";
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/testPOST")
    @ResponseBody
    public String test(String name) {
        return "success";
    }

    @GetMapping("/testPage")
    @ResponseBody
    public AjaxResult testPage(@RequestParam() int pageNum) {
        //模拟100条数据
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("test" + i);
        }
        PageHelper.startPage(pageNum, PageConstants.DEFAULT_PAGE_SIZE);
        PageInfo<String> pageInfo = new PageInfo<>(list);

        return AjaxResult.success(new TableData(list, pageNum, pageInfo.getPages(), pageInfo.getTotal()));
    }

    @GetMapping("/testPage2")
    @ResponseBody
    public AjaxResult testPage2() throws Exception {
        MqPageDto mqPageDto = mqPageService.selectById(1L);
        return AjaxResult.success(mqPageDto);
    }
}
