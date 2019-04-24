package com.fulian.liuyuansheng.zhouyunlian.service;

import com.fulian.liuyuansheng.zhouyunlian.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * OrderServiceImpl
 *
 * @author liuqiang
 * @date 2019/4/15
 */
@Service
public class OrderServiceImpl {

    @Autowired
    private OrderRepository orderRepository;

    public  Object getByAttribute(String attribute) {
        return  orderRepository.findAllByAttribute(attribute);
    }

    public  Object findByLastName(String lastName, Pageable pageable) {
        return  orderRepository.findByLastName(lastName,pageable);
    }

    public  Object getQuery() {
        return  orderRepository.getQuery();
    }
    public Object findByName(String lastName) {
        return orderRepository.findByLastName(lastName);
    }

}
