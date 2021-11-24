package com.alex.model.DAO;

import com.alex.model.models.Animator;
import com.alex.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimatorDao implements com.alex.model.DAO.interfaces.AnimatorDao {

    @Override
    public String getAll() {
        return "SELECT * FROM animator";
    }

    @Override
    public String getById() {
        return "SELECT * FROM animator WHERE animator.id = ?";
    }

    @Override
    public String createElement() {
        return "INSERT animator(name, last_name, age) VALUES (?,?,?)";
    }

    @Override
    public String updateElement() {
        return "UPDATE animator SET name=?, last_name=?, age=? WHERE id=?";
    }

    @Override
    public String deleteElement() {
        return "DELETE FROM animator WHERE id=?";
    }

    @Override
    public Animator recordEntity(ResultSet resultSet) throws SQLException {
        return (Animator) new Transformer<>(Animator.class).transformToEntity(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, Animator model) throws SQLException {
        preparedStatement.setString(1, model.getNameAnimator());
        preparedStatement.setString(2, model.getLastName());
        preparedStatement.setInt(3,model.getAge());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, Animator model) throws SQLException {
        preparedStatement.setInt(4,model.getId());
        return preparedStatement;
    }

}
