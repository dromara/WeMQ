package org.dromara.wemq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dromara.wemq.model.pojo.Customer;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
