package com.library.librarymanagement.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Borrower {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,updatable = false)
	private long issueId;
	
	@Column(nullable = false)
	private long bookId;
	@Column(nullable = false)
	private long userId;
	
	private Date isuueDate;
	
	private Date returnDate;

	public long getIssueId() {
		return issueId;
	}

	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Date getIsuueDate() {
		return isuueDate;
	}

	public void setIsuueDate(Date isuueDate) {
		this.isuueDate = isuueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Borrower(long issueId, long bookId, long userId, Date isuueDate, Date returnDate) {
		super();
		this.issueId = issueId;
		this.bookId = bookId;
		this.userId = userId;
		this.isuueDate = isuueDate;
		this.returnDate = returnDate;
	}
	
	
}
