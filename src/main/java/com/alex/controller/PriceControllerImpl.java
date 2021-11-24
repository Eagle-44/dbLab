package com.alex.controller;

import com.alex.model.DAO.PriceDao;
import com.alex.model.DAO.interfaces.GeneralDao;
import com.alex.model.models.Price;

import java.util.Objects;

public class PriceControllerImpl implements com.alex.controller.interfaces.PriceController{

    private GeneralDao<Price,Integer> priceGeneralDao;

    @Override
    public GeneralDao<Price, Integer> generalDaoObject() {
        return Objects.requireNonNullElseGet(priceGeneralDao, () -> priceGeneralDao = new PriceDao());
    }
}
