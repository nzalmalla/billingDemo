package com.example.billing.repository;

import com.example.billing.model.Bill;

import java.sql.SQLException;
import java.util.List;

public interface bill_Repository {
    boolean save (Bill bill);
    List<Bill>getBills() throws SQLException;
    Bill getBillById(String bill_id) throws SQLException;

}
