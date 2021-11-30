package com.alex.model.DAO;


public class EventDao implements com.alex.model.DAO.interfaces.EventDao{
    private QueryBuilder queryBuilder;

    @Override
    public QueryBuilder getQueryBuilder() {
        if (queryBuilder == null) {
            queryBuilder = new QueryBuilder("Event");
        }
        return queryBuilder;
    }

}
