package cn.mmanager.model.pojo;

import lombok.Data;

import java.util.List;

/**
 * 客户实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:28
 */
@Data
public class Customer {
    /** 客户ID */
    private Long id;

    /** 客户名称 */
    private String name;

    /** 客户的页面 */
    private List<MQPage> mqPages;
}
