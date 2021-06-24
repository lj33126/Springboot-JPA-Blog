package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@Getter
//@Setter
//@RequiredArgsConstructor
@Data //Getter + Setter
//@AllArgsConstructor //생성자 생성
@NoArgsConstructor
public class Member {
	
	//private로 만드는 이유: 변수에 바로 접근해서 수정하는건 객체지향과는 맞지 않다.
	// 변수에 다이렉트로 접근 못하게 private로 만들고 함수를 통해서 접근하게 만들어야 한다.
	// 변수의 상태는 메서드를 통해 변경되게 만들어야 한다.
	// final 쓰는 이유: 데이터가 변경되지 않게, 브이변성?
	
	private int id;
	private  String username;
	private  String password;
	private  String email;
	
	@Builder //시퀀스 자동생성해주는 어노테이션. 컨트롤러에서 .builder 사용
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
}
