package com.fulian.liuyuansheng.hello.controller;

import com.fulian.liuyuansheng.hello.domain.Customer;
import com.fulian.liuyuansheng.hello.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * PagedResourceAssemblerController
 *
 * @author liuqiang
 * @date 2019/4/13
 */

@Controller
@RequestMapping(path = "/pageAssembler")
public class PagedResourceAssemblerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    HttpEntity<PagedResources<Customer>> persons(Pageable pageable,
                                                 PagedResourcesAssembler assembler) {

        Page<Customer> persons =(Page<Customer>) customerServiceImpl.findAll(pageable);
        return new ResponseEntity<>(assembler.toResource(persons), HttpStatus.OK);
    }

}
