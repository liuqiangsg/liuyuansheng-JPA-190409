package com.fulian.liuyuansheng.hello.controller;

import com.fulian.liuyuansheng.hello.domain.Customer;
import com.fulian.liuyuansheng.hello.domain.User;
import com.fulian.liuyuansheng.hello.service.CustomerServiceImpl;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserControllerO
 *
 * @author liuqiang
 * @date 2019/4/13
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private CustomerServiceImpl customerService;



    @RequestMapping("/{id}")
    Object showUser(User user, Model model) {
        return user;
    }



    @RequestMapping("/page")
    Object showUsers(Model model, Pageable pageable) {
        System.out.println(pageable.getClass());
        return customerService.findAll(pageable);

    }

    @RequestMapping("/pagep")
    Object showUsersP(Model model, @Qualifier("p") Pageable pageable) {
        System.out.println(pageable.getClass());
        return customerService.findAll(pageable);

    }

  @RequestMapping("/pageDefault")
    Object showUsersDefault(Model model, @PageableDefault(size = 2) Pageable pageable) {
        System.out.println(pageable.getClass());
        return customerService.findAll(pageable);

    }


    @RequestMapping(value = "/predicate", method = RequestMethod.GET)
    Object index(Model model, @QuerydslPredicate(root = Customer.class) Predicate predicate,
                 Pageable pageable, @RequestParam MultiValueMap<String, String> parameters) {

        return customerService.findAll(predicate, pageable);
    }

    @RequestMapping(path = "/test")
    Object test () {
        return customerService.test();
    }
}
