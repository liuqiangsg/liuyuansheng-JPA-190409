package com.fulian.liuyuansheng.zhouyunlian.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User
 *
 * @author liuqiang
 * @date 2019/4/13
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id;

    private  String userName;


}
