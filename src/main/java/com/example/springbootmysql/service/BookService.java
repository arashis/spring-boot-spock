package com.example.springbootmysql.service;

import com.example.springbootmysql.model.Book;
import com.example.springbootmysql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(int bookId) {
        return bookRepository.findByBookId(bookId);
    }

    public int addBook(Book book) {
        return bookRepository.save(book).getBookId();
    }
}
