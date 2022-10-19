package com.example.smartshopping.smartshopping.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
        } catch ( Error error) {
            return "Some Error occurred while adding new Customer";
        }
        return "New Customer added";
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/get/mobile")
    public User getUserByMobile(@RequestParam long number){
         return userService.getUserByMobile(number);
    }

    @PostMapping("/get/email")
    public User getUserByEmail(@RequestParam String email){
        return userService.getUserByEmail(email);
    }

    @PostMapping("/get/rfid")
    public User getUserByRFID(@RequestParam String RFID){
        return userService.getUserByRFID(RFID);
    }

    @PostMapping("/getrfid")
    public String getUserByRFIDBody(@RequestBody UserByRFID userByRFID){
        return userByRFID.getRFID();
    }

    @PostMapping("/userExists")
    public User Userexits(@RequestBody UserExist userExist){
        if(userService.Userexits(userExist.getNumber()))
            return userService.getUserByMobile(userExist.getNumber());
        else
            return null;
    }

    @PostMapping("/get/name")
    public String getUserByName(@RequestParam String RFID){
       return getUserByRFID(RFID).getName();
    }
}

