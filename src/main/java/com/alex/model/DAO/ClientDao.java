package com.alex.model.DAO;


public class ClientDao implements com.alex.model.DAO.interfaces.ClientDao{
    private QueryBuilder queryBuilder;

    @Override
    public QueryBuilder getQueryBuilder() {
        if (queryBuilder == null) {
            queryBuilder = new QueryBuilder("Client");
        }
        return queryBuilder;
    }

}
