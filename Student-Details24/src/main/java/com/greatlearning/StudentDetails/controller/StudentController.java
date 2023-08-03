package com.greatlearning.StudentDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.StudentDetails.model.StudentModel;
import com.greatlearning.StudentDetails.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping("/homepage")
	public String showAllStudents(Model theModel) {
		List<StudentModel> students = studentService.listStudents();
		theModel.addAttribute("student", students);
		return "student/homepage";
	}

	@RequestMapping("/addNewStudent")
	public String addNewStudent(Model theModel) {
		StudentModel student = new StudentModel();
		theModel.addAttribute("student", student);
		return "student/student-form-new";
	}

	@RequestMapping("/updateStudent1")
	public String updateStudent(@RequestParam("studentId") int id, Model theModel) {
		StudentModel studentDb = studentService.findStudentById(id);
		theModel.addAttribute("student", studentDb);
		return "student/student-form";
	}

	@RequestMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") StudentModel student) {
		studentService.addStudent(student);
		return "redirect:/student/homepage";
	}

	@RequestMapping("/deleteStudent")
	public String deleteStudent1(@RequestParam("studentId") int id) {
		studentService.deleteStudent(id);
		return "redirect:/student/homepage";
	}
	
	
	/*
	 * @GetMapping("/list") public List<StudentModel> getAllStudents() { return
	 * studentService.listStudents(); }
	 * 
	 * @PostMapping("/addStudent") public StudentModel
	 * addStudent(@RequestParam("firstName") String firstName,
	 * 
	 * @RequestParam("lastName") String lastName, @RequestParam("course") String
	 * course,
	 * 
	 * @RequestParam("country") String country) { StudentModel student = new
	 * StudentModel(); student.setFirstName(firstName);
	 * student.setLastName(lastName); student.setCourse(course);
	 * student.setCountry(country); return studentService.addStudent(student); }
	 * 
	 * @DeleteMapping("/deleteStudent") public String
	 * deleteStudent(@RequestParam("studentId") int id) {
	 * studentService.deleteStudent(id); return "Student has been deleted"; }
	 * 
	 * @PutMapping("/updateStudent") public StudentModel
	 * updateStudent(@RequestParam("studentId") int id, @RequestBody StudentModel
	 * student) { return studentService.updateStudentById(id, student);
	 * 
	 * }
	 */
	/*
	 * @GetMapping("/findStudentByName") public List<StudentModel>
	 * findByName(@RequestParam("firstName") String firstName) { return
	 * studentService.findStudentByName(firstName); }
	 */


}
