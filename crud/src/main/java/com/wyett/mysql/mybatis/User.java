package com.wyett.mysql.mybatis;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author : wyettLei
 * @date : Created in 2019/11/1 18:01
 * @description: TODO
 */

@Setter
@Getter
@ToString
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private String created;
    private String updated;
}
