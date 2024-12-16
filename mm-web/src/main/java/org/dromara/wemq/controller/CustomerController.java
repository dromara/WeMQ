package org.dromara.wemq.controller;

import org.dromara.wemq.common.annotation.RepeatSubmit;
import org.dromara.wemq.common.core.controller.BaseController;
import org.dromara.wemq.common.core.domain.AjaxResult;
import org.dromara.wemq.common.core.page.TableData;
import org.dromara.wemq.model.pojo.Customer;
import org.dromara.wemq.service.CustomerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.page.PageMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/17 14:24
 */
@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController extends BaseController {
    private final CustomerService customerService;

    @RequestMapping("/list")
    @ResponseBody
    public AjaxResult list(@RequestParam("pageNum") int pageNum,
                           @RequestParam("pageSize") int pageSize) {
        Page<Object> page = PageMethod.startPage(pageNum, pageSize);
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
    public AjaxResult delete(@PathVariable("id") Long id) {
        return customerService.deleteClientById(id) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
