package com.coindesk.model;

import javax.persistence.*;
import java.util.List;

/*
    Wallet allow customers collect their coin.
    Wallet have function add new Coin. Customers will buy some coin and add to their wallet.
    Wallet have function exchange Coin. Customers will exchange with somebody so change value of their coin.
 */

@Entity
public class ATM {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long customerId;
    @Transient
    private List<Cash> cash;

    protected ATM(){

    }

    public ATM(long customerId) {
        this.customerId = customerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public List<Cash> getCash() {
        return cash;
    }

    public void setCash(List<Cash> cash) {
        this.cash = cash;
    }
}
