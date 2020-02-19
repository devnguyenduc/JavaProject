package com.coindesk.controller;

import com.coindesk.model.*;
import com.coindesk.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    PersonService personService;

    @Autowired
    ATMService atmService;

    @Autowired
    CashService cashService;

    @Autowired
    CoinService coinService;

    @RequestMapping(value = "card/{id}", method = RequestMethod.GET)
    public String viewcard(@PathVariable long id, Model model){
        Customer customer = customerService.searchID(id);
        System.out.println(customer.getEmail());
        Person person = personService.searchID(customer.getPersonId());
        ATM atm = atmService.searchID(customer.getAtmId());
        List<Cash> cash = cashService.getCash(atm.getId());
        cash.forEach( c -> c.setCoin(coinService.searchID(c.getCoinId())));
        atm.setCash(cash);
        CustomerDetail customerDetail = new CustomerDetail(customer.getId(), customer.getEmail(), person, atm);
        model.addAttribute("customer_detail", customerDetail);
        return "myatm";
    }

    @RequestMapping(value = "api/card/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerDetail> cardapi(@PathVariable long id){
        Customer customer = customerService.searchID(id);
        Person person = personService.searchID(customer.getPersonId());
        ATM atm = atmService.searchID(customer.getAtmId());
        List<Cash> cash = cashService.getCash(atm.getId());
        cash.forEach( c -> c.setCoin(coinService.searchID(c.getCoinId())));
        atm.setCash(cash);
        CustomerDetail customerDetail = new CustomerDetail(customer.getId(), customer.getEmail(), person, atm);
        return new ResponseEntity<CustomerDetail>(customerDetail, HttpStatus.OK);
    }
}
