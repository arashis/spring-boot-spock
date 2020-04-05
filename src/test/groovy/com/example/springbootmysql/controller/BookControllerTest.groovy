package com.example.springbootmysql.controller

import com.example.springbootmysql.model.Book
import com.example.springbootmysql.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class BookControllerTest extends Specification {

    def "method test getBook"() {
        given:
        def target = new BookController()
        target.bookService = Mock(BookService)
        _ * target.bookService.getBook(_) >> new Book(1, "my title", "my description", false)

        when:
        def response = target.getBook(1)

        then:
        assert response.getStatusCode() == HttpStatus.OK
        assert response.getBody() == new Book(1, "my title", "my description", false)
    }

    def "api test getBook"() {
        given:
        def target = new BookController()
        def mockMvc = MockMvcBuilders.standaloneSetup(target).build()
        target.bookService = Mock(BookService)
        1 * target.bookService.getBook(1) >> new Book(1, "my title", "my description", false)

        when:
        def response = mockMvc.perform(get("/book/1"))

        then:
        response.andExpect(status().isOk())
        assert response.andReturn().getResponse().getContentAsString() == '{"bookId":1,"title":"my title","description":"my description","deleteFlag":false}'
    }

    @Unroll
    def "api test getBook bookId = #bookId, titile = #title"() {
        given:
        def target = new BookController()
        def mockMvc = MockMvcBuilders.standaloneSetup(target).build()
        target.bookService = Mock(BookService)
        1 * target.bookService.getBook(bookId) >> new Book(bookId, title, description, false)

        when:
        def response = mockMvc.perform(get("/book/" + bookId))

        then:
        response.andExpect(status().isOk())
        assert response.andReturn().getResponse().getContentAsString() == expectedResponseBody

        where:
        bookId | title        | description        || expectedResponseBody
        1      | "my title 1" | "my description 1" || '{"bookId":1,"title":"my title 1","description":"my description 1","deleteFlag":false}'
        2      | "my title 2" | "my description 2" || '{"bookId":2,"title":"my title 2","description":"my description 2","deleteFlag":false}'
    }

    def "addBook"() {
        given:
        def target = new BookController()
        def mockMvc = MockMvcBuilders.standaloneSetup(target).build()
        target.bookService = Mock(BookService)
        def request = new StringBuffer()
                .append('{')
                .append('"title": "my title",')
                .append('"description": "my description"')
                .append('}')
                .toString()
        def book = new Book()
        book.setTitle("my title")
        book.setDescription("my description")
        1 * target.bookService.addBook(book) >> 1

        when:
        def response = mockMvc.perform(post("/book/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))

        then:
        response.andExpect(status().isCreated())
        assert response.andReturn().getResponse().getContentAsString() == "1"
    }
}
