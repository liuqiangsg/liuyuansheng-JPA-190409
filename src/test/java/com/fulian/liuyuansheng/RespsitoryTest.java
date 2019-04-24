package com.fulian.liuyuansheng;

import org.junit.Test;
import org.springframework.data.repository.core.EntityInformation;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/**
 * RespsitoryTest
 *
 * @author liuqiang
 * @date 2019/4/12
 */
public class RespsitoryTest {

    @Test
    public void  testRepositoryFactory() {
        //RepositoryFactorySupport

        int a = "abcdi".indexOf("a");
        System.out.println(a);
    }
}
