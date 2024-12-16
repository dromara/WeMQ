package org.dromara.wemq.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 页面实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:20
 */
@Data
@TableName("mq_page")
public class MQPage {
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
    private Long nmqsTokenId;

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
}