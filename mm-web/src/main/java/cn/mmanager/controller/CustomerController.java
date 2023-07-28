package cn.mmanager.controller;

import cn.mmanager.common.annotation.RepeatSubmit;
import cn.mmanager.common.constant.PageConstants;
import cn.mmanager.common.core.controller.BaseController;
import cn.mmanager.common.core.domain.AjaxResult;
import cn.mmanager.common.core.page.TableData;
import cn.mmanager.model.pojo.Customer;
import cn.mmanager.model.pojo.NmqsToken;
import cn.mmanager.service.MQTT.CustomerService;
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
 * @createTime 2023/4/17 14:24
 */
@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController {
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/list")
    @ResponseBody
    public AjaxResult list(@RequestParam("pageNum") int pageNum,
                           @RequestParam("pageSize") int pageSize) {
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<Customer> list = customerService.getCustomers();
        return AjaxResult.success(new TableData(list, pageNum, page.getPages(), page.getTotal()));
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@RequestBody Customer customer) {
        return customerService.insertClient(customer) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(@RequestBody Customer customer) {
        return customerService.updateClient(customer) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") int id) {
        return customerService.deleteClientById((long) id) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
