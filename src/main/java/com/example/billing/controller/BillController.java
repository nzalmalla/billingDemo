package com.example.billing.controller;

import com.example.billing.model.Bill;
import com.example.billing.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class BillController {
    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/bill")
    public List<Bill> getAllBill() {
        return billService.findAll();
    }


    @GetMapping("/bill/{id}")
    public Optional<Bill> getBillById(@PathVariable String id) {
        return billService.findBillById(id);
    }

    @PostMapping("/user")
    public Optional<Bill> save(@RequestBody Bill bill) {
        return billService.save(bill);
    }


}
