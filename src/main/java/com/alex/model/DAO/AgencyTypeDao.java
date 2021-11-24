package com.alex.model.DAO;

import com.alex.model.models.AgencyType;
import com.alex.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgencyTypeDao implements com.alex.model.DAO.interfaces.AgencyTypeDao{

    @Override
    public String getAll() {
        return "SELECT * FROM agency_type";
    }

    @Override
    public String getById() {
        return "SELECT * FROM agency_type WHERE agency_type.id = ?";
    }

    @Override
    public String createElement() {
        return "INSERT agency_type(name) VALUES (?)";
    }

    @Override
    public String updateElement() {
        return "UPDATE agency_type SET name=? WHERE id=?";
    }

    @Override
    public String deleteElement() {
        return "DELETE FROM agency_type WHERE id=?";
    }

    @Override
    public com.alex.model.models.AgencyType recordEntity(ResultSet resultSet) throws SQLException {
        return (AgencyType) new Transformer<>(AgencyType.class).transformToEntity(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, AgencyType model) throws SQLException {
        preparedStatement.setString(1, model.getNameAgencyType());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, com.alex.model.models.AgencyType model) throws SQLException {
        preparedStatement.setInt(2,model.getId());
        return preparedStatement;
    }
}
