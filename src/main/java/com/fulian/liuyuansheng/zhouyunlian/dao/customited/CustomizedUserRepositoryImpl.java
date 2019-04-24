package com.fulian.liuyuansheng.zhouyunlian.dao.customited;

import com.fulian.liuyuansheng.zhouyunlian.domain.Customer;
import org.springframework.stereotype.Component;

/**
 * CustomizedUserRepositoryImpl
 *
 * @author liuqiang
 * @date 2019/4/18
 */
@Component
public class CustomizedUserRepositoryImpl implements  CustomizedUserRepository {

    @Override
    public void someCustomMethod(Customer customer) {
        System.out.println("execute someCustomMethod");
    }
}
