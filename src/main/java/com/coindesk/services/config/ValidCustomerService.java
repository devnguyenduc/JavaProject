package com.coindesk.services.config;

import com.coindesk.model.ValidCustomer;
import com.coindesk.model.ValidCustomerDetails;
import com.coindesk.repository.ValidCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidCustomerService implements UserDetailsService {

    @Autowired
    ValidCustomerRepository validCustomerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Optional<ValidCustomer> validCustomerOptional = validCustomerRepository.findByEmail(email);

        return validCustomerOptional.map(ValidCustomerDetails::new).get();
    }
}
