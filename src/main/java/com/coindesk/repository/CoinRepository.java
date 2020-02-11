package com.coindesk.repository;

import com.coindesk.model.Coin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoinRepository extends CrudRepository<Coin, Long> {
    List<Coin> findByValue(double value);
}