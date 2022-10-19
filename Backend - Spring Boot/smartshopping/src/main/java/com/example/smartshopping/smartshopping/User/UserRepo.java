package com.example.smartshopping.smartshopping.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM `user` WHERE `mobile`=:number",nativeQuery = true)
    public User getUserByMobile(@Param("number") long number);
    @Query(value = "SELECT * FROM `user` WHERE `email`=:email",nativeQuery = true)
    public User getUserByEmail(@Param("email")String email);
    @Query(value = "SELECT * FROM `user` WHERE `rfid_no`=:RFID",nativeQuery = true)
    public User getUserByRFID(@Param("RFID") String rfid);
}