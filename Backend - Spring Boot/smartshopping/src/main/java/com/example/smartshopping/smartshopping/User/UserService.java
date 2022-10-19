package com.example.smartshopping.smartshopping.User;

import java.util.List;

public interface UserService {

    public void addUser(User user);

    public List<User> getUsers();

    public User getUserByMobile(long number);

    public User getUserByEmail(String email);

    public User getUserByRFID(String rfid);

    public boolean  Userexits(long mobile);

    public boolean UserexitsByRFID(String RFID);
}
