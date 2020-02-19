package com.coindesk.services.impl;

import com.coindesk.model.Customer;
import com.coindesk.repository.CustomerRepository;
import com.coindesk.services.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements DeskService<Customer> {

    @Autowired
    CustomerRepository customerRepository;

    public Customer insert(Customer temp) {
        return customerRepository.save(temp);
    }

    @Override
    public List<Customer> search() {
        return customerRepository.findAll();
    }

    @Override
    public Customer searchID(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public String change(long id, Customer temp) {customerRepository.save(temp);
        return success;
    }

    @Override
    public String delete(long id, Customer temp) {
        customerRepository.delete(temp);
        return success;
    }
}
