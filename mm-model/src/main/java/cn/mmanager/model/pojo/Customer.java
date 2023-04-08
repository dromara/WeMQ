package cn.mmanager.model.pojo;

import java.util.List;

/**
 * 客户实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:28
 */
public class Customer {
    /** 客户ID */
    private Long id;

    /** 客户名称 */
    private String name;

    /** 客户的页面 */
    private List<MQPage> mqPages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MQPage> getMqPages() {
        return mqPages;
    }

    public void setMqPages(List<MQPage> mqPages) {
        this.mqPages = mqPages;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mqPages=" + mqPages +
                '}';
    }
}
