 package com.greatlearning.StudentDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.StudentDetails.model.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel, Integer>{

	//List<StudentModel> findStudentByName(String firstName);
//
//	Set<EmployeeModel> findByNameLike(String fName);


}
