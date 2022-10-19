package com.example.smartshopping.smartshopping.Products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue
    long ID;
    @Column(nullable = false)
    String productName;
    @Column(nullable = false)
    double prodcutPrice;
    long productQuantity;

    @Column(nullable = false,unique = true)
    String productBarcode;

    public Product() {
    }

    public Product(String productName, double prodcutPrice, long productQuantity, String productBarcode) {
        this.productName = productName;
        this.prodcutPrice = prodcutPrice;
        this.productQuantity = productQuantity;
        this.productBarcode = productBarcode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProdcutPrice() {
        return prodcutPrice;
    }

    public void setProdcutPrice(double prodcutPrice) {
        this.prodcutPrice = prodcutPrice;
    }

    public long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

}
