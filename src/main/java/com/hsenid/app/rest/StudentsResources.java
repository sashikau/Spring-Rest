package com.hsenid.app.rest;
import com.hsenid.app.domain.Response;
import com.hsenid.app.domain.Student;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.hsenid.app.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/students")
public class StudentsResources {

	private StudentService studentService;
	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
	@GET
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Response getDetails(@PathParam("id") String id) {

		return studentService.getStudent(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("/save")
	public Response insertStudent(Student student) {

		 return studentService.saveStudent(student);
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
