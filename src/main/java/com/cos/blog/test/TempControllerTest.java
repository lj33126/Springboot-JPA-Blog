package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	//localhost:8080/blog/temp/home
	@GetMapping("/temp/home")
	public String TempHome() {
		System.out.println("temphome()");
		//파일리턴 기본경로: src/main/resources/static
		//리턴명: /home.html   <-- /를 꼭 붙여줘야함.
		return "/home.html"; //TempHome 을 요청하면 home.html을 리턴해줄게
	}
}
