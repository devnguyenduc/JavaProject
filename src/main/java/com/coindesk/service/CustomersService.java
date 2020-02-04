package com.coindesk.service;

import com.coindesk.model.Customer;
import com.coindesk.module.Authentication;
import com.coindesk.repository.CustomerRepository;

import java.util.List;

public class CustomersService {
    //
    private CustomerRepository customerRepository;

    // Init Dependencies Customer repository to CustomersService
    public CustomersService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String insert(Customer _customer){
        customerRepository.save(_customer);
        return "success";
    }


    public Iterable<Customer> search(){
        return customerRepository.findAll();
    }

    public Object searchID(long id){
        Object searchCustomer = customerRepository.findById(id);
        return searchCustomer;
    }

    public String change(Customer temp){
        Customer findCustomerRepo = customerRepository.findById(temp.getId()).get();
        Customer updateCustomer = new Customer(findCustomerRepo);
        updateCustomer.set(temp);
        customerRepository.save(updateCustomer);
        return "success";
    }

    /*

    public void updateLaserDataByHumanId(String replacement, String humanId) {
        List<LaserData> laserDataByHumanId = laserDataRepository.findByHumanId(humanId);
        laserDataByHumanId.stream()
                .map(en -> en.setHumanId(replacement))
                .collect(Collectors.toList())
                .forEach(en -> laserDataRepository.save(en));
    }

     */

    public String delete(Customer temp){
        Authentication _auth = new Authentication();
        boolean checkCustomer = customerRepository.existsById(temp.getId());
        if(_auth.checkAuthentication()){
            customerRepository.delete(temp);
            return "success";
        }else{
            return "fail";
        }
    }
}
