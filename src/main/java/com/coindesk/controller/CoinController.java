package com.coindesk.controller;

import com.coindesk.model.Coin;
import com.coindesk.services.impl.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/coin")
public class CoinController {
    @Autowired
    CoinService coinService;

    @GetMapping("")
    public String allCoin(Model model){
        List<Coin> coins = new ArrayList<Coin>();
        model.addAttribute("coins", coinService.get());
        return "admin/coin/index";
    }

    @GetMapping("create")
    public String insertCoinDesk(Model model){
        model.addAttribute("coin", new Coin());
        return "admin/coin/create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String insert(Coin coin){
        String result = coinService.insertNewCoin(coin);
        return "redirect:/admin/coin";
    }

    @GetMapping("update/{id}")
    public String changeCoinDesk(@RequestParam long id, Model model){
        model.addAttribute("coin", coinService.getById(id));
        return "admin/coin/update";
    }

    @PostMapping("update/{id}")
    public String change(Coin coin){
        Optional<Coin> findCoin = coinService.getByName(coin.getCoinName());
        Coin changeCoin = new Coin(coin.getCoinName(),coin.getValue(),coin.getNumber());
        changeCoin.setId(coin.getId());
        String result = coinService.change(changeCoin);
        return "redirect:/admin/coin";
    }

}
