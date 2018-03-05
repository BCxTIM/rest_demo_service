package com.timrusso.bcxtim.service;

import com.timrusso.bcxtim.dao.BookDao;
import com.timrusso.bcxtim.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tmoiseev on 3/2/2018.
 */
@Service
public class BookServiceImp implements BookService {

    @Autowired
    private BookDao bookDao;

    @Transactional
    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public Book get(int id) {
        return bookDao.get(id);
    }

    @Override
    public List<Book> list() {
        return bookDao.list();
    }

    @Override
    public void update(int id, Book book) {
        Book book1 = bookDao.get(id);
        book1.setAuthor(book.getAuthor());
        book1.setTitle(book.getTitle());
        bookDao.update(book1);
    }

    @Override
    public void delete(int id) {
        Book book = bookDao.get(id);
        bookDao.delete(book);
    }
}