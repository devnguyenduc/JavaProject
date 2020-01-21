package com.coindesk.coin;

import com.coindesk.module.StringUtil;
import com.coindesk.user.User;
import com.coindesk.user.UsersRepository;
import org.springframework.data.annotation.Id;

import java.util.Date;

public class Coin {
    @Id
    private String id;
    private String name;
    private double value;

    public Coin(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
