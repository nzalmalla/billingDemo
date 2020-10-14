package com.example.billing.service;

import com.example.billing.model.Bill;
import com.example.billing.repository.bill_Repository;

import java.util.List;
import java.util.Optional;

public class billService {
    private final bill_Repository repository;
    public billService(bill_Repository repository){
        this.repository=repository;
    }
    public Bill save(Bill bill){
        return repository.save(bill);
    }
    public List<Bill> findAll(){
        return repository.findAll();
    }
    public Optional<Bill> findBillById(int id){
        return repository.findById(id);
    }

}
