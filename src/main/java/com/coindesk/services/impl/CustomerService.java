package com.coindesk.services.impl;

import com.coindesk.model.Customer;
import com.coindesk.module.Authentication;
import com.coindesk.repository.CustomerRepository;
import com.coindesk.services.DeskService;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements DeskService<Customer> {
    //
    private static CustomerRepository customerRepository;

    // Init Dependencies Customer repository to CustomersService
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public String insert(Customer _customer){
        customerRepository.save(_customer);
        return success;
    }

    @Override
    public Iterable<Customer> search(){
        return customerRepository.findAll();
    }

    @Override
    public Customer searchID(long id){
        Customer searchCustomer = customerRepository.findById(id);
        return searchCustomer;
    }

    @Override
    public String change(long id, Customer temp){
        Customer findCustomerRepo = customerRepository.findById(id);
        if(findCustomerRepo.getId() == temp.getId()){
            Customer updateCustomer = new Customer(findCustomerRepo);
            updateCustomer.set(temp);
            customerRepository.save(updateCustomer);
            return success;
        }
        else{
            return fail;
        }
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

    @Override
    public String delete(long id, Customer temp){
        Authentication _auth = new Authentication();
        boolean checkCustomer = customerRepository.existsById(id);
        Customer findCustomerRepo = customerRepository.findById(id);
        if(findCustomerRepo.getId() == temp.getId()){
            if(_auth.checkAuthentication()){
                customerRepository.delete(temp);
                return success;
            }else{
                return fail;
            }
        }else{
            return fail;
        }

    }
}
