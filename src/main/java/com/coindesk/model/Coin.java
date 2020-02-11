package com.coindesk.model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

@Entity
@Validated
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String coinName;
    @NotNull
    private double value;

    protected Coin(){

    }
    public Coin(String coinName, double value) {
        this.coinName = coinName;
        this.value = value;
    }

    public String getName() {
        return coinName;
    }

    public void setName(String name) {
        this.coinName = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
