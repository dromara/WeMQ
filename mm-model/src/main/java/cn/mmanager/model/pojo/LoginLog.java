package cn.mmanager.model.pojo;

import java.sql.Timestamp;

/**
 * 登录日志实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:18
 */
public class LoginLog {
    /** 日志ID */
    private Long id;

    /** 管理员ID */
    private Long adminId;

    /** 管理员IP */
    private String adminIP;

    /** 管理员操作系统 */
    private String adminOS;

    /** 登录时间 */
    private Timestamp loginTime;

    /** 登录状态 */
    private int loginStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminIP() {
        return adminIP;
    }

    public void setAdminIP(String adminIP) {
        this.adminIP = adminIP;
    }

    public String getAdminOS() {
        return adminOS;
    }

    public void setAdminOS(String adminOS) {
        this.adminOS = adminOS;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", adminIP='" + adminIP + '\'' +
                ", adminOS='" + adminOS + '\'' +
                ", loginTime=" + loginTime +
                ", loginStatus=" + loginStatus +
                '}';
    }
}
