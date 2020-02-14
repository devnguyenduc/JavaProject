package com.coindesk.repository;

import com.coindesk.model.Coin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CoinRepository extends CrudRepository<Coin, Long> {
    List<Coin> findByValue(double value);

    Optional<Coin> findByCoinName(String coinName);
}