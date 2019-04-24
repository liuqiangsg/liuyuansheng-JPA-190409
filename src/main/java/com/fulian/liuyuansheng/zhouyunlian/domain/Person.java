package com.fulian.liuyuansheng.zhouyunlian.domain;

import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.Id;

/**
 * Person
 *
 * @author liuqiang
 * @date 2019/4/14
 */
@Data
public class Person {

    @Id
    private String id;

    private  String firstName;

    private  String lastName;

    private Address address;
}
