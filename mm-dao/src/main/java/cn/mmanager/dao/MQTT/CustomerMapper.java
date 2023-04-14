package cn.mmanager.dao.MQTT;

import cn.mmanager.model.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {

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
     * @param map
     * @return
     */
    List<Customer> getCustomerListByMap( Map<String, Object> map );
    Integer getCustomerCount();

}
