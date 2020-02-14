package com.coindesk.controller;

import com.coindesk.model.Coin;
import com.coindesk.services.impl.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

class CoinId{
    int coinid;

    public CoinId(){}

    public CoinId(int coinid) {
        this.coinid = coinid;
    }

    public int getCoinid() {
        return coinid;
    }

    public void setCoinid(int coinid) {
        this.coinid = coinid;
    }
}

@Controller
public class MiningController {
    @Autowired
    CoinService coinService;

    @RequestMapping(value = "/mining", method = RequestMethod.GET)
    public String mining_page(Model model){
        model.addAttribute("coinId", new CoinId());
        return "mining";
    }

    @RequestMapping(value="/mining", method = RequestMethod.POST)
    public String api_mining(CoinId coinId){
        System.out.println(coinId.coinid);
        Coin coin = coinService.getById(coinId.coinid).get();
        Coin coin_mining = new Coin(coin.getCoinName(),coin.getValue(), coin.getNumber() + 1);
        coin_mining.setId(coin.getId());
        coinService.change(coin_mining);
        return "redirect:/mining";
    }
}
