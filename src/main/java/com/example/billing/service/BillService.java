package com.example.billing.service;

import com.example.billing.model.Bill;
import com.example.billing.repository.BillRepository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BillService {
    private final BillRepository billRepo;

    public BillService(BillRepository billRepo) {
        this.billRepo = billRepo;
    }

    public Optional<Bill> save(Bill bill) {
        bill.setBill_id(UUID.randomUUID().toString());
        if (billRepo.save(bill)) {
            return Optional.of(bill);
        } else {
            return Optional.empty();
        }
    }

    public List<Bill> findAll() {
        try {
            return billRepo.findAll();
        } catch (SQLException throwables) {
            return Collections.emptyList();
        }
    }

    public Optional<Bill> findBillById(String id) {
        try {
            return billRepo.findById(id);
        } catch (SQLException throwables) {
            return Optional.empty();
        }
    }

}
