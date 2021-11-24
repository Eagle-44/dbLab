package com.alex.controller.interfaces;

import com.alex.model.DAO.interfaces.GeneralDao;

import java.sql.SQLException;
import java.util.List;

public interface GeneralController<T,ID> {
    GeneralDao<T, ID> generalDaoObject();

    default List<T> findAll() throws SQLException {
        return generalDaoObject().findAll();
    }

    default T findById(ID id) throws SQLException {
        return generalDaoObject().findById(id);
    }

    default int create(T model) throws SQLException {
        return generalDaoObject().create(model);
    }

    default int update(T model) throws SQLException {
        return generalDaoObject().update(model);
    }

    default int delete(ID id) throws SQLException {
        return generalDaoObject().delete(id);
    }
}

