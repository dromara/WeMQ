package org.dromara.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.dromara.model.pojo.Customer;

import java.util.List;

/**
 * @author NicholasLD
 * @createTime 2023/4/17 14:22
 */
public interface CustomerService extends IService<Customer> {
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
