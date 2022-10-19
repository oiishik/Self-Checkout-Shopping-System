package com.example.smartshopping.smartshopping.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImplementation implements StoreService{

    @Autowired
    StoreRepo storeRepo;

    @Override
    public boolean userEntry(String userid) {
        if(storeRepo.userEntry(userid).size()>0)
            return false;
        return true;
    }

    @Override
    public void addUser(String userid) {
        Store store=new Store(userid);
        storeRepo.save(store);
    }
}
