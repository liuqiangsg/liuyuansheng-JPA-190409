package com.fulian.liuyuansheng;

import com.fulian.liuyuansheng.zhouyunlian.dao.CustomerExtendCurdRepository;
import com.fulian.liuyuansheng.zhouyunlian.dao.CustomerJPARepository;
import com.fulian.liuyuansheng.zhouyunlian.dao.notnull.CustomerNotNullExtendCurdRepository;
import com.fulian.liuyuansheng.zhouyunlian.domain.Customer;
import com.fulian.liuyuansheng.zhouyunlian.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.PanelUI;
import java.util.List;

/**
 * TestExample
 *
 * @author liuqiang
 * @date 2019/4/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExample {

    @Autowired
    private CustomerJPARepository customerExtendCurdRepository;

    @Test
    public  void  testExample() {
//        Person person = new Person();
//        person.setFirstName("David");
//
//        ExampleMatcher matchinger = ExampleMatcher.matching()
//                .withIgnorePaths("lastName")
//                .withIncludeNullValues();
//
//
//        Example<Person> example = Example.of(person,matchinger);

        Customer customer = new Customer();
        customer.setLastName("Bauer");
        customer.setFirstName("cc");
        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("lastName", match -> match.endsWith());
                .withMatcher("firstName", match -> match.startsWith());

        List<Customer> all1 = customerExtendCurdRepository.findAll();
        System.err.println(all1);

        List<Customer> all = customerExtendCurdRepository.findAll(Example.of(customer, matcher));
        System.err.println(all);

    }
}
