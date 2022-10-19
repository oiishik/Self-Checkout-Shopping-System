package com.example.smartshopping.smartshopping.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM `product` WHERE `product_barcode`=:barcode",nativeQuery = true)
    public Product getProduct(@Param("barcode") String productBarcode);
    @Modifying
    @Transactional
    @Query(value = "UPDATE `product` SET `product_quantity` = `product_quantity`-1 WHERE `product_barcode`=:barcode",nativeQuery = true)
    public void deleteProduct(@Param("barcode")String barcode);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `product` SET `product_quantity` = `product_quantity`+1 WHERE `product_barcode`=:barcode",nativeQuery = true)
    public void addProductUpdate(@Param("barcode")String barcode);
}
