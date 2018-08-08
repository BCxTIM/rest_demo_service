package com.timrusso.bcxtim.service;

import com.timrusso.bcxtim.model.Book;

import java.util.List;

/**
 * Created by tmoiseev on 3/2/2018.
 */
public interface BookService {
    void save(Book book);
    Book get(int id);
    List<Book> list();
    void update(Book book);
    void delete(Book book);
}
