package com.example.smartshopping.smartshopping.Transactions;

import com.example.smartshopping.smartshopping.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transaction;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public String payment(@RequestBody Transactions transaction, @RequestParam String userid){
        if(transactionService.makePayment(transaction)) {
            cartService.emptyCart(userid);
            return "Payment Done";
        }else{
            return "Payment Failed";
        }
    }


}
