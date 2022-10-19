package com.example.smartshopping.smartshopping.Transactions;



import com.example.smartshopping.smartshopping.Cart.Cart;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Entity
public class Transactions {

    @Id
    @GeneratedValue
    UUID ID;
    String userID;
    @OneToMany(targetEntity= Cart.class, fetch=FetchType.EAGER)
    List<Cart> productList;

    double amount;

    Date date=new Date(System.currentTimeMillis());

    public Transactions() {
    }

    public Transactions(String userID, List<Cart> productList, double amount, Date date) {
        this.userID = userID;
        this.productList = productList;
        this.amount = amount;
        this.date = date;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Cart> getProductList() {
        return productList;
    }

    public void setProductList(List productList) {
        this.productList = productList;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
