package com.fulian.liuyuansheng.zhouyunlian.controller;

import com.fulian.liuyuansheng.zhouyunlian.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * OrderController
 *
 * @author liuqiang
 * @date 2019/4/15
 */
@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;


    @RequestMapping(path = "/getAttribute")
    public  Object getAttribute(String s){
        return  orderService.getByAttribute(s);
    }

    @RequestMapping(path = "/page")
    public  Object page (String lastName, Pageable pageable) {
        return orderService.findByLastName(lastName,pageable);
    }
    @RequestMapping(path = "/joinQuery")
    public  Object getQuery() {
        return orderService.getQuery();
    }
    @RequestMapping(path = "/findName")
    public Object findByName(String name) {
        return  orderService.findByName(name);
    }
}
