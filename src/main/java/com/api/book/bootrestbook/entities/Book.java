package com.api.book.bootrestbook.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity

public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int book_id;

	private String book_name;
	private String anuther_name;

	public Book(int book_id, String book_name, String anuther_name) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.anuther_name = anuther_name;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAnuther_name() {
		return anuther_name;
	}

	public void setAnuther_name(String anuther_name) {
		this.anuther_name = anuther_name;
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", anuther_name=" + anuther_name + "]";
	}

}
