package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.model.Student;

@RequestMapping("/lesson04/ex02")
@Controller
public class StudentController {
	
	@Autowired
	private StudentBO studentBO;

	// http://localhost:8080/lesson04/ex02/1 -> 학생 추가 화면 
	@GetMapping("/1")
	public String ex02_1() {
		return "lesson04/addStudent";
	}
	
	// http://localhost:8080/lesson04/ex02/add_student
	@PostMapping("/add_student")
	public String addStudent(
			@ModelAttribute Student student,
			Model model// name 속성의 이름과 일치하는 필드에 값이 들어갔다.
			) {
		// db insert
		studentBO.addStudent(student);

		// db select
		Student result = studentBO.getStudentById(student.getId());
		model.addAttribute("result", result);
		model.addAttribute("subject", "학생 정보");
		
		return "lesson04/afterAddStudent"; // 추가된 학생 정보 jsp 
	}
}
