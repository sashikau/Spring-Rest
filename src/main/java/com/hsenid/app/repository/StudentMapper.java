package com.hsenid.app.repository;

import com.hsenid.app.domain.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by shashika on 12/7/15.
 */
public class StudentMapper implements RowMapper<Student>{

    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setName(rs.getString("name"));
        student.setMarks(rs.getInt("marks")+"");
        student.setId(rs.getInt("id")+"");
        return student;
    }
}

