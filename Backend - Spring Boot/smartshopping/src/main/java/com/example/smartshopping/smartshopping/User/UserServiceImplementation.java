package com.example.smartshopping.smartshopping.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUserByMobile(long number){
       return userRepo.getUserByMobile(number);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.getUserByEmail(email);
    }

    @Override
    public User getUserByRFID(String rfid) {
        return userRepo.getUserByRFID(rfid);
    }

    @Override
    public boolean Userexits(long mobile) {
        if(userRepo.getUserByMobile(mobile)!=null) return true;
        return false;
    }

    @Override
    public boolean UserexitsByRFID(String RFID) {
        if(userRepo.getUserByRFID(RFID)!=null) return true;
        return false;
    }
}
