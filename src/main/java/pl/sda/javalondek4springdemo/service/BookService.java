package pl.sda.javalondek4springdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.sda.javalondek4springdemo.exception.BookNotFoundException;
import pl.sda.javalondek4springdemo.model.Book;
import pl.sda.javalondek4springdemo.repository.BookRepository;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {

        var result = bookRepository.findAllBooks();

        logger.info("number of found books: [{}]", result.size());
        logger.debug("result: {}", result);

        return result ;
    }

    public Book findBookById(long id) {

        Objects.requireNonNull(id, "id parameter must not be null!!!");
        var result = bookRepository.findAllBooks()
                .stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(String.format("No book with id: %d", id)));

        logger.info("book found for id: [{}] is [{}]", id, result);
        return result;
    }

    public Book saveBook(Book toSave) {

        var max = findAllBooks().stream().mapToLong(book -> book.getId()).max().orElse(1L);
        toSave.setId(++max);
        bookRepository.findAllBooks().add(toSave);
        logger.info("saved book: [{}]", toSave);
        return toSave;
    }
}
