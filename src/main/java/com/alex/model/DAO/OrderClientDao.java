package com.alex.model.DAO;


import com.alex.model.models.OrderClient;
import com.alex.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderClientDao implements com.alex.model.DAO.interfaces.OrderClientDao{
    @Override
    public String getAll() {
        return "SELECT * FROM order_client";
    }

    @Override
    public String getById() {
        return "SELECT * FROM order_client WHERE order_client.id = ?";
    }

    @Override
    public String createElement() {
        return "INSERT order_client(animator_id, agency_id, event_id, client_id, price_id) VALUES (?,?,?,?,?)";
    }

    @Override
    public String updateElement() {
        return "UPDATE order_client SET animator_id=?, agency_id=?, event_id=?, client_id=?, price_id=? WHERE id=?";
    }

    @Override
    public String deleteElement() {
        return "DELETE FROM order_client WHERE id=?";
    }

    @Override
    public OrderClient recordEntity(ResultSet resultSet) throws SQLException {
        return (OrderClient) new Transformer<>(OrderClient.class).transformToEntity(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, OrderClient model) throws SQLException {
        preparedStatement.setInt(1,model.getAnimatorId());
        preparedStatement.setInt(2,model.getAgencyId());
        preparedStatement.setInt(3,model.getEventId());
        preparedStatement.setInt(4,model.getClientId());
        preparedStatement.setInt(5,model.getPriceId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, OrderClient model) throws SQLException {
        preparedStatement.setInt(6,model.getId());
        return preparedStatement;
    }
}
