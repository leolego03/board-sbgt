package com.leolego.board.domain.article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepository {

	private static final Map<Long, Article> staticArticle = new HashMap<>();
	private static long sequence = 0L;
	
	public Article save(Article article) {
		article.setId(++sequence);
		staticArticle.put(article.getId(), article);
		return article;
		
	}
	
	public Article findById(Long id) {
		return staticArticle.get(id);
		
	}
	
	public List<Article> findAll() {
		return new ArrayList<>(staticArticle.values());
		
	}
	
	public void update(Long articleId, Article updateParam) {
		Article findArticle = findById(articleId);
		findArticle.setSubject(updateParam.getSubject());
		findArticle.setContent(updateParam.getContent());
		
	}
	
	public void clearArticleMap() {
		staticArticle.clear();
		
	}
}
