package com.fulian.liuyuansheng.zhouyunlian.dao.notnull;

import com.fulian.liuyuansheng.zhouyunlian.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * CustomerRepository
 *
 * @author liuqiang
 * @date 2019/4/9
 */
public interface CustomerNotNullUnderNullAbleExtendCurdRepository extends PagingAndSortingRepository<Customer,Long> {

//    @Nullable
    List<Customer> findByLastName(@Nullable String lastName);

    long countByLastName(String lastname);


}
