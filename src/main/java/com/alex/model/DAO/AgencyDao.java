package com.alex.model.DAO;

public class AgencyDao implements com.alex.model.DAO.interfaces.AgencyDao{
    private QueryBuilder queryBuilder;

    @Override
    public QueryBuilder getQueryBuilder() {
        if (queryBuilder == null) {
            queryBuilder = new QueryBuilder("Agency");
        }
        return queryBuilder;
    }
}
