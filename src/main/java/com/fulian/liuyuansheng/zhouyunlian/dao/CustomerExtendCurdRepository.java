package com.fulian.liuyuansheng.zhouyunlian.dao;

import com.fulian.liuyuansheng.zhouyunlian.domain.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.List;

/**
 * CustomerRepository
 *
 * @author liuqiang
 * @date 2019/4/9
 */
public interface CustomerExtendCurdRepository extends PagingAndSortingRepository<Customer,Long> ,QuerydslPredicateExecutor<Customer> {

    static Object  staticMethod() {
        return  new Object();
    }
    /*
       BASE ON JPQL
    *  implements by method parsed
    *
    * */
    List<Customer>  findByLastName(String lastName);

    Slice<Customer> findByLastName(String lastName, Pageable pageable);

    long countByLastName(String lastname);

    long deleteByLastName(String lastName);


    @Query(name = "Customer.deleteId"
            ,value =   "delete  from  Customer c where  c.id = ?1 "

    )
    @Modifying
    int deleteId( Long id);


    @Query(name = "Customer.selectTestId",value = "select  c from #{#entityName} c where c.id = ?1 ")
    @Lock(value = LockModeType.READ)
    Customer selectTestId(Long id);


    @Query(value = "select  c from #{#entityName} c where c.firstName like  '%?!' ")
    List<Customer> tt(@Param("firstName") String firstName);

    @Query("select u from #{#entityName}  u where u.firstName = ?1 and u.firstName=?1 ")
    List<Customer> findByFirstNameAndCurrentUserWithCustomQuery(String firstName);
}
