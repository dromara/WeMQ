package cn.mmanager.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 管理员实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_admin")
public class Admin {
    /** 管理员ID */
    @TableId(type = IdType.AUTO)
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
