package com.example.billing.model;



public class Product {

    String productId;
    String productName;
    int productPrice;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String id) {
        this.productId = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public int getProductPrice() { return productPrice; }

    public void setProductPrice(int price) {
        this.productPrice = price;
    }


}
