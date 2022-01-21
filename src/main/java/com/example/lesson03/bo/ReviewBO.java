package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.dao.ReviewDAO;
import com.example.lesson03.model.Review;

@Service
public class ReviewBO {
	@Autowired
	private ReviewDAO reviewDAO;
	
	public Review getReview(int id) {
		return reviewDAO.selectReview(id);
	}
	
	public int addReview(Review review) { // 몇행이 insert 되었는지 int로 넣으면 알 수 있음 
		return reviewDAO.insertReview(review);
	}
	
	public int addReviewAsField(int storeId, String menu, String userName, 
			Double point, String review) {
		
		return reviewDAO.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	public int updateReviewById(int id, String review) {
		return reviewDAO.updateReviewById(id, review);
	}
	
	public int deleteReviewById(int id) {
		return reviewDAO.deleteReviewById(id);
	}
}
