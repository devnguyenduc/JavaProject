package com.coindesk.repository;

import com.coindesk.model.Cash;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CashRepository extends JpaRepository<Cash, Long> {
    List<Cash> findByAtmId(long atmId);

    List<Cash> findAll();

    Cash findById(long Id);
}
