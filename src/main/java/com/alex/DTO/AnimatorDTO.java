package com.alex.DTO;

import com.alex.models.Animator;

public class AnimatorDTO {
    private Animator animator;

    public AnimatorDTO(Animator animator){
        this.animator = animator;
    }

    public Integer getId() {
        return animator.getId();
    }

    public String getName() {
        return animator.getName();
    }

    public String getLastName() {
        return animator.getLastName();
    }

    public Integer getAge() {
        return animator.getAge();
    }
}
