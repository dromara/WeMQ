package org.dromara.controller;

import org.dromara.common.annotation.RepeatSubmit;
import org.dromara.common.core.domain.AjaxResult;
import org.dromara.common.core.page.TableData;
import org.dromara.model.dto.MqPageDto;
import org.dromara.model.pojo.MQParam;
import org.dromara.model.vo.MQPageVo;
import org.dromara.service.MqPageService;
import org.dromara.service.MqParamService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class MqPageController {
    private final MqPageService mqPageService;
    private final MqParamService mqParamService;

    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list(@RequestParam("pageNum") int pageNum,
                           @RequestParam("pageSize") int pageSize,
                           @RequestParam(required = false) Integer customerId ,
                           @RequestParam(required = false) Integer pageId,
                           @RequestParam(required = false) String pageName,
                           @RequestParam(required = false) Integer commonPage) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", pageId);
        params.put("pageName", pageName);
        params.put("customerID", customerId);
        params.put("commonPage", commonPage);
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<MqPageDto> list = mqPageService.select(params);

        return AjaxResult.success(new TableData(list, pageNum, page.getPages(), page.getTotal()));
    }

    @GetMapping("/info/{id}")
    @ResponseBody
    public AjaxResult info(@PathVariable("id") Long id) {
        MqPageDto pageDto = mqPageService.selectById(id);
        return AjaxResult.success(pageDto);
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@RequestBody MQPageVo page) {
        return mqPageService.insert(page) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(@RequestBody MQPageVo page) {
        return mqPageService.update(page) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/updateTopic")
    @ResponseBody
    public AjaxResult updateTopic(@RequestBody MQPageVo page) {
        return mqPageService.updateTopic(page) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id) {
        return mqPageService.deleteById(id) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/{pageId}/param/add")
    @ResponseBody
    public AjaxResult addParam(@PathVariable("pageId") Long pageId, @RequestBody MQParam param) {
        return mqParamService.insert(param,pageId) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/param/delete/{id}")
    @ResponseBody
    public AjaxResult deleteParam(@PathVariable("id") Long id) {
        return mqParamService.delete(id) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/param/update")
    @ResponseBody
    public AjaxResult updateParam(@RequestBody MQParam param) {
        return mqParamService.update(param) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
