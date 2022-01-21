package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RequestMapping("/lesson03/ex02")
@RestController
public class Lesson03Ex02RestController {
	
	@Autowired
	private ReviewBO reviewBO;

	// http://localhost:8080/lesson03/ex02/1
	@RequestMapping("/1")
	public String ex02_1() {
		Review review = new Review();
		review.setStoreId(7);
		review.setMenu("삼겹혼밥세트");
		review.setUserName("박보라");
		review.setPoint(4.5);
		review.setReview("밥을 혼자 먹어요.");
		
		int rowCount = reviewBO.addReview(review);  // insert된 row의 수를 얻는다.
		
		return "success row count " + rowCount;
	}
	
	// http://localhost:8080/lesson03/ex02/2
	@RequestMapping("/2")
	public String ex02_2() {
		int rowCount = reviewBO.addReviewAsField(4, "콤비네이션R", "나는보라해", 5.0, "맛있어요!!");
		return "succcess row count : " + rowCount;
	}
}
