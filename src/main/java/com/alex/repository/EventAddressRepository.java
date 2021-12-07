package com.alex.repository;

import com.alex.models.EventAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventAddressRepository extends JpaRepository<EventAddress,Integer> {
}
