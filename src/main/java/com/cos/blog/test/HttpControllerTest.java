package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML 파일)
// 사용자가 요청 -> 응답(Data)

@RestController
public class HttpControllerTest {
	
	private static final String TAG = "HttpControllerTest : ";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		//롬복을 사용하면 builder 패턴을 만들지 않고 @Build를 쓰면됨.
		Member m1 = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build();
		System.out.println(TAG + "getter :" + m1.getUsername());
		m1.setUsername("Allen");
		System.out.println(TAG + "setter :" + m1.getUsername());
		return "lombok Test 완료";
	}
	
	
	//인터넷 브라우저 요청은 무조건 get요청만 가능하다.
	//localhost:8080/http/get (SELECT)
	//public String getTest(@RequestParam int id,@RequestParam String username) = 1개씩 데이터 받기
	//[postman] get요청은 주소창에 데이터를 담아보냄.
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청 : " + m.getId() + " + " + m.getUsername() + " + " + m.getPassword() + " + " + m.getEmail();
	}
	
	/*
	//localhost:8080/http/post (INSERT)
	//[postman] post요청은 body에 데이터를 담아보냄.
	// [방식1 . x-www.from-urlencoded] , [방식2 . raw - json]
	@PostMapping("/http/post")
	public String postTest(Member m) {
		return "post 요청 : " + m.getId() + " + " + m.getUsername() + " + " + m.getPassword() + " + " + m.getEmail();
	}
	*/

	/*
	//[방식2-1 . raw - json] - @RequestBody <- 사용해야 변수를 받을 수 있다.
	@PostMapping("/http/post") // text/plain = 평문(raw)
	public String postTest(@RequestBody String text) {
		return "post 요청 : " + text;
	}
	*/
	
	//[방식2-2 . raw - json] - @RequestBody
	@PostMapping("/http/post") // application/json
	public String postTest(@RequestBody Member m) { // MessageConverter 가 알아서 변환해줌 (spring)
		return "post 요청 : " + m.getId() + " + " + m.getUsername() + " + " + m.getPassword() + " + " + m.getEmail();
	}
	
	//localhost:8080/http/put (UPDATE) <- body에 데이터를 실어 보낼경우 mapping해서 받을 수 있음.
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청" + m.getId() + " + " + m.getUsername() + " + " + m.getPassword() + " + " + m.getEmail();
	}
	
	//localhost:8080/http/delete (DELETE)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
