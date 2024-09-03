package cn.mmanager.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author NicholasLD
 * @createTime 2023/4/8 15:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginLogDto implements Serializable {
    private static final long serialVersionUID = 1L;

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

    private String username;
}
