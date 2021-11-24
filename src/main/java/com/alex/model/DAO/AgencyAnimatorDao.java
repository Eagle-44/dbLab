package com.alex.model.DAO;

import com.alex.model.models.AgencyAnimator;
import com.alex.model.transformer.Transformer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgencyAnimatorDao implements com.alex.model.DAO.interfaces.AgencyAnimatorDao{
    @Override
    public String getAll() {
        return "SELECT * FROM agency_animator";
    }

    @Override
    public String getById() {
        return "SELECT * FROM agency_animator WHERE agency_animator.id = ?";
    }

    @Override
    public String createElement() {
        return "INSERT agency_animator(agency_id, animator_id) VALUES (?,?)";
    }

    @Override
    public String updateElement() {
        return "UPDATE agency_animator SET agency_id=?, animator_id=? WHERE id=?";
    }

    @Override
    public String deleteElement() {
        return "DELETE FROM agency_animator WHERE id=?";
    }

    @Override
    public AgencyAnimator recordEntity(ResultSet resultSet) throws SQLException {
        return (AgencyAnimator) new Transformer<>(AgencyAnimator.class).transformToEntity(resultSet);
    }

    @Override
    public PreparedStatement setParameters(PreparedStatement preparedStatement, AgencyAnimator model) throws SQLException {
        preparedStatement.setInt(1,model.getAgencyId());
        preparedStatement.setInt(2,model.getAnimatorId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement setId(PreparedStatement preparedStatement, AgencyAnimator model) throws SQLException {
        preparedStatement.setInt(3,model.getId());
        return preparedStatement;
    }
}
