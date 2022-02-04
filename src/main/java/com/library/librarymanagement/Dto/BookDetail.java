package com.library.librarymanagement.Dto;

import java.sql.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;




public class BookDetail {
	
	private String bookName;
	private long availableQuantity;
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date returnDate;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public long getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(long availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
}
