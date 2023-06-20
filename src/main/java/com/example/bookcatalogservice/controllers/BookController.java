package com.example.bookcatalogservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookcatalogservice.dto.AssignBookDTO;
import com.example.bookcatalogservice.dto.BookDTO;
import com.example.bookcatalogservice.entity.Book;
import com.example.bookcatalogservice.services.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity addBookToDatabase(@RequestBody Book book ) {		
		return ResponseEntity.ok(this.bookService.addBook(book));
	}
	
	@PostMapping("/addbooks")
	@ResponseBody
	public ResponseEntity addBooksToDatabase(@RequestBody List<Book> book) {		
		return ResponseEntity.ok(this.bookService.addBooks(book));
	}
	
	@GetMapping("/getallbooks")
	@ResponseBody
	public ResponseEntity getAllBooks() {	
		BookDTO bookDto =  new BookDTO();
		Optional<List<Book>> books = this.bookService.getAllBooks();
		bookDto.setBookCount(books.get().size());
		bookDto.setBooks(books.get())	;
		return ResponseEntity.ok(bookDto);
	}
	
	@GetMapping("/getbooksbyauthor/author={author}")
	@ResponseBody
	public ResponseEntity getBooksByAuthor(@PathVariable String author) {		
		return ResponseEntity.ok(this.bookService.getBookByAuthor(author));
	}
	
	@GetMapping("/getbooksbybookname/bookname={bookName}")
	@ResponseBody
	public ResponseEntity getBooksByBookName(@PathVariable String bookName) {		
		return ResponseEntity.ok(this.bookService.getBookByBookName(bookName));
	}
	
	@PostMapping("/book/assign")
	@ResponseBody
	public ResponseEntity assignBookToUser(@RequestBody AssignBookDTO assignBookDTO) {		
		return ResponseEntity.ok(this.bookService.assignBookToUser(assignBookDTO));
	}
	
	
	
}
