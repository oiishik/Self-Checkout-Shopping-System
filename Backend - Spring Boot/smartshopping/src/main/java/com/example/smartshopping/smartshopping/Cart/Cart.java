package com.example.smartshopping.smartshopping.Cart;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    public long SerialNo;

    public String productID;

    String productName;

    double productPrice;

    public String userID;

    long quantity=1;

    public Cart() {
    }

    public Cart(long serialNo, String productID, String productName, double productPrice, String userID, long quantity) {
        SerialNo = serialNo;
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.userID = userID;
        this.quantity = quantity;
    }

    public Cart(String productID, String productName, double productPrice, String userID) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.userID = userID;
    }

    public long getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(long serialNo) {
        SerialNo = serialNo;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
