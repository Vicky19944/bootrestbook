package com.api.book.bootrestbook.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepositoy;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

//	private static List<Book> list = new ArrayList<>();

	/*static {

		list.add(new Book(11, "Java1", "Abc"));
		list.add(new Book(12, "Java2", "Xyz"));
		list.add(new Book(11, "Java3", "Lmn"));
	}
*/
	@Autowired
	private BookRepositoy bookRepositiry;
	
	// Get all books

	public List<Book> getAllbooks() {
		List<Book> findAll = this.bookRepositiry.findAll();

	 return findAll;

	}    

	// Get Single book by id

	public Book getBookById(int id) {
		Book book = null;
		book =this.bookRepositiry.findAll().stream().filter(e -> e.getBook_id() == id).findFirst().get();
		return book;
	}

	// Adding the books

	public Book addBook(Book b) {

		Book save = this.bookRepositiry.save(b);

		return save;
	}

	// Deleting books

	public void deleteBook(int id) {
		this.bookRepositiry.findAll().stream().filter(b -> b.getBook_id() != id).collect(Collectors.toList());
         
	}

	// Updating books

	public Book updateBook(Book book, int bookid) {

	/*	this.bookRepositiry.findAll().stream().map(b -> {
			if (b.getBook_id() == bookid) {
				b.setAnuther_name(book.getAnuther_name());
				b.setBook_name(book.getBook_name());
			}
			return b;

		}).collect(Collectors.toList()); */
		
		book.setBook_id(bookid);
		Book save = this.bookRepositiry.save(book);

		return save;

	}

}
