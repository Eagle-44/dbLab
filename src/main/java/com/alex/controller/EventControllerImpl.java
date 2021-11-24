package com.alex.controller;

import com.alex.model.DAO.EventDao;
import com.alex.model.DAO.interfaces.GeneralDao;
import com.alex.model.models.Event;

import java.util.Objects;

public class EventControllerImpl implements com.alex.controller.interfaces.EventController{

    private GeneralDao<Event,Integer> eventGeneralDao;

    @Override
    public GeneralDao<Event, Integer> generalDaoObject() {
        return Objects.requireNonNullElseGet(eventGeneralDao, () -> eventGeneralDao = new EventDao());
    }
}
