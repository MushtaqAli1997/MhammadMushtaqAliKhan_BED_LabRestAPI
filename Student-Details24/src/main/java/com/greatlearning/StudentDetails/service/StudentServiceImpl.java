package com.greatlearning.StudentDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.StudentDetails.model.StudentModel;
import com.greatlearning.StudentDetails.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	
	

	@Override
	public List<StudentModel> listStudents() {
		return studentRepository.findAll();
	}

	@Override
	public String deleteStudent(int id) {
		studentRepository.deleteById(id);
		return "Student is deleted";

	}

	@Override
	public StudentModel findStudentById(int id) {
		return studentRepository.findById(id).get();

	}

	@Override
	public StudentModel addStudent(StudentModel student) {
		return studentRepository.save(student);
	}

	@Override
	public StudentModel updateStudentById(int id, StudentModel student) {
		StudentModel studentDb = studentRepository.findById(id).get();
		studentDb.setFirstName(student.getFirstName());
		studentDb.setLastName(student.getLastName());
		studentDb.setCourse(student.getCourse());
		studentDb.setCountry(student.getCountry());
		return studentRepository.save(studentDb);
	}

	/*@Override
	public List<StudentModel> findStudentByName(String firstName) {
		List<StudentModel> student =  studentRepository.findStudentByName(firstName);
		if(student.size() > 0) {
            return student;
        } else {
            return new ArrayList<StudentModel>();
        }*/


}
