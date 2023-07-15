package cn.mmanager.model.pojo;

import lombok.Data;

/**
 * NmqsToken实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:29
 */
@Data
public class NmqsToken {
    /** TokenID */
    private Long id;

    /** Token名称 */
    private String name;

    /** Token */
    private String token;

    /** 协议 **/
    private int protocol;

    /** 服务器地址 */
    private String mqttServer;

    /** 服务器端口 */
    private int mqttPort;

    /** 服务器用户名 */
    private String mqttUsername;

    /** 服务器密码 */
    private String mqttPassword;
}
