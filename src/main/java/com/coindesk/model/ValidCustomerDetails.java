package com.coindesk.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ValidCustomerDetails implements UserDetails {

    private String email;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authortities;

    public ValidCustomerDetails(){

    }

    public ValidCustomerDetails(ValidCustomer validCustomer) {
        this.email = validCustomer.getEmail();
        this.password = validCustomer.getPassword();
        this.active = validCustomer.isEnabled();
        this.authortities = Arrays.stream(validCustomer.getRoles().toString().split(","))
                                    .map(SimpleGrantedAuthority::new)
                                    .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authortities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
