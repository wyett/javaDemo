package com.wyett.springdemo.springjdbc.School;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author : wyettLei
 * @date : Created in 2019/10/15 18:45
 * @description: TODO
 */

public class StudentMapper implements RowMapper<Student>{
    @Override
    public Student mapRow(ResultSet rs, int rowid) throws SQLException{
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setAge(rs.getInt("age"));
        student.setName(rs.getString("name"));
        return student;
    }
}
