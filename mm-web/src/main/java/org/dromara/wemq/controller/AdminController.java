package org.dromara.wemq.controller;

import org.dromara.wemq.common.annotation.RepeatSubmit;
import org.dromara.wemq.common.core.controller.BaseController;
import org.dromara.wemq.common.core.domain.AjaxResult;
import org.dromara.wemq.common.core.page.TableData;
import org.dromara.wemq.model.pojo.Admin;
import org.dromara.wemq.service.AdminService;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/27 19:21
 */
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController extends BaseController {
    private final AdminService adminService;

    @RequestMapping("/list")
    @ResponseBody
    public AjaxResult list(@RequestParam("pageNum") int pageNum,
                           @RequestParam("pageSize") int pageSize) {
        Page<Object> page = PageMethod.startPage(pageNum, pageSize);
        List<Admin> list = adminService.getAdminListByMap(null);

        return AjaxResult.success(new TableData(list, pageNum, page.getPages(), page.getTotal()));
    }

    @RequestMapping("/info/{id}")
    @ResponseBody
    public AjaxResult info(@PathVariable("id") Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        Admin admin = adminService.getAdminByMap(params);
        return AjaxResult.success(admin);
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@RequestBody Admin admin) {
        return adminService.insertAdmin(admin) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(@RequestBody Admin admin) {
        return adminService.updateAdminById(admin) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id) {
        return adminService.deleteAdminById(id) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
