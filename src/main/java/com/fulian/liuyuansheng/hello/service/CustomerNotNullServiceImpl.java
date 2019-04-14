package com.fulian.liuyuansheng.hello.service;

import com.fulian.liuyuansheng.hello.dao.notnull.CustomerNotNullExtendCurdRepository;
import com.fulian.liuyuansheng.hello.dao.notnull.CustomerNotNullUnderNullAbleExtendCurdRepository;
import com.fulian.liuyuansheng.hello.dao.notnull.DAOImplTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CustomerNotNullServiceImpl
 *
 * @author liuqiang
 * @date 2019/4/11
 */
@Service
public class CustomerNotNullServiceImpl {

    @Autowired
    private CustomerNotNullExtendCurdRepository customerExtendCurdRepository;
    @Autowired
    CustomerNotNullUnderNullAbleExtendCurdRepository customerNotNullUnderNullAbleExtendCurdRepository;

    @Autowired
    private DAOImplTest daoImplTest;

    public Object getNonNullObj() {
        return customerExtendCurdRepository.findByLastName(null);
    }


    public  Object getNullAbleObj(){
        return customerNotNullUnderNullAbleExtendCurdRepository.findByLastName(null);
    }
}
