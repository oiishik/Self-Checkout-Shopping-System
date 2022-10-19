package com.example.smartshopping.smartshopping.Store;

import com.example.smartshopping.smartshopping.Cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StoreRepo extends JpaRepository<Store,Long> {

    @Query(value = "SELECT * FROM `store` WHERE `userid`=:id",nativeQuery = true)
    public List<Store> userEntry(@Param("id") String userid);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM store WHERE userID=:m",nativeQuery = true)
    public void deleteUser(@Param("m") String userid);
}
