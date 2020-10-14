package com.example.billing.controller;

import com.example.billing.model.Bill;
import com.example.billing.service.billService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class billController {
    private final billService service;

    @Autowired
    public billController(billService service) {
        this.service = service;
    }

    @GetMapping("/bill")
    public List<Bill> getAllBill() {
        return service.findAll();
    }


    @GetMapping("/bill/{id}")
    public Optional<Bill> getBillById(@PathVariable int id) {
        return service.findBillById(id);
    }

    @PostMapping("/user")
    public Bill save(@RequestBody Bill bill) {
        return service.save(bill);
    }


}
