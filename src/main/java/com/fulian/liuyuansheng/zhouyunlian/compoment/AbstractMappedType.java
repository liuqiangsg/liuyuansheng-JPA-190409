package com.fulian.liuyuansheng.zhouyunlian.compoment;

import lombok.*;

import javax.persistence.MappedSuperclass;

/**
 * AbstractMappedType
 *
 * @author liuqiang
 * @date 2019/4/15
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public  abstract   class AbstractMappedType {

    private     String attribute;

}
