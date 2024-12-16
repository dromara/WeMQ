package org.dromara.model.dto;

import lombok.Data;
import org.dromara.model.pojo.Customer;
import org.dromara.model.pojo.MQParam;
import org.dromara.model.pojo.NmqsToken;

import java.io.Serializable;
import java.util.List;

/**
 * 页面实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:20
 */
@Data
public class MqPageDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    /** 页面名称 */
    private String pageName;

    /** 页面URL */
    private String pageUrl;

    /** 页面文件名 */
    private String pageFileName;

    /** Nmqs Token ID */
    private Long nmqsTokenId;

    /** 服务器设置 */
    private NmqsToken settings;

    /** 发布订阅 */
    private String sendTopic;

    /** 接收订阅 */
    private String receiveTopic;

    /** QoS */
    private Integer qos;

    /** 客户 */
    private Customer customer;

    /** 页面状态 */
    private Integer status;

    /** 页面参数 */
    private List<MQParam> mqParams;
}
