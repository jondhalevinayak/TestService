package com.testSevice.repository;

import com.testSevice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT b FROM Book b")
    List<Book> getAllBooks();

    @Query(value = "SELECT b FROM Book b where b.id = :bookId")
    Book getBookById(int bookId);
}
