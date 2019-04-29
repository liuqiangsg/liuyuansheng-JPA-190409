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
    String id;

    String firstName;

    String lastName;

    Address address;
}
