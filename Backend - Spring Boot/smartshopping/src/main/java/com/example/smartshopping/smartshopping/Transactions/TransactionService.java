package com.example.smartshopping.smartshopping.Transactions;

import javax.transaction.Transaction;

public interface TransactionService {
    public boolean makePayment(Transactions transaction);
}
