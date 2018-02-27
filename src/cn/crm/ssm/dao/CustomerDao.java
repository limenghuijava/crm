package cn.crm.ssm.dao;

import cn.crm.ssm.pojo.Customer;
import cn.crm.ssm.pojo.QueryVo;

import java.util.List;

public interface CustomerDao {

    List<Customer> queryAllCustomer();

    List<Customer> queryCustomerByCondition(QueryVo queryVo);

    Integer queryCustomerCountByCondition(QueryVo queryVo);

    Customer queryCustomerByCustID(String cust_id);

    void deleteCustomerByCustID(String id);

    void updateCustomer(Customer customer);
}
