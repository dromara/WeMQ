package org.dromara.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.dromara.model.pojo.Customer;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
