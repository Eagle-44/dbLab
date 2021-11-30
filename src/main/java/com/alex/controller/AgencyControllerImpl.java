package com.alex.controller;

import com.alex.model.DAO.AgencyDao;
import com.alex.model.DAO.interfaces.GeneralDao;
import com.alex.model.models.Agency;

import java.util.Objects;

public class AgencyControllerImpl implements com.alex.controller.interfaces.AgencyController {

    private GeneralDao<Agency,Integer> agencyGeneralDao;

    @Override
    public String printTable(){
        return String.format("","id","agencyTypeId", "nameAgency");
    }

    @Override
    public GeneralDao<Agency, Integer> generalDaoObject() {
        return Objects.requireNonNullElseGet(agencyGeneralDao, () -> agencyGeneralDao = new AgencyDao());
    }
}
