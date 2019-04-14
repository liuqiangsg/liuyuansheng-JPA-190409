package com.fulian.liuyuansheng.zhouyunlian.controller;

import com.fulian.liuyuansheng.zhouyunlian.service.CustomerNotNullServiceImpl;
import com.fulian.liuyuansheng.zhouyunlian.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * CustomerController
 *
 * @author liuqiang
 * @date 2019/4/10
 */
@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    private CustomerNotNullServiceImpl customerNotNullService;

    @RequestMapping(value = "/pageAndSort")
    public  Object h(){
        return  customerServiceImpl.pageAndSort();
    }

    @RequestMapping(value = "/findByLastName")
    public  Object findByLastName(){
        return  customerServiceImpl.findByLastName();
    }

    @RequestMapping(value = "/findAllByCustomQueryAndStream")
    public  Object findAllByCustomQueryAndStream(){
        return  customerServiceImpl.findAllByCustomQueryAndStream();
    }


    @RequestMapping(value = "/findNotNullLastName")
    public  Object findNotNullLastName(HttpServletRequest request){
        return  customerNotNullService.getNonNullObj();
    }

    @RequestMapping(path = "/nullTest")
    public  Object nullTest() {
        return customerNotNullService.getNullAbleObj();
    }

    @RequestMapping(path = "/sortByIdDesc")
    public Object sort() {
        return  customerServiceImpl.sort();
    }

}
