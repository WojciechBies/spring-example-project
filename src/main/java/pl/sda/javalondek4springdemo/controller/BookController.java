package pl.sda.javalondek4springdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.sda.javalondek4springdemo.model.Book;
import pl.sda.javalondek4springdemo.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    // TODO: kolejność budowania aplikacji - kroki:)
    // dtos
    // exceptions
    // baza - entities

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {

        logger.info("getAllBooks()");

        return bookService.findAllBooks();
    }

    // /books/1
    // /books/101
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        logger.info("find book by id: [{}]", id);

        return bookService.findBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book toSave) {
        logger.info("adding book: [{}]", toSave);

        return bookService.saveBook(toSave);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") Long id) {
        logger.info("deleting boo by id: [{}]", id);
        bookService.deleteBookById(id);
    }

    // full update (replace)
    @PutMapping("/{id}")
    public Book replaceBook(@PathVariable("id") Long id, @RequestBody Book toReplace) {
        logger.info("Replacing book with new one: [{}]", toReplace);

        return bookService.replaceBook(id, toReplace);

    }

    // update (partial)
    @PatchMapping("/{id}")
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book toUpdate) {
        logger.info("updating book with new attributes: [{}]", toUpdate);

        return bookService.updateBookWithAttributes(id, toUpdate);
    }
}
