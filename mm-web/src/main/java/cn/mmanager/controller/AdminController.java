package cn.mmanager.controller;

import cn.mmanager.common.annotation.RepeatSubmit;
import cn.mmanager.common.constant.PageConstants;
import cn.mmanager.common.core.controller.BaseController;
import cn.mmanager.common.core.domain.AjaxResult;
import cn.mmanager.common.core.page.TableData;
import cn.mmanager.model.pojo.Admin;
import cn.mmanager.model.pojo.Customer;
import cn.mmanager.service.MQTT.AdminService;
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
 * @createTime 2023/4/27 19:21
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/list")
    @ResponseBody
    public AjaxResult list(@RequestParam("pageNum") int pageNum,
                           @RequestParam("pageSize") int pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<Admin> list = adminService.getAdminListByMap(null);

        return AjaxResult.success(new TableData(list, pageNum, page.getPages(), page.getTotal()));
    }

    @RequestMapping("/info/{id}")
    @ResponseBody
    public AjaxResult info(@PathVariable("id") int id) {
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
    public AjaxResult delete(@PathVariable("id") int id) {
        return adminService.deleteAdminById((long) id) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
