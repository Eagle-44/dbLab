package com.alex.model.DAO;

import com.alex.model.models.Agency;
import com.alex.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgencyDao implements com.alex.model.DAO.interfaces.AgencyDao{
    @Override
    public String getAll() {
        return "SELECT * FROM agency";
    }

    @Override
    public String getById() {
        return "SELECT * FROM agency WHERE agency.id = ?";
    }

    @Override
    public String createElement() {
        return "INSERT agency(agency_type_id, name_agency) VALUES (?,?)";
    }

    @Override
    public String updateElement() {
        return "UPDATE agency SET agency_type_id=?, name_agency=? WHERE id=?";
    }

    @Override
    public String deleteElement() {
        return "DELETE FROM agency WHERE id=?";
    }

    @Override
    public Agency recordEntity(ResultSet resultSet) throws SQLException {
        return (Agency) new Transformer<>(Agency.class).transformToEntity(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Agency model) throws SQLException {
        preparedStatement.setInt(1,model.getAgencyTypeId());
        preparedStatement.setString(2,model.getNameAgency());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Agency model) throws SQLException {
        preparedStatement.setInt(3,model.getId());
        return preparedStatement;
    }
}
