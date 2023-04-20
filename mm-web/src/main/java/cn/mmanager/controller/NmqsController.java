package cn.mmanager.controller;

import cn.mmanager.common.constant.PageConstants;
import cn.mmanager.common.core.domain.AjaxResult;
import cn.mmanager.common.core.page.TableData;
import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.model.pojo.MQPage;
import cn.mmanager.model.pojo.NmqsToken;
import cn.mmanager.service.MQTT.NmqsService;
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
 * @createTime 2023/4/16 14:22
 */
@Controller
@RequestMapping("/nmqs")
public class NmqsController {
    private NmqsService nmqsService;
    @Autowired
    public void setNmqsService(NmqsService nmqsService) {
        this.nmqsService = nmqsService;
    }

    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list(@RequestParam("pageNum") int pageNum, @RequestParam(required = false) Integer pageId, @RequestParam(required = false) String pageName) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", pageId);
        params.put("pageName", pageName);
        List<NmqsToken> list = nmqsService.select(params);
        Page<Object> page = PageHelper.startPage(pageNum, PageConstants.DEFAULT_PAGE_SIZE);
        return AjaxResult.success(new TableData(list, pageNum, page.getPages()));
    }

    @GetMapping("/info/{id}")
    @ResponseBody
    public AjaxResult info(@PathVariable("id") int id) {
        NmqsToken nmqsToken = nmqsService.selectById((long) id);
        return AjaxResult.success(nmqsToken);
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@RequestBody NmqsToken nmqsToken) {
        return nmqsService.insert(nmqsToken) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(@RequestBody NmqsToken nmqsToken) {
        return nmqsService.update(nmqsToken) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") int id) {
        return nmqsService.deleteById((long) id) > 0 ? AjaxResult.success() : AjaxResult.error();
    }
}
