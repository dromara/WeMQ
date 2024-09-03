package cn.mmanager.controller;

import cn.mmanager.common.annotation.RepeatSubmit;
import cn.mmanager.common.constant.PageConstants;
import cn.mmanager.common.core.domain.AjaxResult;
import cn.mmanager.common.core.page.TableData;
import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.model.pojo.MQPage;
import cn.mmanager.model.pojo.NmqsToken;
import cn.mmanager.service.MQTT.NmqsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class NmqsController {
    private final NmqsService nmqsService;

    @GetMapping("/list")
    @ResponseBody
    public AjaxResult list(@RequestParam("pageNum") int pageNum,
                           @RequestParam("pageSize") int pageSize,
                           @RequestParam(required = false) Long pageId,
                           @RequestParam(required = false) String pageName) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", pageId);
        params.put("pageName", pageName);
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<NmqsToken> list = nmqsService.select(params);

        return AjaxResult.success(new TableData(list, pageNum, page.getPages(), page.getTotal()));
    }

    @GetMapping("/info/{id}")
    @ResponseBody
    public AjaxResult info(@PathVariable("id") String id) {
        NmqsToken nmqsToken = nmqsService.selectById(Long.valueOf(id));
        return AjaxResult.success(nmqsToken);
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult add(@RequestBody NmqsToken nmqsToken) {
        return nmqsService.insert(nmqsToken) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(@RequestBody NmqsToken nmqsToken) {
        return nmqsService.update(nmqsToken) > 0 ? AjaxResult.success() : AjaxResult.error();
    }

    @RepeatSubmit(interval = 1000, message = "请勿重复提交")
    @PostMapping("/delete/{id}")
    @ResponseBody
    public AjaxResult delete(@PathVariable("id") Long id) {
        return nmqsService.deleteById(id) > 0 ? AjaxResult.success() : AjaxResult.error("删除失败，该token正在被页面使用");
    }
}
