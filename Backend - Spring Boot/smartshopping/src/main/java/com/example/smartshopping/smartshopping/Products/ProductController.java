package com.example.smartshopping.smartshopping.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public String addUser(@RequestBody Product Product){
       try{
           productService.addProduct(Product);
       } catch(Error error){
           return "Error adding new Product";
       }
       return "New Prodcut Added";
    }

    @GetMapping("/all")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("/get/barcode")
    public Product getProduct(@RequestParam String productBarcode){
        return productService.getProduct(productBarcode);
    }

    @PostMapping("/deleteProduct")
    public void deleteProduct(@RequestParam String barcode){
         productService.deleteProduct(barcode);
    }

    @PostMapping("/addProduct")
    public void addProductUpdate(@RequestParam String barcode){
        productService.addProductUpdate(barcode);
    }

}
