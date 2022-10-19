package com.example.smartshopping.smartshopping.Transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface TransactionRepo extends JpaRepository<Transactions, UUID> {

}
