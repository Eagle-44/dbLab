package com.alex.model.DAO;

import com.alex.model.models.EventAddress;
import com.alex.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventAddressDao implements com.alex.model.DAO.interfaces.EventAddressDao {

    @Override
    public String getAll() {
        return "SELECT * FROM event_address";
    }

    @Override
    public String getById() {
        return "SELECT * FROM event_address WHERE event_address.id = ?";
    }

    @Override
    public String createElement() {
        return "INSERT event_address(street, postal_code) VALUES (?,?)";
    }

    @Override
    public String updateElement() {
        return "UPDATE event_address SET street=?, postal_code=? WHERE id=?";
    }

    @Override
    public String deleteElement() {
        return "DELETE FROM event_address WHERE id=?";
    }

    @Override
    public EventAddress recordEntity(ResultSet resultSet) throws SQLException {
        return (EventAddress) new Transformer<>(EventAddress.class).transformToEntity(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, EventAddress model) throws SQLException {
        preparedStatement.setString(1,model.getStreetName());
        preparedStatement.setString(2,model.getPostalCode());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, EventAddress model) throws SQLException {
        preparedStatement.setInt(3,model.getId());
        return preparedStatement;
    }
}
