package com.alex.controller;

import com.alex.model.DAO.OrderClientDao;
import com.alex.model.DAO.interfaces.GeneralDao;
import com.alex.model.models.OrderClient;

import java.util.Objects;

public class OrderClientControllerImpl implements com.alex.controller.interfaces.OrderClientController{

    private GeneralDao<OrderClient,Integer> orderClientGeneralDao;

    @Override
    public GeneralDao<OrderClient, Integer> generalDaoObject() {
        return Objects.requireNonNullElseGet(orderClientGeneralDao, () -> orderClientGeneralDao = new OrderClientDao());
    }
}
