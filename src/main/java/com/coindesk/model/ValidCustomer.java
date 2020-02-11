package com.coindesk.model;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class ValidCustomer {
    @Id
    private String email;

    private String password;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private Authorities roles;

    protected ValidCustomer(){}

    public ValidCustomer(String email, String password) {
        this.email = email;
        this.password = password;
        this.enabled = true;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Authorities getRoles() {
        return roles;
    }

    public void setRoles(Authorities roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
