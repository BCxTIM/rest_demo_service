package com.timrusso.bcxtim.controller;

import com.timrusso.bcxtim.model.Book;
import com.timrusso.bcxtim.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tmoiseev on 3/2/2018.
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /*---Add new book---*/
    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book) {
        bookService.save(book);
        return ResponseEntity.ok().body(book);
    }

    /*---Get a book by id---*/
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> get(@PathVariable("id") int id) {
        Book book = bookService.get(id);
        return ResponseEntity.ok().body(book);
    }

    /*---get all books---*/
    @GetMapping("/book")
    public ResponseEntity<List<Book>> list() {
        List<Book> books = bookService.list();
        return ResponseEntity.ok().body(books);
    }

    /*---Update a book by id---*/
    @PutMapping("/book/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Book book) {
        bookService.update(id, book);
        return ResponseEntity.ok().body("Book has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        bookService.delete(id);
        return ResponseEntity.ok().body("Book has been deleted successfully.");
    }
}