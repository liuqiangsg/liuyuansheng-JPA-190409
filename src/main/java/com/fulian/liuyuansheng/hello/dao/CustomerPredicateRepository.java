package com.fulian.liuyuansheng.hello.dao;

import com.fulian.liuyuansheng.hello.domain.Customer;
import com.fulian.liuyuansheng.hello.domain.QCustomer;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;

/**
 * CustomerPredicateRepository
 *
 * @author liuqiang
 * @date 2019/4/14
 */
public interface CustomerPredicateRepository extends CrudRepository<Customer,Long>
            , QuerydslPredicateExecutor<Customer>, QuerydslBinderCustomizer<QCustomer>
{

    @Override
    default  void customize(QuerydslBindings bindings, QCustomer customer) {
        bindings.bind(customer.firstName).first((path, value) -> path.contains(value));
        bindings.bind(String.class)
                .first((StringPath path, String value) -> path.containsIgnoreCase(value));
        bindings.excluding(customer.id);
    }

}
