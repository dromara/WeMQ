package cn.mmanager.controller;

import cn.mmanager.common.annotation.RepeatSubmit;
import cn.mmanager.common.constant.PageConstants;
import cn.mmanager.common.core.controller.BaseController;
import cn.mmanager.common.core.domain.AjaxResult;
import cn.mmanager.common.core.page.TableData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/3 13:17
 */
@Controller
public class TestController extends BaseController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/customers")
    public String customer() {
        return "customers";
    }

    @GetMapping("/pages")
    public String page() {
        return "pages";
    }


    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/testPOST")
    @ResponseBody
    public String test(String name) {
        return "success";
    }

    @GetMapping("/testPage")
    @ResponseBody
    public AjaxResult testPage(int pageNum) {
        //模拟100条数据
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("test" + i);
        }
        PageHelper.startPage(pageNum, PageConstants.DEFAULT_PAGE_SIZE);
        PageInfo<String> pageInfo = new PageInfo<>(list);

        return AjaxResult.success(new TableData(list, pageNum, pageInfo.getPages()));
    }
}
