package com.example.smartshopping.smartshopping.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart,Long> {

    @Query(value = "SELECT * FROM `cart` WHERE productID=:n AND userID=:m",nativeQuery = true)
    public List<Cart> productExist(@Param("n") String barcode,@Param("m")String userid);
    @Modifying
    @Transactional
    @Query(value = "UPDATE `cart` SET quantity = quantity+1, product_price=product_price+:cost WHERE productID=:n AND userID=:m",nativeQuery = true)
    public Integer updateProductQuantity(@Param("n") String barcode, @Param("m")String userid, @Param("cost") double cost);

    @Query(value = "SELECT * FROM `cart` WHERE userID=:n",nativeQuery = true)
    public List<Cart> getCartItems(@Param("n") String userid);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `cart` WHERE productID=:n AND userID=:m",nativeQuery = true)
    public void deleteItem(@Param("n")String barcode,@Param("m")String userid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `cart` WHERE userID=:n",nativeQuery = true)
    public void emptyCart(@Param("n") String userid);


    @Query(value = "SELECT * FROM `cart` WHERE userID=:m AND productID=:n",nativeQuery = true)
    public Cart getItem(@Param("m")String userid,@Param("n") String barcode);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `cart` SET quantity = quantity-1, product_price=product_price-:cost WHERE productID=:n AND userID=:m",nativeQuery = true)
    public void deleteItemUpdate(@Param("m")String userid,@Param("n") String barcode, @Param("cost") double cost);

    @Query(value = "SELECT SUM(`product_price`) FROM `cart` WHERE `userid`=:userid", nativeQuery = true)
    public double getTotal(@Param("userid") String userid);
}
