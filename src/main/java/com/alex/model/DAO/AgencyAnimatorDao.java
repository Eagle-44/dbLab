package com.alex.model.DAO;

public class AgencyAnimatorDao implements com.alex.model.DAO.interfaces.AgencyAnimatorDao{

    private QueryBuilder queryBuilder;

    @Override
    public QueryBuilder getQueryBuilder() {
        if (queryBuilder == null) {
            queryBuilder = new QueryBuilder("AgencyAnimator");
        }
        return queryBuilder;
    }
}
