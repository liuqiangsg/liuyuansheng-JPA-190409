package com.fulian.liuyuansheng.zhouyunlian.dao;

import com.fulian.liuyuansheng.zhouyunlian.dao.parent.MappedTypeRepository;
import com.fulian.liuyuansheng.zhouyunlian.domain.Customer;
import com.fulian.liuyuansheng.zhouyunlian.domain.NameOnly;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.QueryHint;
import java.util.Collection;
import java.util.Map;

/**
 * OrderRepositoty
 *
 * @author liuqiang
 * @date 2019/4/15
 */

public interface OrderRepository extends MappedTypeRepository<Customer> , CrudRepository<Customer,Long> {

    @QueryHints(value = { @QueryHint(name = "name", value = "value")},
            forCounting = false)
    Page<Customer> findByLastName(String lastName, Pageable pageable);

    @Query("select  c,u from  Customer  c ,  User u  where c.id = u.id")
    Map<String,Object>  getQuery();


    Collection<NameOnly> findByLastName(String name);
}
