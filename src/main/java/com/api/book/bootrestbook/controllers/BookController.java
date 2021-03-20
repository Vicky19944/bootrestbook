package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {

		List<Book> list = bookService.getAllbooks();

		if (list.size() <= 0) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {

		Book book = bookService.getBookById(id);

		if (book == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(book));
	}

	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b = this.bookService.addBook(book);

		if (b == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

		return ResponseEntity.of(Optional.of(b));
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") int id) {
		
		this.bookService.deleteBook(id);
		System.out.println("Deleted");
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/books/{bookid}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookid") int bookid) {
		this.bookService.updateBook(book, bookid);
		return book;
	}

}
