package com.coindesk.services.impl;

import com.coindesk.model.Cash;
import com.coindesk.model.Customer;
import com.coindesk.repository.CashRepository;
import com.coindesk.services.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashService implements DeskService<Cash> {

    @Autowired
    CashRepository cashRepository;

    @Override
    public List<Cash> search() {
        return cashRepository.findAll();
    }

    @Override
    public Cash searchID(long id) {
        return cashRepository.findById(id);
    }

    @Override
    public String change(long id, Cash temp) {
        cashRepository.save(temp);
        return success;
    }

    @Override
    public String delete(long id, Cash temp) {
        cashRepository.delete(temp);
        return null;
    }

    public List<Cash> getCash(long atmId){
        return cashRepository.findByAtmId(atmId);
    }
}
