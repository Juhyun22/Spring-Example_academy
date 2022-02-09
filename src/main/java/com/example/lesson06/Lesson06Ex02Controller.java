package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller
public class Lesson06Ex02Controller {

	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/add_name_view")
	public String add_name_view() {
		return "lesson06/addName";
	}
	
	@ResponseBody
	@RequestMapping("/is_duplication")
	public Map<String, Boolean> is_Duplication(
			@RequestParam("name") String name) {
		
		// 중복 확인 DB
		boolean is_duplication = userBO.existUserByName(name);
		
		// Map 구성 후 리턴 
		Map<String, Boolean> result = new HashMap<>();
		result.put("is_duplication", is_duplication);
		
		return result;
	}
}
