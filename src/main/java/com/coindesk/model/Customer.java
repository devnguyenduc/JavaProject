package com.coindesk.model;

import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String email;

    private long personId;
    @Transient
    private Person person;

    private long atmId;
    @Transient
    private ATM atm;

    public Customer(long personId, long atmId) {
        this.personId = personId;
        this.atmId = atmId;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public long getATMId() {
        return atmId;
    }

    public void setATMId(long atmId) {
        this.atmId = atmId;
    }

}
