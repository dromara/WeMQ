package org.dromara.wemq.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 登录日志实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:18
 */
@Data
@TableName("sys_login_log")
public class LoginLog {
    /** 日志ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 管理员ID */
    private Long adminId;

    /** 管理员IP */
    @TableField(value = "admin_ip")
    private String adminIP;

    /** 管理员操作系统 */
    @TableField(value = "admin_os")
    private String adminOS;

    /** 登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp loginTime;

    /** 登录状态 */
    private int loginStatus;
}
