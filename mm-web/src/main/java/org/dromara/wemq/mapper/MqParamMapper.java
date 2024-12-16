package org.dromara.wemq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dromara.wemq.model.pojo.MQParam;

/**
 * 调试参数Mapper
 * @author 梁晓惠、袁祎阳、纪雨佳
 * @createTime 2023/4/8 15:16
 */
@Mapper
public interface MqParamMapper extends BaseMapper<MQParam> {
    /**
     * 添加
     * @param mqParam 参数实体类
     * @return 返回值
     */
    int add(MQParam mqParam);

    /**
     * 通过id修改
     * @param mqParam 参数实体类
     * @return 返回值
     */
    int update(MQParam mqParam);

    /**
     * 查询
     * @param id 参数id
     * @return 返回值
     */
    MQParam select (Long id);

}
