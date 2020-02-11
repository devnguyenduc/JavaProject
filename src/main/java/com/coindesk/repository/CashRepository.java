package com.coindesk.repository;

import com.coindesk.model.Cash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashRepository extends JpaRepository<Cash, Long> {
}
