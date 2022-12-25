package com.leolego.board.domain.article;

import lombok.Data;

@Data
public class Article {

	private Long id;
	private String subject;
	private String content;
	
	public Article() {
		
	}
	
	public Article(String subject, String content) {
		this.subject = subject;
		this.content = content;
		
	}
}
