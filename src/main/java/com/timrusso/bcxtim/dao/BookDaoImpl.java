package com.timrusso.bcxtim.dao;

import com.timrusso.bcxtim.model.Book;
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
public class BookDaoImpl implements BookDao {

   @PersistenceContext
   private EntityManager entityManager;

    @Override
    public void save(Book book) {
       entityManager.persist(book);
    }

    @Override
    public Book get(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public List<Book> list() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);
        TypedQuery<Book> query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(Book book) {
      entityManager.merge(book);

    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book);
    }

}