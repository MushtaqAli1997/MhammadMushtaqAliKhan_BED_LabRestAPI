package com.greatlearning.StudentDetails.service;

import java.util.List;

import com.greatlearning.StudentDetails.model.StudentModel;

public interface StudentService {

	public List<StudentModel> listStudents();
	
	public String deleteStudent(int id);
	
	public StudentModel findStudentById(int id);
	
	public StudentModel addStudent(StudentModel student);
	
	public StudentModel updateStudentById(int id, StudentModel student);

	//public List<StudentModel> findStudentByName(String firstName);
}
