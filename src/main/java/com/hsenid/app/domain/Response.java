package com.hsenid.app.domain;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by shashika on 12/15/15.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Response {

	private String statusCode;
	private String description;
	private Student student;

	public Response() {

	}

	public Response(String statusCode, String description) {
		this.statusCode = statusCode;
		this.description = description;
	}

	public Response(Student student, String statusCode, String description){
		this.student=student;
		this.statusCode=statusCode;
		this.description=description;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


}
