package com.hsenid.app.service;

import com.hsenid.app.domain.Response;
import com.hsenid.app.domain.Student;
import com.hsenid.app.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Created by shashika on 12/15/15.
 */
public class StudentService {

	private StudentRepository studentRepository;
	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Response getStudent(String id){

		try{
			int studentId=Integer.parseInt(id);
			if (studentRepository.isAvailableId(studentId)) {
				Student student = studentRepository.findById(studentId);
				if(student!=null) {
					Response response = new Response(student, "Success", "Successfully retrieved");
					logger.info("Student id[{}] is retrieved successfully ", student.getId());
					return response;
				}else {
					logger.info("Error occurred while finding the student id[{}]", id);
					return new Response("Failed", "Invalid ID");
				}
			} else {
				logger.info("No record for the student id[{}]", id);
				return new Response("Failed", "Invalid ID");
			}
		}catch (Exception e){
			logger.info("Type mismatched for PRIMARY key[{}]", id);
			return new Response("Failed", "Check the student ID");
		}

	}

	public Response saveStudent(Student student){

		try{
			int studentId=Integer.parseInt(student.getId());

			if (studentRepository.isAvailableId(studentId)) {
				logger.info("Duplicate entry for PRIMARY key[{}]", student.getId());
				return new Response("Failed", "Duplicate entry for student id");
			} else if (student.getName().isEmpty() || student.getName().replaceAll("\\s+", "").isEmpty()) {
				logger.info("Invalid name for student ID[{}]", student.getId());
				return new Response("Failed", "Check the student name");
			} else {
				try {
					int studentMarks=Integer.parseInt(student.getMarks());
					if (studentMarks< 0 || studentMarks > 100) {
						logger.info("Invalid marks[{}] for student ID [{}]", student.getMarks(), student.getId());
						return new Response("Failed", "Invalid value for marks");
					} else {
						studentRepository.insert(student);
						logger.info("Student id[{}] is inserted to the database", student.getId());
						return new Response(student, "Success", "Successfully inserted");
					}
				}catch (Exception e){
					logger.info("Invalid marks[{}] for student ID [{}]", student.getMarks(), student.getId());
					return new Response("Failed", "Invalid value for marks");
				}
			}
		}catch (Exception e){
			logger.info("Type mismatched for PRIMARY key[{}]",student.getId());
			return new Response("Failed", "Invalid student id");
		}
	}
}
