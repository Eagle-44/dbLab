package com.alex.controller;

import com.alex.model.DAO.EventAddressDao;
import com.alex.model.DAO.interfaces.GeneralDao;
import com.alex.model.models.EventAddress;

import java.util.Objects;

public class EventAddressControllerImpl implements com.alex.controller.interfaces.EventAddressController{

    private GeneralDao<EventAddress,Integer> eventAddressGeneralDao;

    @Override
    public GeneralDao<EventAddress, Integer> generalDaoObject() {
        return Objects.requireNonNullElseGet(eventAddressGeneralDao, () -> eventAddressGeneralDao = new EventAddressDao());
    }
}
