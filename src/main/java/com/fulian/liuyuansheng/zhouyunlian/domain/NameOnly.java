package com.fulian.liuyuansheng.zhouyunlian.domain;

import org.springframework.beans.factory.annotation.Value;

/**
 * NameOnly
 *
 * @author liuqiang
 * @date 2019/4/19
 */
public interface NameOnly {


    String getLastName();

    @Value("#{target.firstName +'-'+ target.lastName}")
    String getName();

    @Value("#{@customerDAOBuilder.getFullName(target)}")
    String getFullName();
}
