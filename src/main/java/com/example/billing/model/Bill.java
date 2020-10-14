package com.example.billing.model;

import java.util.List;

public class Bill {
    private String bill_id;
    User user;
    double bill_total;
    double bill_discount;
    double VAT =0.13;
    List<Product>products;

    public Bill(String bill_id, double bill_total, double bill_discount){
    }

    public String getBill_id() {
        return bill_id;
    }

    public void setBill_id(String id) {
        this.bill_id = id;
    }

    public double getBill_total() {
        return bill_total;
    }

    public void setBill_total(double bill_total) {
        this.bill_total = bill_total;
    }

    public double getBill_discount() {
        return bill_discount;
    }

    public void setBill_discount(double bill_discount) { this.bill_discount = bill_discount; }

}
