package com.example.smartshopping.smartshopping.User;

public class UserExistByRFID {

    private String RFID;

    public UserExistByRFID(String RFID) {
        this.RFID = RFID;
    }

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }
}
