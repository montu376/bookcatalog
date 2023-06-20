package com.example.bookcatalogservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.bookcatalogservice.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	@Query(value="SELECT * from Book b WHERE b.book_name LIKE %?1%", 
			nativeQuery=true)
	public ArrayList<Book> getBookByBookName(String bookName);
	
	@Query(value="SELECT * from Book b WHERE b.book_author LIKE %?1%",
			nativeQuery=true)
	public ArrayList<Book> getBookByAuthor(String author);
	
}
