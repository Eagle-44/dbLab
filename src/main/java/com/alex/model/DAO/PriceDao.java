package com.alex.model.DAO;


public class PriceDao implements com.alex.model.DAO.interfaces.PriceDao{
    private QueryBuilder queryBuilder;

    @Override
    public QueryBuilder getQueryBuilder() {
        if (queryBuilder == null) {
            queryBuilder = new QueryBuilder("Price");
        }
        return queryBuilder;
    }

}
