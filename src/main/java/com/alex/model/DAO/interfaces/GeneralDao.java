package com.alex.model.DAO.interfaces;


import com.alex.model.DAO.QueryBuilder;
import com.alex.model.session.SessionManager;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface GeneralDao<T,ID> {
    QueryBuilder getQueryBuilder();

    default List<T> findAll() throws SQLException {

        List<T> objectList = new ArrayList<>();

        try(Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryBuilder().buildFindAll());
            for (Object objects : query.list()) {
                objectList.add((T)objects);
            }
        }   return objectList;
    }

    default T findById(ID id) throws SQLException{
        try (Session session = SessionManager.getSession()) {
            Query query = session.createQuery(getQueryBuilder().buildFindById());
            query.setParameter("id",id);
            return (T) query.uniqueResult();
        }
    }

    default int create(T object) throws SQLException{
        try (Session session = SessionManager.getSession()) {
            int id = (int) session.save(object);
            session.close();
            return id;
        }
    }

    default void update(T object) throws SQLException{
        try (Session session = SessionManager.getSession()) {
          session.beginTransaction();
          session.saveOrUpdate(object);
          session.getTransaction().commit();
          session.close();
        }
    }

    default int delete(ID id) throws SQLException{
        try (Session session = SessionManager.getSession()) {
            session.beginTransaction();
            Query query = session.createQuery(getQueryBuilder().buildDelete());
            query.setParameter("id", id);
            Integer res = query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            return res;
        }
    }

}
