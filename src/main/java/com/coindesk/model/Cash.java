package com.coindesk.model;

import com.coindesk.module.StringUtil;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.*;


@Entity
public class Cash {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long coinId;
    @Transient
    private Coin coin;

    private long atmId;

    private double number;

    public Cash(long coinId, long atmId, double number) {
        this.coinId = coinId;
        this.atmId = atmId;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getCoinId() {
        return coinId;
    }

    public void setCoinId(long coinId) {
        this.coinId = coinId;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public long getAtmId() {
        return atmId;
    }

    public void setAtmId(long atmId) {
        this.atmId = atmId;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}
