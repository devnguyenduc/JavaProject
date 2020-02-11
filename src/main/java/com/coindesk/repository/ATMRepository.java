package com.coindesk.repository;

import com.coindesk.model.ATM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ATMRepository extends JpaRepository<ATM, Long>{

}