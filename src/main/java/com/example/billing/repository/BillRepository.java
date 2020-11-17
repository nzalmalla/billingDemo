package com.example.billing.repository;

import com.example.billing.model.Bill;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BillRepository {
    boolean save(Bill bill);

    List<Bill> findAll() throws SQLException;

    Optional<Bill> findById(String bill_id) throws SQLException;

}
