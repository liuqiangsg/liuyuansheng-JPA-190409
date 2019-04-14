package com.fulian.liuyuansheng.hello.service;


import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;

/**
 * MyRepositoryImpl
 *
 * @author liuqiang
 * @date 2019/4/13
 */

 public class MyRepository <T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> {

    private final EntityManager entityManager;

    MyRepository(JpaEntityInformation entityInformation,
                     EntityManager entityManager) {
        super(entityInformation, entityManager);

        // Keep the EntityManager around to used from the newly introduced methods.
        this.entityManager = entityManager;
    }

    @Transactional
    public <S extends T> S save(S entity) {
        // implementation goes here
        return null;
    }
}
