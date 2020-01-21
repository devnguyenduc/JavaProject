package com.example.demo;

import com.coindesk.coin.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin, String>{
    public Coin findValue(double value);
}