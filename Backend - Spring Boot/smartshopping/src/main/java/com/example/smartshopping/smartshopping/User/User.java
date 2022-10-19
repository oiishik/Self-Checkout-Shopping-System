package com.example.smartshopping.smartshopping.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    long ID;
    @Column(nullable = false,unique = true)
    String rfid_No;
    @Column(nullable = false)
    String name;
    @Column(nullable = false,unique = true)
    String email;
    @Column(nullable = false,unique = true)
    long Mobile;

    public User(){};

    public User( String rfid_No, String name, String email, long mobile) {
        this.rfid_No = rfid_No;
        this.name = name;
        this.email = email;
        Mobile = mobile;
    }


    public String getRfid_No() {
        return rfid_No;
    }

    public void setRfid_No(String rfid_No) {
        this.rfid_No = rfid_No;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return Mobile;
    }

    public void setMobile(long mobile) {
        Mobile = mobile;
    }
}
