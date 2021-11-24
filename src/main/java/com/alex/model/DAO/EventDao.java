package com.alex.model.DAO;

import com.alex.model.models.Event;
import com.alex.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDao implements com.alex.model.DAO.interfaces.EventDao{
    @Override
    public String getAll() {
        return "SELECT * FROM event";
    }

    @Override
    public String getById() {
        return "SELECT * FROM event WHERE event.id = ?";
    }

    @Override
    public String createElement() {
        return "INSERT event(name, event_duration, date_of_the_event, event_address_id) VALUES (?,?,?,?)";
    }

    @Override
    public String updateElement() {
        return "UPDATE event SET name=?, event_duration=?, date_of_the_event=?, event_address_id=? WHERE id=?";
    }

    @Override
    public String deleteElement() {
        return "DELETE FROM event WHERE id=?";
    }

    @Override
    public Event recordEntity(ResultSet resultSet) throws SQLException {
        return (Event) new Transformer<>(Event.class).transformToEntity(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Event model) throws SQLException {
        preparedStatement.setString(1, model.getNameEvent());
        preparedStatement.setString(2, model.getEventDuration());
        preparedStatement.setString(3, model.getDateOfEvent());
        preparedStatement.setInt(4, model.getEventAddressId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Event model) throws SQLException {
        preparedStatement.setInt(5,model.getId());
        return preparedStatement;
    }
}
