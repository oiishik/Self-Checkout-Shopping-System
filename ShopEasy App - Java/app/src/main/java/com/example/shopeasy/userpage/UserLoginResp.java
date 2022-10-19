package com.example.shopeasy.userpage;

import java.io.Serializable;

public class UserLoginResp implements Serializable {

   private String SerialNo;
   private String productID;
   private String productName;
   private String productPrice;
   private String userID;
   private String quantity;
   private String serialNo;

    public UserLoginResp() {
    }

    public UserLoginResp(String serialNo, String productID, String productName, String productPrice,
                         String userID, String quantity, String serialNo1) {
        SerialNo = serialNo;
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.userID = userID;
        this.quantity = quantity;
        this.serialNo = serialNo1;
    }

    public String getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(String serialNo) {
        SerialNo = serialNo;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}

