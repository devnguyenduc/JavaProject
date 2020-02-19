package com.coindesk.model;

import java.util.List;

public class CustomerDetail {
    public long id;
    public String email;
    public Person person;
    public ATM atm;

    public CustomerDetail(long id, String email, Person person, ATM atm) {
        this.id = id;
        this.email = email;
        this.person = person;
        this.atm = atm;
    }
}
