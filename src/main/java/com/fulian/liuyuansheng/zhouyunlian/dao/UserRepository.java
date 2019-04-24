package com.fulian.liuyuansheng.zhouyunlian.dao;

import com.fulian.liuyuansheng.zhouyunlian.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * UserRepository
 *
 * @author liuqiang
 * @date 2019/4/19
 */
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

}
