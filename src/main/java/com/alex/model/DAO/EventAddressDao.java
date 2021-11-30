package com.alex.model.DAO;


public class EventAddressDao implements com.alex.model.DAO.interfaces.EventAddressDao {
    private QueryBuilder queryBuilder;

    @Override
    public QueryBuilder getQueryBuilder() {
        if (queryBuilder == null) {
            queryBuilder = new QueryBuilder("EventAddress");
        }
        return queryBuilder;
    }

}
