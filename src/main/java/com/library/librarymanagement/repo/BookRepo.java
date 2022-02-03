package com.library.librarymanagement.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.librarymanagement.model.Book;

public interface BookRepo extends JpaRepository<Book,Long> {
	List<Book> findByBookNameContaining(String ch);
	Book findByBookName(String bookName);

}
