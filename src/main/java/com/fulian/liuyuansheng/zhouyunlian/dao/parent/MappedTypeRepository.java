package com.fulian.liuyuansheng.zhouyunlian.dao.parent;

import com.fulian.liuyuansheng.zhouyunlian.compoment.AbstractMappedType;
import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * MappedTypeRepository
 *
 * @author liuqiang
 * @date 2019/4/15
 */
@NoRepositoryBean
public interface MappedTypeRepository<T extends AbstractMappedType>  extends Repository<T,Long> {

    @Query("select  t from  #{#entityName} t   where  t.attribute = :attribute")
    List<T>  findAllByAttribute(@Param("attribute") String attribute);
}
