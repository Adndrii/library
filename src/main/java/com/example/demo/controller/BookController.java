package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	//handler method to handle list books and return mode and view
	@GetMapping("/books")
	public String listBooks(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
	}
	
	@GetMapping("/books/new")
	public String CreateBookForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "create_book";
	}
	
	@PostMapping("/books")
	public String SaveBook(@ModelAttribute("book") Book book) {
		bookService.saveBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/edit/{id}")
	public String EditBookForm(@PathVariable Long id, Model model) {
		model.addAttribute("book", bookService.getBookById(id));
		return "edit_book";
	}
	
	@PostMapping("/books/{id}")
	public String updateBook(@PathVariable Long id,
			@ModelAttribute("book") Book book,
			Model model) {
		
		Book existingBook = bookService.getBookById(id);
		
		existingBook.setId(id);
		existingBook.setName(book.getName());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setPublishment(book.getPublishment());
		
		bookService.editBook(existingBook);
		return "redirect:/books";
	}

	 @GetMapping("/books/delete/{id}")
	    public String deleteBook(@PathVariable Long id, Model model) {
	        Book bookToDelete = bookService.getBookById(id);

	        if (bookToDelete != null) {
	            bookService.deleteBook(bookToDelete);
	            model.addAttribute("deleteMessage", bookToDelete.getName() + " has been removed from the list.");
	        } else {
	            model.addAttribute("deleteMessage", "Book with ID " + id + " not found.");
	        }

	        return "delete_book";
	        //return "redirect:/books";
	    }
}
