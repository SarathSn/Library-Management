package com.library.librarymanagement.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.librarymanagement.Dto.BookDetail;
import com.library.librarymanagement.model.Book;
import com.library.librarymanagement.model.Borrower;
import com.library.librarymanagement.model.User;
import com.library.librarymanagement.repo.BookRepo;
import com.library.librarymanagement.repo.BorrowerRepo;

@Service
public class BorrowerService {

	private final BorrowerRepo borrowerRepo;
	private final BookRepo bookRepo;
	private EntityManager em;
	
	@Autowired
	public BorrowerService(BorrowerRepo borrowerRepo,BookRepo bookRepo) {
		
		this.borrowerRepo = borrowerRepo;
		this.bookRepo = bookRepo;
	}
	
	public Borrower addBorrower(Borrower  borrower) {
	
	LocalDate dateObj = LocalDate.now();
 	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 
 
 	String todayDate = dateObj.format(formatter);
 	// System.out.println(issueDate);
 
 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
 
 	//create instance of the Calendar class and set the date to the given date  
 	Calendar cal = Calendar.getInstance();
 		try
 			{  
 				cal.setTime(sdf.parse(todayDate));  
 			}
 			catch(ParseException e)
 			{  
 				//e.printStackTrace();  
 				System.out.println(e.getMessage());
 			}  
      
 			// use add() method to add the days to the given date  
 			cal.add(Calendar.DAY_OF_MONTH, 7);  
 			String dateAfter = sdf.format(cal.getTime());
 			
 			borrower.setIsuueDate(Date.valueOf(todayDate));
 			borrower.setReturnDate(Date.valueOf(dateAfter));
  
 			// issueDate = Date.valueOf(todayDate);
 			 //returnDate =Date.valueOf(dateAfter);
 			long id =borrower.getBookId();
 			Book Book =  bookRepo.findByBookId(id);
 			
 			long newQuantity = Book.getAvailableQuantity();
 			
 			long Quantity= newQuantity - 1;
 			
 			Book.setAvailableQuantity(Quantity);
 			bookRepo.save(Book);
	
		return borrowerRepo.save(borrower);
		
	
	}
	
	public List<BookDetail> viewDetail(long id){
		
		
		List<BookDetail> result = new ArrayList<>() ;
		
		List<Object[]> temp = borrowerRepo.findByBookId(id);
		temp.forEach(x->{
			BookDetail entity = new BookDetail();
			String res = x[0].toString();
			entity.setBookName(res);
			entity.setAvailableQuantity(Long.parseLong(x[1].toString()));
			entity.setUserName(x[2].toString());
			entity.setReturnDate(Date.valueOf(x[3].toString()));
			result.add(entity);
		});
		for(int i=0;i<result.size();i++) {
		System.out.println("what is this"+result.get(i).getBookName());
		}
		return result;
	}
	
	
	
}
