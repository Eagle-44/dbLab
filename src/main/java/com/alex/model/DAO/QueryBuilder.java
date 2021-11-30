package com.alex.model.DAO;

public class QueryBuilder {
    private final String className;

    public QueryBuilder(String className) {
        this.className = className;
    }

    public String buildFindAll() {
        return "FROM " + className;
    }

    public String buildFindById() {
        return String.format("FROM %s WHERE id =:id", className);
    }

    public String buildDelete() {
        return String.format("DELETE %s WHERE id=:id", className);
    }
}
