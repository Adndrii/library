package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String Name;
	
	@Column(name = "author")
	private String Author;
	
	@Column(name = "publishment")
	private String Publishment;
	
	@Column(name = "stock")
	private boolean Stock;
	
	@Column(name = "price")
	private Long Price;
	public Book() {
		
	}
	
	public Book(String name, String author, String publishment, boolean stock, Long price) {
		super();
		Name = name;
		Author = author;
		Publishment = publishment;
		Stock = stock;
		Price = price;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPublishment() {
		return Publishment;
	}
	public void setPublishment(String publishment) {
		Publishment = publishment;
	}
	public boolean getStock() {
		return Stock;
	}
	public void setStock(boolean stock) {
		Stock = stock;
	}

	public Long getPrice() {
		return Price;
	}

	public void setPrice(Long price) {
		Price = price;
	}
	

	
}
