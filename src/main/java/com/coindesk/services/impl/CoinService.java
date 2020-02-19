package com.coindesk.services.impl;

import com.coindesk.model.Coin;
import com.coindesk.model.Customer;
import com.coindesk.module.StringUtil;
import com.coindesk.repository.CoinRepository;
import com.coindesk.services.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoinService implements DeskService<Coin> {
    @Autowired
    CoinRepository coinRepository;

    StringUtil util = new StringUtil();

    public CoinService(){

    }

    public List<Coin> get(){
        return coinRepository.findAll();
    }

    public Optional<Coin> getById(long id){
        return coinRepository.findById(id);
    }

    public Optional<Coin> getByName(String Name){
        return coinRepository.findByCoinName(Name);
    }

    public List<Coin> getByNameContaining(String Containing){ return coinRepository.findByCoinNameContaining(Containing); }

    public String change(Coin coin){
        coinRepository.save(coin);
        return util.validKeyWhenSuccess();
    }

    public String insertNewCoin(Coin coin){
        coinRepository.save(coin);
        return util.validKeyWhenSuccess();
    }

    @Override
    public List<Coin> search() {
        return null;
    }

    @Override
    public Coin searchID(long id) {
        return null;
    }

    @Override
    public String change(long id, Coin temp) {
        return null;
    }

    @Override
    public String delete(long id, Coin temp) {
        return null;
    }
}
