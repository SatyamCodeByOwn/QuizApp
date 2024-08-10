package com.QuizApp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizApp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{
	
}
