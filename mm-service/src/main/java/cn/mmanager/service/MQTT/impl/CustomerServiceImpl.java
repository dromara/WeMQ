package cn.mmanager.service.MQTT.impl;

import cn.mmanager.dao.MQTT.CustomerMapper;
import cn.mmanager.dao.MQTT.MqPageMapper;
import cn.mmanager.model.pojo.Customer;
import cn.mmanager.model.pojo.MQPage;
import cn.mmanager.service.MQTT.CustomerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
