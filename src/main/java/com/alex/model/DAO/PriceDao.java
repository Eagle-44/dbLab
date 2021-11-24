package com.alex.model.DAO;

import com.alex.model.models.Price;
import com.alex.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceDao implements com.alex.model.DAO.interfaces.PriceDao{
    @Override
    public String getAll() {
        return "SELECT * FROM price";
    }

    @Override
    public String getById() {
        return "SELECT * FROM price WHERE price.id = ?";
    }

    @Override
    public String createElement() {
        return "INSERT price(salary, agency_salary) VALUES (?,?)";
    }

    @Override
    public String updateElement() {
        return "UPDATE price SET salary=?, agency_salary=? WHERE id=?";
    }

    @Override
    public String deleteElement() {
        return "DELETE FROM price WHERE id=?";
    }

    @Override
    public Price recordEntity(ResultSet resultSet) throws SQLException {
        return (Price) new Transformer<>(Price.class).transformToEntity(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Price model) throws SQLException {
        preparedStatement.setFloat(1,model.getSalary());
        preparedStatement.setFloat(2,model.getAgencySalary());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Price model) throws SQLException {
        preparedStatement.setInt(3,model.getId());
        return preparedStatement;
    }
}
