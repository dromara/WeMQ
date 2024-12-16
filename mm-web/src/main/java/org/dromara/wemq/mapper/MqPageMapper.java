package org.dromara.wemq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dromara.wemq.model.dto.MqPageDto;
import org.dromara.wemq.model.pojo.MQPage;

/**
 * 调试页面Mapper
 * @author NicholasLD
 * @createTime 2023/4/13 08:22
 */
@Mapper
public interface MqPageMapper extends BaseMapper<MQPage> {

    /**
     * 根据id删除调试页面
     * @param id 调试页面id
     * @return 删除结果
     */
    int deleteById(Long id);

    int count(int type);

    MqPageDto selectByURL(String url);
}
