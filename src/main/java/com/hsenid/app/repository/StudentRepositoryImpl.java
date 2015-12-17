package com.hsenid.app.repository;

import com.hsenid.app.domain.Student;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shashika on 12/7/15.
 */
public class StudentRepositoryImpl extends JdbcDaoSupport implements StudentRepository {

    @Override
    public void insert(Student student) {
        int id= Integer.parseInt(student.getId());
        int marks=Integer.parseInt(student.getMarks());
        String INSERT_SQL ="INSERT INTO student (id, name, marks) VALUES(?,?,?)";
        getJdbcTemplate().update(INSERT_SQL, new Object[]{id, student.getName(), marks});
    }

    @Override
    public Student findById(int id) {
        String FIND_SQL = "SELECT * FROM student WHERE id = ? ";
        return getJdbcTemplate().queryForObject(FIND_SQL, new Object[]{id}, new StudentMapper());

    }

    @Override
    public ArrayList<Student> getAll(){
        List<Student> list;
        String GET_ALL_SQL = "select * from student";
        list = getJdbcTemplate().query(GET_ALL_SQL, new StudentMapper());
        return new ArrayList<Student>(list);
    }

    @Override
    public void delete(int id){
        String SQL = "delete from student where id = ?";
        getJdbcTemplate().update(SQL, id);
    }

    @Override
    public boolean isAvailableId(int id) {
        String COUNT_SQL = "SELECT COUNT(*) FROM student WHERE id = ?";
        int count = getJdbcTemplate().queryForObject(COUNT_SQL, new Object[]{id}, Integer.class);
        return count != 0;
    }

    @Override
    public int getNumberOfRecords(){
        String NUMBER_OF_RECORDS_SQL = "SELECT COUNT(*) FROM student";
        return  getJdbcTemplate().queryForObject(NUMBER_OF_RECORDS_SQL, new Object[]{}, Integer.class);
    }

}
