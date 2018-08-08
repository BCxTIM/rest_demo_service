package com.timrusso.bcxtim.service;

import com.timrusso.bcxtim.dao.BookDao;
import com.timrusso.bcxtim.dao.NotebookDao;
import com.timrusso.bcxtim.model.Book;
import com.timrusso.bcxtim.model.Notebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tmoiseev on 3/2/2018.
 */
@Service
public class NotebookServiceImp implements NotebookService {

    @Autowired
    private NotebookDao bookDao;

    @Transactional
    @Override
    public void save(Notebook notebook) {
        bookDao.save(notebook);
    }

    @Override
    public Notebook get(int id) {
        return bookDao.get(id);
    }

    @Override
    public List<Notebook> list() {
        return bookDao.list();
    }

    @Override
    public void update(Notebook notebook) {
        bookDao.update(notebook);
    }

    @Override
    public void delete(Notebook notebook) {
        bookDao.delete(notebook);
    }
}