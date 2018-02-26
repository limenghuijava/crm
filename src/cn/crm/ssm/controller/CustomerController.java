package cn.crm.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @RequestMapping("list")
    public String showIndex(){
        //springmvc.xml文件中配置了视图解析器，所以省略了页面名称的前置和后置名称
        return "customer";
    }
}
