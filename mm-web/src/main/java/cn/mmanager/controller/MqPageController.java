package cn.mmanager.controller;

import cn.mmanager.common.constant.PageConstants;
import cn.mmanager.common.core.domain.AjaxResult;
import cn.mmanager.common.core.page.TableData;
import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.model.pojo.MQPage;
import cn.mmanager.model.pojo.MQParam;
import cn.mmanager.service.MQTT.MqPageService;
import cn.mmanager.service.MQTT.MqParamService;
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
    private MqParamService mqParamService;
    @Autowired
    public void setMqPageService(MqPageService mqPageService) {
        this.mqPageService = mqPageService;
    }

    @Autowired
    public void setMqParamService(MqParamService mqParamService) {
        this.mqParamService = mqParamService;
    }

    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list(@RequestParam("pageNum") int pageNum,
                           @RequestParam(required = false) Integer customerId ,
                           @RequestParam(required = false) Integer pageId,
                           @RequestParam(required = false) String pageName) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", pageId);
        params.put("pageName", pageName);
        params.put("customerID", customerId);
        List<MQPage> list = mqPageService.select(params);
        Page<Object> page = PageHelper.startPage(pageNum, PageConstants.DEFAULT_PAGE_SIZE);
        return AjaxResult.success(new TableData(list, pageNum, page.getPages()));
    }

    @GetMapping("/info/{id}")
    @ResponseBody
    public AjaxResult info(@PathVariable("id") int id) {
        MqPageDto pageDto = mqPageService.selectById((long) id);
        return AjaxResult.success(pageDto);
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@RequestBody MQPage page) {
        return mqPageService.insert(page) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(@RequestBody MqPageDto page) {
        return mqPageService.update(page) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") int id) {
        return mqPageService.deleteById((long) id) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PostMapping("/{pageId}/param/add")
    @ResponseBody
    public AjaxResult addParam(@PathVariable("pageId") int pageId, @RequestBody MQParam param) {
        return mqParamService.insert(param,(long) pageId) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PostMapping("/param/delete/{id}")
    @ResponseBody
    public AjaxResult deleteParam(@PathVariable("id") int id) {
        return mqParamService.delete((long) id) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
