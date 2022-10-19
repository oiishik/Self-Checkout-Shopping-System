package com.example.smartshopping.smartshopping.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    @Autowired
    ProductRepo productRepo;


    @Override
    public void addProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProduct(String productBarcode) {
        return productRepo.getProduct(productBarcode);
    }

    @Override
    public void deleteProduct(String barcode) {
        productRepo.deleteProduct(barcode);
    }

    @Override
    public void addProductUpdate(String barcode) {
        productRepo.addProductUpdate(barcode);
    }
}
