package com.coindesk.repository;

import com.coindesk.model.ATM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ATMRepository extends JpaRepository<ATM, Long>{
    List<ATM> findAll();
    ATM findById(long id);
}