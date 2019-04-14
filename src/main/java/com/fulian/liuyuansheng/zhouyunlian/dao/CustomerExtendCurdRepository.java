package com.fulian.liuyuansheng.zhouyunlian.dao;

import com.fulian.liuyuansheng.zhouyunlian.domain.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * CustomerRepository
 *
 * @author liuqiang
 * @date 2019/4/9
 */
public interface CustomerExtendCurdRepository extends PagingAndSortingRepository<Customer,Long> ,QuerydslPredicateExecutor<Customer> {

    List<Customer> findByLastName(String lastName);

    Slice<Customer> findByLastName(String lastName, Pageable pageable);

    long countByLastName(String lastname);

    long deleteByLastName(String lastName);

}
