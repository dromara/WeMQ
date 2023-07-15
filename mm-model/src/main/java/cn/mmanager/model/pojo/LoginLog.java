package cn.mmanager.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 登录日志实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:18
 */
@Data
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp loginTime;

    /** 登录状态 */
    private int loginStatus;
}
