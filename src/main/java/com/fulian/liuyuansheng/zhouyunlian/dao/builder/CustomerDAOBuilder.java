package com.fulian.liuyuansheng.zhouyunlian.dao.builder;

import com.fulian.liuyuansheng.zhouyunlian.domain.Customer;
import org.springframework.stereotype.Component;

/**
 * CustomerDAOBuilder
 *
 * @author liuqiang
 * @date 2019/4/22
 */
@Component
public class CustomerDAOBuilder {

    public  String getFullName(Customer customer) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(customer.getId());
        stringBuilder.append(" ");
        stringBuilder.append(customer.getLastName());
        return  stringBuilder.toString();

    }

    public  String  getPrefixName(String prefix) {
        return prefix + "liuqiang";
    }
}
