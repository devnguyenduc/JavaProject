package com.coindesk.repository;

import com.coindesk.model.ValidCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValidCustomerRepository extends JpaRepository<ValidCustomer, String> {
    Optional<ValidCustomer> findByEmail(String email);
}
