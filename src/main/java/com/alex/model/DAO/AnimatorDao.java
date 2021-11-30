package com.alex.model.DAO;



public class AnimatorDao implements com.alex.model.DAO.interfaces.AnimatorDao {
    private QueryBuilder queryBuilder;

    @Override
    public QueryBuilder getQueryBuilder() {
        if (queryBuilder == null) {
            queryBuilder = new QueryBuilder("Animator");
        }
        return queryBuilder;
    }

}
