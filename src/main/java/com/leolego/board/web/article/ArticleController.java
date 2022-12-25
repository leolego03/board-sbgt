package com.leolego.board.web.article;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leolego.board.domain.article.Article;
import com.leolego.board.domain.article.ArticleRepository;

@Slf4j
@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

	private final ArticleRepository articleRepository;
	
	@GetMapping
	public String articles(Model model) {
		List<Article> articles = articleRepository.findAll();
		model.addAttribute("articles", articles);
		return "articles/articles";
		
	}
	
	@GetMapping("/{articleId}")
	public String article(@PathVariable long articleId, Model model) {
		Article article = articleRepository.findById(articleId);
		model.addAttribute("article", article);
		return "articles/article";
		
	}
}
