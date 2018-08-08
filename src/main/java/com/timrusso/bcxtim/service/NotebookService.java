package com.timrusso.bcxtim.service;

import com.timrusso.bcxtim.model.Notebook;

import java.util.List;

/**
 * Created by tmoiseev on 3/2/2018.
 */
public interface NotebookService {
    void save(Notebook notebook);
    Notebook get(int id);
    List<Notebook> list();
    void update(Notebook notebook);
    void delete(Notebook notebook);
}
