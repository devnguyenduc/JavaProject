package com.coindesk.model;

import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Validated
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Size(min=1, max=20)
    @NotNull
    private String firstName;
    @Size(min=1, max=40)
    @NotNull
    private String lastName;

    protected Customer() {
        this.firstName = " ";
        this.lastName = " ";
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(Customer temp){
        this.id = temp.id;
        this.firstName = temp.firstName;
        this.lastName = temp.lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public void set(Customer _customer){
        if(this.id != _customer.id){

        }
        this.firstName = _customer.firstName;
        this.lastName = _customer.lastName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}