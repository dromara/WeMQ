package cn.mmanager.dao.MQTT;

import cn.mmanager.model.dto.MqPageDto;
import cn.mmanager.model.pojo.MQPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
