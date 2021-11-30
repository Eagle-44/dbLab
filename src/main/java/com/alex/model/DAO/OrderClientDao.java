package com.alex.model.DAO;


public class OrderClientDao implements com.alex.model.DAO.interfaces.OrderClientDao{
    private QueryBuilder queryBuilder;

    @Override
    public QueryBuilder getQueryBuilder() {
        if (queryBuilder == null) {
            queryBuilder = new QueryBuilder("OrderClient");
        }
        return queryBuilder;
    }

}
