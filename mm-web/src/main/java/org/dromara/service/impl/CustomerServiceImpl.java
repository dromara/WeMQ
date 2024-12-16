package org.dromara.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.dromara.mapper.CustomerMapper;
import org.dromara.mapper.MqPageMapper;
import org.dromara.model.pojo.Customer;
import org.dromara.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/17 14:23
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    private final CustomerMapper customerMapper;
    private final MqPageMapper mqPageMapper;

    @Override
    public Integer insertClient(Customer customer) {
        return customerMapper.insert(customer);
    }

    @Override
    public Integer deleteClientById(Long id) {
        return customerMapper.deleteById(id);
    }

    @Override
    public Integer updateClient(Customer customer) {
        return customerMapper.updateById(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerMapper.selectList(null);
    }

    @Override
    public Integer getCustomerCount() {
        return Math.toIntExact(customerMapper.selectCount(null));
    }
}
