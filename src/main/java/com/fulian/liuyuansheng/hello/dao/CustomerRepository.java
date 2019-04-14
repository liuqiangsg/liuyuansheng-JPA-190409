package com.fulian.liuyuansheng.hello.dao;

import com.fulian.liuyuansheng.hello.domain.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.stream.Stream;

/**
 * CustomerRepository
 *
 * @author liuqiang
 * @date 2019/4/9
 */

@RepositoryDefinition(domainClass = Customer.class,idClass = Long.class)
public interface CustomerRepository  {


    List<Customer> findByLastName(@NonNull String lastName);

    List<Customer> findByLastName(@NonNull String lastName, Pageable pageable);


    <S extends Customer> S save(S entity);

    long countByLastName(String lastname);

    long deleteByLastName(String lastName);

    @Query(nativeQuery = true,value = "select  * from  Customer")
    Stream<Customer>  findAllByCustomQueryAndStream();

}
