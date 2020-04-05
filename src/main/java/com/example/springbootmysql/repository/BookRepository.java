package com.example.springbootmysql.repository;

import com.example.springbootmysql.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Override
    List<Book> findAll();

    Book findByBookId(Integer id);

    @Override
    @Transactional
    Book save(Book book);
}
