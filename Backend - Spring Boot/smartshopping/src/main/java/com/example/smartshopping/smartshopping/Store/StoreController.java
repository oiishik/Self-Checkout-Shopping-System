package com.example.smartshopping.smartshopping.Store;

import com.example.smartshopping.smartshopping.Cart.CartController;
import com.example.smartshopping.smartshopping.Cart.CartService;
import com.example.smartshopping.smartshopping.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @Autowired
    CartController cartController;

    @PostMapping("/cardScan")
    public String cardScan(@RequestParam String userid){
        if(!storeService.userEntry(userid)){
            return cartService.cartIsEmpty(userid);
            }
        else{
            if(userService.UserexitsByRFID(userid)) {
                storeService.addUser(userid);
                return "Welcome to Store";
            }
            return "Card not registered";
        }
    }
}
