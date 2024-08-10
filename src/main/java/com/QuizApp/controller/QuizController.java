package com.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.QuizApp.model.QuestionWrapper;
import com.QuizApp.model.Response;
import com.QuizApp.service.QuizService;

@RestController 
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
		return quizService.createQuiz(category,numQ,title);
	}
	
	@GetMapping("/get/{Id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer Id){
		return quizService.getQuizQuestions(Id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
		return quizService.calculateResult(id,responses);
	}
}
