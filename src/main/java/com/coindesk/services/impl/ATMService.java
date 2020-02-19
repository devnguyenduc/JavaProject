package com.coindesk.services.impl;

import com.coindesk.model.ATM;
import com.coindesk.model.Customer;
import com.coindesk.repository.ATMRepository;
import com.coindesk.services.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ATMService implements DeskService<ATM> {

    @Autowired
    ATMRepository atmRepository;

    public String insert(ATM temp){
        atmRepository.save(temp);
        return success;
    }

    @Override
    public List<ATM> search() {
        return atmRepository.findAll();
    }

    @Override
    public ATM searchID(long id) {
        return atmRepository.findById(id);
    }

    @Override
    public String change(long id, ATM temp) {
        atmRepository.save(temp);
        return success;
    }

    @Override
    public String delete(long id, ATM temp) {
        atmRepository.delete(temp);
        return success;
    }
}
