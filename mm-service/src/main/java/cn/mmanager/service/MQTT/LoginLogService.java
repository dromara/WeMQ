package cn.mmanager.service.MQTT;

import cn.mmanager.model.dto.LoginLogDto;
import cn.mmanager.model.pojo.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/30 00:16
 */
public interface LoginLogService {
    /**
     * 记录登录日志
     * @param request 请求
     * @param admin 用户
     * @param status 状态
     */
    int log(HttpServletRequest request, Admin admin, int status);

    List<LoginLogDto> getLoginLogList(String time);
}
