package com.library.librarymanagement.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.librarymanagement.Dto.BookDetail;
import com.library.librarymanagement.model.Book;
import com.library.librarymanagement.model.Borrower;

//public String bookDetails = ("SELECT books.bookName as Book_Name, books.availableQuantity as Available_Quantity,users.userName as User_Name,issue_book.return_date as Return_Date FROM issue_book INNER JOIN books ON issue_book.bookId=books.bookId inner join users on issue_book.userId=users.userId where issue_book.bookId = ?");
@Repository
public interface BorrowerRepo extends JpaRepository<Borrower,Long> {
	
	@Query(value="SELECT b.book_name, b.available_quantity,u.user_name ,bs.return_date FROM borrower bs INNER JOIN book b ON bs.book_id=b.book_id inner join User u on bs.user_id=u.user_id where bs.book_id = ?1",nativeQuery = true)
	List<Object[]> findByBookId(long bookId);
}
