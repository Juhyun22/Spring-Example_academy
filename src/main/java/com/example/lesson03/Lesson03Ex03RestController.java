package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;

@RestController 
public class Lesson03Ex03RestController {
	
	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost:8080/lesson03/ex03?id=24&review=도미노피자 역시 맛나!! 
	@RequestMapping("/lesson03/ex03")
	public String ex03(
			@RequestParam(value="id") int id,
			@RequestParam(value="review") String review) {
		
		int rowCount = reviewBO.updateReviewById(9, "도미노피자 역시 맛나!!");
		
		return "changed success" + rowCount;
	}

}
