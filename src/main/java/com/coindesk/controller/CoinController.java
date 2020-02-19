package com.coindesk.controller;

import com.coindesk.model.Coin;
import com.coindesk.services.impl.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/admin/coin")
public class CoinController {
    @Autowired
    CoinService coinService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String allCoin(@RequestParam(name = "searchCoinName", required = false, defaultValue = "all") String searchCoinName,Model model){
        Iterable<Coin> coins = coinService.get();
        System.out.println(coins);
        System.out.println(searchCoinName);
        if(!searchCoinName.equals("all")) {
            System.out.println(searchCoinName);
            coins = coinService.getByNameContaining(searchCoinName);
            coins.forEach(System.out::println);
        }

        model.addAttribute("coins", coins);
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
    public String changeCoinDesk(@PathVariable(name = "id") long id, Model model){
        Coin coin = coinService.getById(id).get();
        System.out.println(coin.getId());
        model.addAttribute("coin", coin);
        return "admin/coin/update";
    }

    @PostMapping("update/{id}")
    public String change(@PathVariable(name = "id") long id, Coin coin){
        Optional<Coin> findCoin = coinService.getById(id);
        Coin changeCoin = new Coin(coin.getCoinName(),coin.getValue(),coin.getNumber());
        changeCoin.setId(coin.getId());
        String result = coinService.change(changeCoin);
        return "redirect:/admin/coin";
    }

}
