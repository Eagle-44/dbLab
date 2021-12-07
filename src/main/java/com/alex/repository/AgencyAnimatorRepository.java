package com.alex.repository;

import com.alex.models.AgencyAnimator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyAnimatorRepository extends JpaRepository<AgencyAnimator,Integer> {
}
