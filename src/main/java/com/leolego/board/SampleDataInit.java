package com.leolego.board;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.leolego.board.domain.article.Article;
import com.leolego.board.domain.article.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SampleDataInit {

	private final ArticleRepository articleRepository;
	
	@PostConstruct
	public void init() {
		articleRepository.save(new Article("Sample article",
										   "I like freestyle the most among swimming methods."));
		articleRepository.save(new Article("Second Sample article",
				   						   "The most important thing in swimming is kicking."));

	}
}
