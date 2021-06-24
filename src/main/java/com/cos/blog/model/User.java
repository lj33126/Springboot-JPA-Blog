package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


//ORM -> java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User Class가 mysql에 테이블이 생성됨.
public class User {

	@Id //primary_Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에 연결된 DB의 넘버링 전략을 따라감
	private int id;  //시퀀스 , auto_increment
	
	@Column(nullable = false, length = 30)
	private String username;
	
	@Column(nullable = false, length = 100) //100자리로 잡은이유 = 나중에 비밀번호를 암호화 할것임.
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault("' user'")
	private String role; //Enum을 쓰는게 좋다. //권한 : admin, user, manager //domain이 정해졌다 = 범위가 정해졌다.
	
	@CreationTimestamp // 시간이 자동입력됨.
	private Timestamp createDate;
}
