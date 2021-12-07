package com.alex.repository;

import com.alex.models.OrderClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderClientRepository extends JpaRepository<OrderClient,Integer> {
}
