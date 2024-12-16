package org.dromara.wemq.controller;

import cn.hutool.core.util.StrUtil;
import org.dromara.wemq.common.core.controller.BaseController;
import org.dromara.wemq.common.core.domain.AjaxResult;
import org.dromara.wemq.common.core.page.TableData;
import org.dromara.wemq.model.dto.LoginLogDto;
import org.dromara.wemq.service.LoginLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/30 00:41
 */
@Controller
@RequestMapping("/loginLog")
@RequiredArgsConstructor
public class LoginLogController extends BaseController {
    private final LoginLogService loginLogService;

    @GetMapping("/list")
    @ResponseBody
    public AjaxResult getLoginLogList(@RequestParam(required = false) String time) {
        List<LoginLogDto> loginLogList;
        if (StrUtil.isEmpty(time)) {
            loginLogList = loginLogService.getLoginLogList(null);
            return AjaxResult.success(new TableData(loginLogList, 1, 1, loginLogList.size()));
        }
        loginLogList = loginLogService.getLoginLogList(time);
        return AjaxResult.success(new TableData(loginLogList, 1, 1, loginLogList.size()));
    }
}
