package com.library.librarymanagement.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.librarymanagement.Dto.BookDetail;
import com.library.librarymanagement.model.Book;
import com.library.librarymanagement.model.Borrower;
import com.library.librarymanagement.model.User;
import com.library.librarymanagement.repo.BookRepo;
import com.library.librarymanagement.service.BookService;
import com.library.librarymanagement.service.BorrowerService;
import com.library.librarymanagement.service.UserService;

@RestController
@RequestMapping("/Book")
public class BookController {
	
	public final BookService bookService;
	public final UserService userService;
	public final BorrowerService borrowerService;
	
	
	public BookController(BookService bookService,UserService userService,BorrowerService borrowerService) {
		this.bookService=bookService;
		this.userService=userService;
		this.borrowerService=borrowerService;
		
	}

	@PostMapping("/add")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		//System.out.println("inside /add");
		Book newBook = bookService.addBook(book);
		return new ResponseEntity<>(newBook,HttpStatus.OK);	
	}
	@GetMapping("/all")
	public ResponseEntity<List<Book>> getallBook(){
		
		List<Book> books = bookService.printAllBook();
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	
	@GetMapping("/find/{ch}")
	public ResponseEntity<List<Book>> getbookLike(@PathVariable("ch") String ch){
		
		List<Book> books = bookService.printByBookNameContaining(ch);
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		//System.out.println("inside /add");
		User newuser = userService.addUser(user);
		return new ResponseEntity<>(newuser,HttpStatus.OK);	
	}
	
	@PostMapping("/addBorrower")
	public ResponseEntity<Borrower> addBorrower(@RequestBody Borrower borrower)
	{
		//System.out.println("inside /add");
		Borrower newBorrower = borrowerService.addBorrower(borrower);
		return new ResponseEntity<>(newBorrower,HttpStatus.OK);	
	}
	
	@GetMapping("/bookDetails/{id}")
	public ResponseEntity<List<BookDetail>> viewDetails(@PathVariable("id") long id)
	{
		List<BookDetail> issueBook = borrowerService.viewDetail(id);
		return new ResponseEntity<>(issueBook,HttpStatus.OK);	
	}
}
