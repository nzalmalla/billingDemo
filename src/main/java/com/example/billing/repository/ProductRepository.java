package com.example.billing.repository;

import com.example.billing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<User , Integer> {
}
