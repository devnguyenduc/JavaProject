package com.coindesk.repository;

import com.coindesk.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoinRepository extends JpaRepository<Coin, Long>{
    List<Coin> findByValue(double value);
}