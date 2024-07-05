package com.testSevice.controller;

import com.testSevice.model.Book;
import com.testSevice.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<HttpStatus> saveBook(@RequestBody Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<HttpStatus> updateBook(@RequestBody Book book) {
        bookRepository.save(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable int bookId) {
        bookRepository.deleteById(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
