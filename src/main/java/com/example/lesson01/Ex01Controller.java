package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class Ex01Controller {
	
	// String 출력하기 
	// http://localhost:8080/lesson01/ex01/1
	@ResponseBody   // return되는 값을 response로 보낸다. 
	@RequestMapping("/lesson01/ex01/1")     // 주소를 mapping 
	public String printString() {
		String text = "<h1>예제 1번</h1> 문자열을 response body로 보내는 예제";
		return text;
	}
	
	// Map 리턴하기 => JSON return 
	// http://localhost:8080/lesson01/ex01/2
	@RequestMapping("/lesson01/ex01/2")
	public @ResponseBody Map<String, Object> printMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("apple", 4);
		map.put("banana", 10);
		map.put("orange", 125);
		map.put("grape", 167);
		
		// Map을 return하면, json으로 나타낸다. 
		// Web starter에 Jackson 라이브러리가 포함되어 있기 때문 
		return map;
	}
}
