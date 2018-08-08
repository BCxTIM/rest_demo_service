package com.timrusso.bcxtim.controller;

import com.timrusso.bcxtim.model.Book;
import com.timrusso.bcxtim.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tmoiseev on 3/2/2018.
 */
@RestController
@Api(value = "onlinestore", description = "Operations with book")
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
    @ApiOperation(value = "Find book by id",
            notes = "Also returns a book")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved book"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
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
        Book existingBook = bookService.get(id);
        if (existingBook == null) {
            return ResponseEntity.badRequest().body("Book has not been found");
        } else {
            existingBook.setAuthor(book.getAuthor());
            existingBook.setTitle(book.getTitle());
            bookService.update(existingBook);
            return ResponseEntity.ok().body("Book has been updated successfully.");
        }
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Book existingBook = bookService.get(id);
        if (existingBook == null) {
            return ResponseEntity.badRequest().body("Book has not been found");
        } else {
            bookService.delete(existingBook);
            return ResponseEntity.ok().body("Book has been deleted successfully.");
        }
    }
}