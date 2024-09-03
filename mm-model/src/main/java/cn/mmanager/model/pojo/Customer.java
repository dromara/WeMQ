package cn.mmanager.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * 客户实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:28
 */
@Data
@TableName("mq_customer")
public class Customer {
    /** 客户ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 客户名称 */
    private String name;

    /** 客户的页面 */
    @TableField(exist=false)
    private transient List<MQPage> mqPages;
}
