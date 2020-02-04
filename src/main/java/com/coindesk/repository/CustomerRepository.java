package com.coindesk.repository;

import java.util.List;

import com.coindesk.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findById(long id);

    List<Customer> findByLastName(String lastName);

    @Override
    void delete(Customer entity);
}