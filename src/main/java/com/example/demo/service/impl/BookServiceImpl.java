package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.demo.service.BookService;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	
	private BookRepository bookRepository;
	
	
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}


	@Override
	public List<Book> getAllBooks(){
	
		return bookRepository.findAll();
	}
	
	public Book saveBook(Book book){
		return bookRepository.save(book);
	}
	
	public Book getBookById(Long id) {
		return bookRepository.findById(id).get();
	}
	
	
	
	public Book editBook(Book book) {
		return bookRepository.save(book);
	}
	public void  deleteBook(Book book) {
		bookRepository.delete(book);
	}
}
