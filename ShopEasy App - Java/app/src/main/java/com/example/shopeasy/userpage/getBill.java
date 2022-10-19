package com.example.shopeasy.userpage;

public class getBill {

    double total;

    public getBill(double bill) {
        this.total = bill;
    }

    public getBill() {
    }

    public double getBill() {
        return total;
    }

    public void setBill(double bill) {
        this.total = bill;
    }
}
