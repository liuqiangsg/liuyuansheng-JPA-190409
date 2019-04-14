package com.fulian.liuyuansheng.hello.dao.notnull;

import com.fulian.liuyuansheng.hello.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * CustomerRepository
 *
 * @author liuqiang
 * @date 2019/4/9
 */
public interface CustomerNotNullExtendCurdRepository extends PagingAndSortingRepository<Customer,Long> {

    List<Customer> findByLastName(String lastName);

    long countByLastName(String lastname);

//    long deleteByLastName(String lastName);

}
