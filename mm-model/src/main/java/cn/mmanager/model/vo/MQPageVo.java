package cn.mmanager.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 页面实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:20
 */
@Data
public class MQPageVo {
    /** 页面ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 页面名称 */
    private String pageName;

    /** 页面URL */
    private String pageUrl;

    /** 页面文件名 */
    @TableField(value = "page_filename")
    private String pageFileName;

    /** Nmqs Token ID */
    @TableField(value = "nmqs_id")
    private String nmqsTokenId;

    /** 发布订阅 */
    @TableField(value = "mqtt_sendtopic")
    private String sendTopic;

    /** 接收订阅 */
    @TableField(value = "mqtt_receivetopic")
    private String receiveTopic;

    /** QoS */
    @TableField(value = "mqtt_qos")
    private int qos;

    /** 客户 */
    private Long customerId;

    /** 页面状态 */
    private int status;

    /** 服务器信息 */
    private Integer protocol;
    private String mqttServer;
    private Integer mqttPort;
    private String mqttUsername;
    private String mqttPassword;
}
