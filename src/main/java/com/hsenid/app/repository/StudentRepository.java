package com.hsenid.app.repository;
import com.hsenid.app.domain.Student;
import java.util.ArrayList;

/**
 * Created by shashika on 12/7/15.
 */
public interface StudentRepository {

    void insert(Student student) throws  Exception;

    Student findById(int id) throws Exception;

    ArrayList<Student> getAll();

    void delete(int id);

    boolean isAvailableId(int id);

    int getNumberOfRecords();
}
