package org.dromara.wemq.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dromara.wemq.model.pojo.Admin;

/**
 * @author RR
 * @since 2023/4/8 15:49
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
