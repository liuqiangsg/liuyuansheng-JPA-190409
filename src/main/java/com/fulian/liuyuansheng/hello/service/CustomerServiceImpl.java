package com.fulian.liuyuansheng.hello.service;

import com.fulian.liuyuansheng.hello.domain.Customer;
import com.fulian.liuyuansheng.hello.dao.CustomerExtendCurdRepository;
import com.fulian.liuyuansheng.hello.dao.CustomerRepository;
import com.fulian.liuyuansheng.hello.domain.QCustomer;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * CustomerServiceImpl
 *
 * @author liuqiang
 * @date 2019/4/10
 */
@Service
public class CustomerServiceImpl {


//    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerExtendCurdRepository  customerExtendCurdRepository;

    CustomerServiceImpl(CustomerRepository customerRepository) {
        System.out.printf("%n ---------构造方式 -------------- %n %s - %s %n",getClass(),customerRepository);
        this.customerRepository = customerRepository;
    }

    public Object pageAndSort() {
       return customerExtendCurdRepository.findByLastName("Bauer",PageRequest.of(1,1));

    }

    public Object findByLastName(){
        return customerRepository.findByLastName(null);
    }

    @Transactional
    public Object findAllByCustomQueryAndStream(){
        try(Stream<Customer> sc = customerRepository.findAllByCustomQueryAndStream()){
            Iterator<Customer> iterator = sc.iterator();
            List<Customer> list = new ArrayList<>();
            while (iterator.hasNext()) {
               list.add(iterator.next()) ;
            }
            return list;
        }
    }


    public  Object sort(){
        Sort sort  = Sort.by(Sort.Order.desc("id"));
        return  customerExtendCurdRepository.findAll(sort);
    }

    public Object findAll(Pageable pageable) {
        return customerExtendCurdRepository.findAll(pageable);
    }

    public Object findAll(Predicate predicate ,Pageable pageable) {
        return  customerExtendCurdRepository.findAll(predicate,pageable);
//        return null;
    }

    public Object test() {
        //QueryDSL
        QCustomer qCustomer = new QCustomer("customer");
        Predicate predicate = qCustomer.id.eq(1L)
                .and(qCustomer.lastName.eq("q"));
//                .and(user.lastname.startsWithIgnoreCase("mathews"));
        return customerExtendCurdRepository.findAll(predicate);
    }
}
