package com.fulian.liuyuansheng.zhouyunlian.domain;

/**
 * Customer
 *
 * @author liuqiang
 * @date 2019/4/9
 */
import com.fulian.liuyuansheng.zhouyunlian.compoment.AbstractMappedType;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer  extends AbstractMappedType implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    @org.springframework.data.annotation.Version
    String version;

    public  Customer(String firstName,String lastName,String version) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.version = version;
    }


}