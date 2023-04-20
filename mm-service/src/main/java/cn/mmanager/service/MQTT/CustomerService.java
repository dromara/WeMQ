package cn.mmanager.service.MQTT;

import cn.mmanager.model.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author NicholasLD
 * @createTime 2023/4/17 14:22
 */
public interface CustomerService {
    /**
     * Add a Customer
     *
     * @param customer
     * @return customer
     */
    Integer insertClient( Customer customer );

    /**
     * Delete a customer
     *
     * @param id
     * @return id
     */
    Integer deleteClientById( @Param(value = "id") Long id );

    /**
     * Modify customer
     *
     * @param customer
     * @return customer
     */
    Integer updateClient( Customer customer );

    /**
     * Delete a customer
     * @return
     */
    List<Customer> getCustomers();
    Integer getCustomerCount();
}
