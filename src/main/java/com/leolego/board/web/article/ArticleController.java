package com.leolego.board.web.article;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leolego.board.domain.article.Article;
import com.leolego.board.domain.article.ArticleRepository;
import com.leolego.board.dto.ArticleRequestDto;

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
	
	@GetMapping("/addArticleForm")
	public String addArticleForm(Model model) {
		
		model.addAttribute("article", new Article());
		return "articles/addArticleForm";
	}
	
	@PostMapping("/addArticle")
	public String addArticle(@ModelAttribute("articleRequestDto") ArticleRequestDto articleRequestDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return "articles/addArticleForm";
		}
		
		Article article = new Article();
		article.setSubject(articleRequestDto.getSubject());
		article.setContent(articleRequestDto.getContent());
		
		Article savedArticle = articleRepository.save(article);
		redirectAttributes.addAttribute("articleId", savedArticle.getId());
		
		return "redirect:/articles/{articleId}";
		
	}
	
}
