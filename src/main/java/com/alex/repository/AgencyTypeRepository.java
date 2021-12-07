package com.alex.repository;

import com.alex.models.AgencyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyTypeRepository extends JpaRepository<AgencyType,Integer> {
}
