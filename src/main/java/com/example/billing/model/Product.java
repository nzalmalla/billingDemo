package com.example.billing.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Product {
    @Id
    String productId;
    String productName;
    int productPrice;

}
