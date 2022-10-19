package com.example.smartshopping.smartshopping.Store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Store {
    @Column(nullable = false,unique = true)
    String userid;

    String status="entered";

    @Id
    @GeneratedValue
    long id;

    public Store(){}

    public Store(String userid) {
        this.userid = userid;
    }

    public Store(String userid, String status, long id) {
        this.userid = userid;
        this.status = status;
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
