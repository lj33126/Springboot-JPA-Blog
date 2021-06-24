package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //auto-incremnet
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob //대용량데이터
	private String content;
	
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne 		// Many = Board , User = one 하나의 유저는 여러개의 게시글을 쓸수 있다.
	@JoinColumn(name="userId") //FK로 들어감.
	private User user; //DB는 오브젝트를 저장할 수 없다.  --> 충돌 <--   FKㅡ 자바는 오브젝틀를 저장할 수 있다.
	
	@CreationTimestamp
	private Timestamp createDate;
}
