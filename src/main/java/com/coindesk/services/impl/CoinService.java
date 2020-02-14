package com.coindesk.services.impl;

import com.coindesk.model.Coin;
import com.coindesk.module.StringUtil;
import com.coindesk.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoinService {
    @Autowired
    CoinRepository coinRepository;

    StringUtil util = new StringUtil();

    public CoinService(){

    }

    public Iterable<Coin> get(){
        return coinRepository.findAll();
    }

    public Optional<Coin> getById(long id){
        return coinRepository.findById(id);
    }

    public Optional<Coin> getByName(String Name){
        return coinRepository.findByCoinName(Name);
    }

    public String change(Coin coin){
        coinRepository.save(coin);
        return util.validKeyWhenSuccess();
    }

    public String insertNewCoin(Coin coin){
        coinRepository.save(coin);
        return util.validKeyWhenSuccess();
    }
}
