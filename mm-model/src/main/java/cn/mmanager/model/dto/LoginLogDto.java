package cn.mmanager.model.dto;

import cn.mmanager.model.pojo.LoginLog;
import lombok.Data;

import java.io.Serializable;

/**
 * @author NicholasLD
 * @createTime 2023/4/8 15:24
 */
@Data
public class LoginLogDto extends LoginLog implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
}
