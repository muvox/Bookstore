package com.a1704471.Bookstore.Bookstore.domain;

import com.a1704471.Bookstore.Bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);

}
