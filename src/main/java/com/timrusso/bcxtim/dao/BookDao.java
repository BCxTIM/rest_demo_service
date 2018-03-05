package com.timrusso.bcxtim.dao;

import com.timrusso.bcxtim.model.Book;

import java.util.List;

/**
 * Created by tmoiseev on 3/2/2018.
 */
public interface BookDao {
    void save(Book book);
    Book get(int id);
    List<Book> list();
    void update(Book book);
    void delete(Book book);

}
