package com.example.smartshopping.smartshopping.User;

public class UserByRFID {

    private String RFID;

    public UserByRFID() {
    }

    public UserByRFID(String RFID) {
        this.RFID = RFID;
    }

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }
}
