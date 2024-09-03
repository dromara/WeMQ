package cn.mmanager.service.MQTT;

import cn.mmanager.model.dto.LoginLogDto;
import cn.mmanager.model.pojo.Admin;
import cn.mmanager.model.pojo.LoginLog;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/30 00:16
 */
public interface LoginLogService extends IService<LoginLog> {
    /**
     * 记录登录日志
     * @param request 请求
     * @param admin 用户
     * @param status 状态
     * @return int
     */
    int log(HttpServletRequest request, Admin admin, int status);

    List<LoginLogDto> getLoginLogList(String time);
}
