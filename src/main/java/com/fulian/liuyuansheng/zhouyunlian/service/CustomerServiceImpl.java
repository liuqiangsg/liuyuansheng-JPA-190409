package com.fulian.liuyuansheng.zhouyunlian.service;

import com.fulian.liuyuansheng.zhouyunlian.domain.Customer;
import com.fulian.liuyuansheng.zhouyunlian.dao.CustomerExtendCurdRepository;
import com.fulian.liuyuansheng.zhouyunlian.dao.CustomerRepository;
import com.fulian.liuyuansheng.hello.domain.QCustomer;
import com.fulian.liuyuansheng.zhouyunlian.domain.Person;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public  Object deleteId(Long id) {
       return customerExtendCurdRepository.deleteId(id);
    }

    public  Object selectTestId(Long id) {
        return  customerExtendCurdRepository.selectTestId(id);
    }
    public Object findByFirstNameStartingWith(String firstName) {
        return customerExtendCurdRepository.tt(firstName);
    }

    public Object findByFirstNameAndCurrentUserWithCustomQuery(String firstName) {
        return  customerExtendCurdRepository.findByFirstNameAndCurrentUserWithCustomQuery(firstName);
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

   @Transactional
    public Object transactionMethod() {
        Customer customer = customerRepository.save(new Customer(null, "ff", "ll"));
        int i = 1 / 0;
        return customer;
    }

    public   Object findByLastName(String lastName) {
        return  customerRepository.findByLastName(lastName, Person.class);
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
