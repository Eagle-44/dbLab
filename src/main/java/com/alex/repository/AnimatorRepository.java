package com.alex.repository;

import com.alex.models.Animator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimatorRepository extends JpaRepository<Animator,Integer> {
}
