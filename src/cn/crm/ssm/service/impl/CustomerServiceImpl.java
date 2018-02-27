package cn.crm.ssm.service.impl;

import cn.crm.ssm.dao.CustomerDao;
import cn.crm.ssm.pojo.Customer;
import cn.crm.ssm.pojo.QueryVo;
import cn.crm.ssm.service.CustomerService;
import cn.crm.ssm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

//    @Resource(name="customerDao")
    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<Customer> queryAllCustomer() {
        return customerDao.queryAllCustomer();
    }

    @Override
    public Page<Customer> queryCustomerByCondition(QueryVo queryVo) {
        //设置分页的起始数目
        queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
        //按照条件进行分页查询
        List<Customer> list= customerDao.queryCustomerByCondition(queryVo);
        //查询总记录数
        Integer count=customerDao.queryCustomerCountByCondition(queryVo);

        //将最终的查询结果封装在Page中
        Page<Customer> pageResult=new Page<>();
        pageResult.setTotal(count);
        pageResult.setPage(queryVo.getPage());
        pageResult.setSize(queryVo.getRows());
        pageResult.setRows(list);

        return pageResult;
    }

    @Override
    public Customer queryCustomerByCustID(String cust_id) {

        return customerDao.queryCustomerByCustID(cust_id);
    }

    @Override
    public void deleteCustomerByCustID(String id) {
        customerDao.deleteCustomerByCustID(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }
}
