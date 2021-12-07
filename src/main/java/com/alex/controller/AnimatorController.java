package com.alex.controller;

import com.alex.DTO.AnimatorDTO;
import com.alex.exceptions.ItemNotFoundException;
import com.alex.models.Animator;
import com.alex.service.AnimatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/animator")
public class AnimatorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AnimatorController.class);

    @Autowired
    private AnimatorService animatorService;

    @PostMapping
    public ResponseEntity<AnimatorDTO> createAnimator(@Valid @RequestBody final Animator animator) {
        LOGGER.info("Added new Animator");
        return new ResponseEntity<AnimatorDTO>(new AnimatorDTO(animatorService.addAnimator(animator)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AnimatorDTO> updateAnimator(
            @PathVariable("id") final int id,
            @Valid @RequestBody final Animator animator) {

        if (animatorService.getAnimatorById(id) == null) {
            LOGGER.error("Can't put(updateAnimator) an Animator with non-existing id: " + id);
            throw new ItemNotFoundException("Can't put(updateAnimator) an Animator with non-existing id: " + id);
        }
        LOGGER.info("Successfully updated Animator with id: " + id);
        animator.setId(id);
        return new ResponseEntity<AnimatorDTO>(new AnimatorDTO(animatorService.updateAnimator(animator)), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<AnimatorDTO>> getAllAnimators() {
        LOGGER.info("Gave away all Animators");
        List<Animator> animators = animatorService.getAnimator();
        List<AnimatorDTO> animatorsDTO = new ArrayList<>();
        for (Animator animator:animators) {
            animatorsDTO.add(new AnimatorDTO(animator));
        }
        return new ResponseEntity<List<AnimatorDTO>>(animatorsDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AnimatorDTO> getAnimator(@PathVariable(name = "id") final Integer id) {
        if (animatorService.getAnimatorById(id) == null) {
            LOGGER.error("Can't get(getAnimator) an Animator with non-existing id: " + id);
            throw new ItemNotFoundException("Can't get(getAnimator) an Animator with non-existing id: " + id);
        }
        LOGGER.info("Successfully get an Animator with id: " + id);
        return new ResponseEntity<AnimatorDTO>(new AnimatorDTO(animatorService.getAnimatorById(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Animator> deleteAnimatorById(@PathVariable("id") final Integer id) {
        if (animatorService.getAnimatorById(id) == null) {
            LOGGER.error("Can't delete(deleteAnimatorById) an Animator with non-existing id: " + id);
            throw new ItemNotFoundException("Can't delete(deleteAnimatorById) an Animator with non-existing id: " + id);
        }
        LOGGER.info("Successfully deleted Animator with id: " + id);
        animatorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
