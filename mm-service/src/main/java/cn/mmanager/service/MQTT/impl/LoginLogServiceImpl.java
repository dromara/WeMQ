package cn.mmanager.service.MQTT.impl;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import cn.mmanager.dao.System.LoginLogMapper;
import cn.mmanager.model.dto.LoginLogDto;
import cn.mmanager.model.pojo.Admin;
import cn.mmanager.model.pojo.LoginLog;
import cn.mmanager.service.MQTT.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/30 00:20
 */
@Service("loginLogService")
public class LoginLogServiceImpl implements LoginLogService {
    private LoginLogMapper loginLogMapper;

    @Autowired
    public void setLoginLogMapper(LoginLogMapper loginLogMapper) {
        this.loginLogMapper = loginLogMapper;
    }

    @Override
    public int log(HttpServletRequest request, Admin admin, int status) {
        //获取User-Agent
        String userAgent = request.getHeader("User-Agent");
        //解析User-Agent
        UserAgent ua = UserAgentUtil.parse(userAgent);
        //获取IP地址
        String ip = request.getRemoteAddr();
        //获取登录时间
        Date loginTime = new Date();

        //通过User-Agent读取操作系统
        String os = "Unknown";
        if (ua != null) {
            os = ua.getOs().toString();
        }

        //如果IP地址为0:0:0:0:0:0:0:1，则为本地访问
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "127.0.0.1";
        }

        LoginLog loginLog = new LoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setAdminIP(ip);
        loginLog.setAdminOS(os);
        loginLog.setLoginTime(new Timestamp(loginTime.getTime()));
        loginLog.setLoginStatus(status);

        return loginLogMapper.insert(loginLog);
    }

    @Override
    public List<LoginLogDto> getLoginLogList(String time) {
        return loginLogMapper.getLoginLogList(time);
    }
}
