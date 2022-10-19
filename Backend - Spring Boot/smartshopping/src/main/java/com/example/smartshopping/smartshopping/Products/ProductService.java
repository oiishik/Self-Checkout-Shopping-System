package com.example.smartshopping.smartshopping.Products;

import java.util.List;

public interface ProductService {
    public void addProduct(Product product);

    public List<Product> getProducts();

    public Product getProduct(String productBarcode);

    public void deleteProduct(String barcode);

    public void addProductUpdate(String barcode);
}
