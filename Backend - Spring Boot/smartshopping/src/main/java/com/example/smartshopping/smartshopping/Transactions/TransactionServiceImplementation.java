package com.example.smartshopping.smartshopping.Transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;

@Service
public class TransactionServiceImplementation implements TransactionService{

    @Autowired
    TransactionRepo transactionRepo;

    @Override
    public boolean makePayment(Transactions transaction) {
       try{
           transactionRepo.save(transaction);
       }catch (Error error){
           return false;
       }
       return true;
    }
}
