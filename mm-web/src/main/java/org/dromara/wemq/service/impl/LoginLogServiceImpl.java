package org.dromara.wemq.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.dromara.wemq.mapper.LoginLogMapper;
import org.dromara.wemq.framework.utils.IpUtils;
import org.dromara.wemq.model.dto.LoginLogDto;
import org.dromara.wemq.model.pojo.Admin;
import org.dromara.wemq.model.pojo.LoginLog;
import org.dromara.wemq.service.LoginLogService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/30 00:20
 */
@Service
@RequiredArgsConstructor
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
    private final LoginLogMapper loginLogMapper;
    private final AdminServiceImpl adminService;

    @Override
    public int log(HttpServletRequest request, Admin admin, int status) {
        //获取User-Agent
        String userAgent = request.getHeader("User-Agent");
        //解析User-Agent
        UserAgent ua = UserAgentUtil.parse(userAgent);
        //获取登录时间
        Date loginTime = new Date();

        //通过User-Agent读取操作系统
        String os = "Unknown";
        if (ua != null) {
            os = ua.getOs().toString();
        }

        LoginLog loginLog = new LoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setAdminIP(IpUtils.getIpAddr());
        loginLog.setAdminOS(os);
        loginLog.setLoginTime(new Timestamp(loginTime.getTime()));
        loginLog.setLoginStatus(status);

        return loginLogMapper.insert(loginLog);
    }

    @Override
    public List<LoginLogDto> getLoginLogList(String time) {
        QueryWrapper<LoginLog> queryWrapper = new QueryWrapper<>();
        if (time != null) {
            queryWrapper.like("login_time", time);
        }
        List<LoginLog> loginLogs = loginLogMapper.selectList(queryWrapper);

        List<LoginLogDto> loginLogDtos = new ArrayList<>();
        for (LoginLog loginLog : loginLogs) {
            LoginLogDto loginLogDto = new LoginLogDto();
            BeanUtil.copyProperties(loginLog, loginLogDto);

            //通过adminId获取管理员信息
            Admin admin = adminService.getById(loginLog.getAdminId());
            loginLogDto.setUsername(admin.getUsername());

            loginLogDtos.add(loginLogDto);
        }

        return loginLogDtos;
    }
}
