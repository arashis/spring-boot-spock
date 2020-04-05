package com.example.springbootmysql.repository

import com.example.springbootmysql.model.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
class BookRepositoryTest extends Specification {

    @Autowired
    BookRepository bookRepository

    def "findByBookId" () {
        given:
        def book = new Book(1, "my title 1", "my description 1", false)

        when:
        def response = bookRepository.findByBookId(1)

        then:
        assert response == book
    }

    def "save" () {
        given:
        def book = new Book()
        book.setTitle("my title 3")
        book.setDescription("my description 3")

        def expectedBook = new Book(3, "my title 3", "my description 3", false)
        when:
        def response = bookRepository.save(book)

        then:
        assert expectedBook == response
    }
}
