package com.alex.model.DAO;



public class AgencyTypeDao implements com.alex.model.DAO.interfaces.AgencyTypeDao{
    private QueryBuilder queryBuilder;

    @Override
    public QueryBuilder getQueryBuilder() {
        if (queryBuilder == null) {
            queryBuilder = new QueryBuilder("AgencyType");
        }
        return queryBuilder;
    }

}
