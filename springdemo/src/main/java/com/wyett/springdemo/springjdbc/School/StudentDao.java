package com.wyett.springdemo.springjdbc.School;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/15 18:28
 * @description: TODO
 */

public interface StudentDao {
    public void setDataSource(DataSource ds);
    public void create(String name, Integer age);
    public Student getStudent(String name);
    public List<Student> listStudent();
    public void delete(Integer id);
    public void update(Integer id, Integer age);
}
