package com.example.shopeasy;

import java.io.Serializable;

public class LoginRes implements Serializable {

    private String rfid_No;
    private String name;
    private String email;
    private String mobile;

    public String getRFID() {
        return rfid_No;
    }

    public void setRFID(String RFID) {
        this.rfid_No = RFID;
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

    public String getNumber() {
        return mobile;
    }

    public void setNumber(String mobile) {
        this.mobile = mobile;
    }
}
