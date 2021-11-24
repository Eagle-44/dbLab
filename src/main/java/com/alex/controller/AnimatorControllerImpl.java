package com.alex.controller;

import com.alex.model.DAO.AnimatorDao;
import com.alex.model.DAO.interfaces.GeneralDao;
import com.alex.model.models.Animator;

import java.util.Objects;

public class AnimatorControllerImpl implements com.alex.controller.interfaces.AnimatorController {

    private GeneralDao<Animator,Integer> animatorGeneralDao;

    @Override
    public GeneralDao<Animator, Integer> generalDaoObject() {
        return Objects.requireNonNullElseGet(animatorGeneralDao, () -> animatorGeneralDao = new AnimatorDao());
    }
}
