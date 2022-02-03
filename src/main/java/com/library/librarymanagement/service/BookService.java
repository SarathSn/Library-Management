package com.library.librarymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.librarymanagement.exception.UserNotFoundException;
import com.library.librarymanagement.model.Book;
import com.library.librarymanagement.repo.BookRepo;

@Service
public class BookService {
	
	private final BookRepo bookRepo;
	
	
	
	@Autowired
	public BookService(BookRepo bookRepo) {
		this.bookRepo=bookRepo;
	}

	
	  public Book addBook(Book book) {
	  
		Book newBook =  bookRepo.findByBookName(book.getBookName());
		
		if(newBook !=null)
		{
			long newQuantity = book.getAvailableQuantity();
			long oldQuantity = newBook.getAvailableQuantity();
			long totalQuantity = newQuantity + oldQuantity;
			newBook.setAvailableQuantity(totalQuantity);
			 return bookRepo.save(newBook);
		}
		else {
	  return bookRepo.save(book);
		}
	  }
	 
	
	public List<Book> printAllBook(){
		
		return bookRepo.findAll();
		}
	
	public List<Book> printByBookNameContaining(String ch) {
		
		return bookRepo.findByBookNameContaining(ch);
	}
}
