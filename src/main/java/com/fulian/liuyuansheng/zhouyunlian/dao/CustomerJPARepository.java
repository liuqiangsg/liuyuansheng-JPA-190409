package com.fulian.liuyuansheng.zhouyunlian.dao;

import com.fulian.liuyuansheng.zhouyunlian.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CustomerJPARepository
 *
 * @author liuqiang
 * @date 2019/4/23
 */
public interface CustomerJPARepository extends JpaRepository<Customer,Long> {
}
