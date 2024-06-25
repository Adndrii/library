package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.BookRepository;
import com.example.demo.entity.Book;


@SpringBootApplication
public class PracticeExerciseApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PracticeExerciseApplication.class, args);
	}
	
	
	@Autowired
	private BookRepository bookRepository;
	@Override
	public void run(String... args) throws Exception {
		
		
	}

}
