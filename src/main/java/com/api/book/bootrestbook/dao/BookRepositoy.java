package com.api.book.bootrestbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.book.bootrestbook.entities.Book;

public interface BookRepositoy extends JpaRepository<Book, Integer>{

	public Book findById(int id);
}
