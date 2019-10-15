package com.wyett.springdemo.springjdbc.School;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/15 19:16
 * @description: TODO
 */

public class StudentJDBCTemplate implements StudentDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String name, Integer age) {
        String SQL = "insert into Student (name, age) values (?, ?)";
        jdbcTemplateObject.update( SQL, name, age);
        System.out.println("Created Record Name = " + name + " Age = " + age);
        return;
    }

    @Override
    public Student getStudent(String name) {
        String SQL = "select * from Student where id = ?";
        Student student = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{name}, new StudentMapper());
        return student;
    }

    @Override
    public List<Student> listStudent() {
        String SQL = "select * from Student";
        List <Student> students = jdbcTemplateObject.query(SQL,
                new StudentMapper());
        return students;
    }

    @Override
    public void delete(Integer id){
        String SQL = "delete from Student where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

    @Override
    public void update(Integer id, Integer age){
        String SQL = "update Student set age = ? where id = ?";
        jdbcTemplateObject.update(SQL, age, id);
        System.out.println("Updated Record with ID = " + id );
        return;
    }
}
