package com.example.bookcatalogservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.bookcatalogservice.dto.AssignBookDTO;
import com.example.bookcatalogservice.entity.Book;
import com.example.bookcatalogservice.entity.BookAssigned;
import com.example.bookcatalogservice.repository.AssignBookRepository;
import com.example.bookcatalogservice.repository.BookRepository;

@Transactional
@Service
public class BookService {

	private BookRepository bookRepository;
	private AssignBookRepository assignBookRepository;
	
	
	@Autowired
	public BookService(BookRepository bookRepository, AssignBookRepository assignBookRepository) {
		this.bookRepository = bookRepository;
		this.assignBookRepository = assignBookRepository;
	}

	
	public Optional<Book> saveBookToDatabase(Book book){		
		return Optional.of(this.bookRepository.save(book));
	}
	
	public Optional<List<Book>> saveBookSToDatabase(List<Book> books){	
		try {
			throw new RuntimeException();		
		}catch(Exception ex) {
			
		}
		return Optional.of(this.bookRepository.saveAll(books));
	}
	
	
	public Optional<List<Book>> getBookByBookName(String bookName){
		List<Book> books = this.bookRepository.getBookByBookName(bookName);
		return Optional.ofNullable(books);
	}
	
	public Optional<List<Book>> getBookByAuthor(String author){
		
		List<Book> books = this.bookRepository.getBookByAuthor(author);
		return Optional.ofNullable(books);
	}

	public Optional<List<Book>> getAllBooks() {
		return Optional.ofNullable(this.bookRepository.findAll());
	}
	
	public Optional<Book> addBook(Book book) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.bookRepository.save(book));
	}

	public Optional<List<Book>> addBooks(List<Book> book) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(this.bookRepository.saveAll(book));
	}

	public Optional<BookAssigned> assignBookToUser(AssignBookDTO assignBookDTO) {
		BookAssigned bookAssigned = new BookAssigned();
		bookAssigned.setBookId(assignBookDTO.getBookId());
		bookAssigned.setUserId(assignBookDTO.getUserId());
		return Optional.ofNullable(this.assignBookRepository.save(bookAssigned));
	}
	

}
