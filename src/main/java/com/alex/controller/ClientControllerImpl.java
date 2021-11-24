package com.alex.controller;

import com.alex.model.DAO.ClientDao;
import com.alex.model.DAO.interfaces.GeneralDao;
import com.alex.model.models.Client;


import java.util.Objects;

public class ClientControllerImpl implements com.alex.controller.interfaces.ClientController{

    private GeneralDao<Client,Integer> clientGeneralDao;

    @Override
    public GeneralDao<Client, Integer> generalDaoObject() {
        return Objects.requireNonNullElseGet(clientGeneralDao, () -> clientGeneralDao = new ClientDao());
    }
}
