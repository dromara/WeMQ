package cn.mmanager.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 页面参数实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:25
 */
@Data
@TableName("mq_param")
public class MQParam {
    /** 参数ID */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 页面ID */
    private Long pageId;

    /** 调试消息 */
    private String message;

    /** 按钮消息 */
    private String button;

    /** 排序 */
    private Integer sort;
}
