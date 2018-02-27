package cn.crm.ssm.controller;

import cn.crm.ssm.pojo.BaseDict;
import cn.crm.ssm.pojo.Customer;
import cn.crm.ssm.pojo.QueryVo;
import cn.crm.ssm.service.BaseDictService;
import cn.crm.ssm.service.CustomerService;
import cn.crm.ssm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BaseDictService baseDictService;

    @Value("${CUSTOMER_FROM_TYPE}")
    private  String CUSTOMER_FROM_TYPE;
    @Value("${CUSTOMER_INDUSTRY_TYPE}")
    private  String CUSTOMER_INDUSTRY_TYPE;
    @Value("${CUSTOMER_LEVEL_TYPE}")
    private  String CUSTOMER_LEVEL_TYPE;

    @RequestMapping("list")
    public String showIndex(Model model,QueryVo queryVo) {
//        try {
//            // 解决get请求乱码问题
//            if (StringUtils.isNotBlank(queryVo.getCustName())) {
//                queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"), "UTF-8"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        List<BaseDict> industryType=baseDictService.queryBaseDictByTypeCode(CUSTOMER_INDUSTRY_TYPE);
        List<BaseDict> levelType=baseDictService.queryBaseDictByTypeCode(CUSTOMER_LEVEL_TYPE);
        List<BaseDict> fromType=baseDictService.queryBaseDictByTypeCode(CUSTOMER_FROM_TYPE);

        //查询客户的信息
        Page<Customer> page=customerService.queryCustomerByCondition(queryVo);


        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);
        model.addAttribute("fromType",fromType);

        model.addAttribute("page",page);

        //查询条件的回显
        model.addAttribute("custName",queryVo.getCustName());
        model.addAttribute("custLevel",queryVo.getCustLevel());
        model.addAttribute("custIndustry",queryVo.getCustIndustry());
        model.addAttribute("custSource",queryVo.getCustSource());
        //springmvc.xml文件中配置了视图解析器，所以省略了页面名称的前置和后置名称
        return "customer";
    }

    @RequestMapping("edit")
    @ResponseBody   //返回json字符串
    public Customer editCustomer(String id,Model model){
        Customer customer=customerService.queryCustomerByCustID(id);
//        return JSONObject.fromObject(customer).toString();
        return customer;
    }

    @RequestMapping("delete")
    @ResponseBody
    public String deleteCustomer(String id,Model model){
        customerService.deleteCustomerByCustID(id);
        return "success";
    }

    @RequestMapping("update")
    @ResponseBody
    public String updateCustomer(Customer customer,Model model){
        customerService.updateCustomer(customer);
        return "success";
    }

}
