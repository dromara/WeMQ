package cn.mmanager.controller;

import cn.hutool.core.util.StrUtil;
import cn.mmanager.common.core.controller.BaseController;
import cn.mmanager.common.core.domain.AjaxResult;
import cn.mmanager.common.core.page.TableData;
import cn.mmanager.model.dto.LoginLogDto;
import cn.mmanager.service.MQTT.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/30 00:41
 */
@Controller
@RequestMapping("/loginLog")
public class LoginLogController extends BaseController {
    private LoginLogService loginLogService;

    @Autowired
    public void setLoginLogService(LoginLogService loginLogService) {
        this.loginLogService = loginLogService;
    }

    @GetMapping("/list")
    @ResponseBody
    public AjaxResult getLoginLogList(@RequestParam(required = false) String time) {
        List<LoginLogDto> loginLogList;
        if (StrUtil.isEmpty(time)) {
            loginLogList = loginLogService.getLoginLogList(null);
            return AjaxResult.success(new TableData(loginLogList, 1, 1));
        }
        loginLogList = loginLogService.getLoginLogList(time);
        return AjaxResult.success(new TableData(loginLogList, 1, 1));
    }
}
