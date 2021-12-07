package com.alex.service;

import com.alex.models.Animator;
import com.alex.repository.AnimatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AnimatorService {

    @Autowired
    AnimatorRepository animatorRepository;

    public Animator addAnimator(final Animator agencyAnimator){
        return animatorRepository.save(agencyAnimator);
    }

    public Animator updateAnimator(final Animator agencyAnimator){
        return animatorRepository.save(agencyAnimator);
    }

    public List<Animator> getAnimator() {
        return animatorRepository.findAll();
    }

    public Animator getAnimatorById(final Integer id){
        return animatorRepository.findById(id).orElse(null);
    }

    public void deleteById(final Integer id) {
        animatorRepository.deleteById(id);
    }
}
