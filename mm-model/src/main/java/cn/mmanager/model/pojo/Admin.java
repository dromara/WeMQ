package cn.mmanager.model.pojo;

import lombok.Data;

/**
 * 管理员实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:16
 */
@Data
public class Admin {
    /** 管理员ID */
    private Long id;

    /** 管理员用户名 */
    private String username;

    /** 管理员昵称 */
    private String nickname;

    /** 管理员密码 */
    private String password;

    /** 管理员状态 */
    private int status;
}
