package com.alex.controller;

import com.alex.model.DAO.AgencyTypeDao;
import com.alex.model.DAO.interfaces.GeneralDao;
import com.alex.model.models.AgencyType;

import java.util.Objects;

public class AgencyTypeControllerImpl implements com.alex.controller.interfaces.AgencyTypeController{

    private GeneralDao<AgencyType,Integer> agencyTypeGeneralDao;

    @Override
    public String printTable(){
        return String.format("","id","typeAgency");
    }

    @Override
    public GeneralDao<AgencyType, Integer> generalDaoObject() {
        return Objects.requireNonNullElseGet(agencyTypeGeneralDao, () -> agencyTypeGeneralDao = new AgencyTypeDao());
    }
}
