package cn.crm.ssm.service;

import cn.crm.ssm.pojo.Customer;
import cn.crm.ssm.pojo.QueryVo;
import cn.crm.ssm.utils.Page;

import java.util.List;

public interface CustomerService {
    List<Customer> queryAllCustomer();

    Page<Customer> queryCustomerByCondition(QueryVo queryVo);

    Customer queryCustomerByCustID(String cust_id);

    void deleteCustomerByCustID(String id);

    void updateCustomer(Customer customer);
}
