package cn.mmanager.service.MQTT.impl;

import cn.mmanager.dao.MQTT.CustomerMapper;
import cn.mmanager.model.pojo.Customer;
import cn.mmanager.service.MQTT.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/17 14:23
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    private CustomerMapper customerMapper;

    @Autowired
    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public Integer insertClient(Customer customer) {
        return customerMapper.insertClient(customer);
    }

    @Override
    public Integer deleteClientById(Long id) {
        return customerMapper.deleteClientById(id);
    }

    @Override
    public Integer updateClient(Customer customer) {
        return customerMapper.updateClient(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerMapper.getCustomers();
    }

    @Override
    public Integer getCustomerCount() {
        return customerMapper.getCustomerCount();
    }
}
