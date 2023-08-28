package cn.mmanager.model.pojo;

import lombok.Data;

/**
 * 页面参数实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:25
 */
@Data
public class MQParam {
    /** 参数ID */
    private Long id;

    /** 调试消息 */
    private String message;

    /** 按钮消息 */
    private String button;

    /** 排序 */
    private Integer sort;
}
