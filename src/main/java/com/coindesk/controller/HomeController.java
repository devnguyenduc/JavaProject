package com.coindesk.controller;

import com.coindesk.services.impl.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @Autowired
    CoinService coinService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("coin", coinService.get());
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(){
        return "index";
    }
}
