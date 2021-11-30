package com.alex.controller;

import com.alex.model.DAO.AgencyAnimatorDao;
import com.alex.model.DAO.interfaces.GeneralDao;
import com.alex.model.models.AgencyAnimator;

import java.util.Objects;

public class AgencyAnimatorControllerImpl implements com.alex.controller.interfaces.AgencyAnimatorController{

    private GeneralDao<AgencyAnimator,Integer> agencyAnimatorGeneralDao;

    @Override
    public String printTable(){
        return String.format("","id","agencyId","animatorId");
    }

    @Override
    public GeneralDao<AgencyAnimator, Integer> generalDaoObject() {
        return Objects.requireNonNullElseGet(agencyAnimatorGeneralDao,
                () -> agencyAnimatorGeneralDao = new AgencyAnimatorDao());
    }
}
