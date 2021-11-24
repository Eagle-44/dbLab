package com.alex.model.DAO;

import com.alex.model.models.Client;
import com.alex.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao implements com.alex.model.DAO.interfaces.ClientDao{

    @Override
    public String getAll() {
        return "SELECT * FROM client";
    }

    @Override
    public String getById() {
        return "SELECT * FROM client WHERE client.id = ?";
    }

    @Override
    public String createElement() {
        return "INSERT client(name, last_name, phone_number) VALUES (?,?,?)";
    }

    @Override
    public String updateElement() {
        return "UPDATE client SET name=?, last_name=?, phone_number=? WHERE id=?";
    }

    @Override
    public String deleteElement() {
        return "DELETE FROM client WHERE id=?";
    }

    @Override
    public Client recordEntity(ResultSet resultSet) throws SQLException {
        return (Client) new Transformer<>(Client.class).transformToEntity(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Client model) throws SQLException {
        preparedStatement.setString(1,model.getNameClient());
        preparedStatement.setString(2,model.getLastName());
        preparedStatement.setString(3,model.getPhoneNumber());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Client model) throws SQLException {
        preparedStatement.setInt(4,model.getId());
        return preparedStatement;
    }
}
