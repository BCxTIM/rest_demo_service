package com.timrusso.bcxtim.dao;

import com.timrusso.bcxtim.model.Notebook;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by tmoiseev on 3/2/2018.
 */
@Transactional
@Repository
public class NotebookDaoImpl implements NotebookDao {

   @PersistenceContext
   private EntityManager entityManager;

    @Override
    public void save(Notebook notebook) {
       entityManager.persist(notebook);
    }

    @Override
    public Notebook get(int id) {
        return entityManager.find(Notebook.class, id);
    }

    @Override
    public List<Notebook> list() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Notebook> cq = cb.createQuery(Notebook.class);
        Root<Notebook> root = cq.from(Notebook.class);
        cq.select(root);
        TypedQuery<Notebook> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(Notebook notebook) {
      entityManager.merge(notebook);

    }

    @Override
    public void delete(Notebook notebook) {
        entityManager.remove(notebook);
    }

}