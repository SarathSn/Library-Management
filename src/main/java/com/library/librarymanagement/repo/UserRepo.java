package com.library.librarymanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.librarymanagement.model.Book;
import com.library.librarymanagement.model.User;

public interface UserRepo extends JpaRepository<User,Long> {

}
