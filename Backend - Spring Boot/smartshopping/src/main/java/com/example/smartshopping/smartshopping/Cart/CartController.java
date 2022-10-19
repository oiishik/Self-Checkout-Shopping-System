package com.example.smartshopping.smartshopping.Cart;


import com.example.smartshopping.smartshopping.Products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String addProductToCart(@RequestParam String barcode, @RequestParam String userid){
        try{
            if(productService.getProduct(barcode).getProductQuantity()!=0) {
                if (cartService.productExist(barcode, userid)) {
                    productService.deleteProduct(barcode);
                    return cartService.updateProductquantity(barcode, userid);
                }
                else {
                    Cart cart= new Cart(barcode,productService.getProduct(barcode).getProductName(),
                            productService.getProduct(barcode).getProdcutPrice(),userid);
                    productService.deleteProduct(barcode);
                    return cartService.addProductToCart(cart);
                }
            }
            else{
                return "Product out of stock";
            }
        }catch (Error error){
            return "Failed to add Product";
        }
    }

    @PostMapping("/getItems")
    public List<Cart> getCartItems(@RequestParam String userid){
            return cartService.getCartItems(userid);
    }

    @PostMapping("/cartExists")
    public String cartExists(@RequestParam String userid){
        if(cartService.getCartItems(userid).size()>0) return "You have bill payment due";
        else return "Visit Again";
    }

    @PostMapping("/deleteItem")
    public String deleteItem(@RequestParam String userid,String barcode ){
        try{
            cartService.deleteItem(userid,barcode);
        }catch (Error error){
            return "Error deleteing item";
        }
        productService.addProductUpdate(barcode);
        return "Item deleted";
    }

    @PostMapping("/emptyCart")
    public void emptyCart(@RequestParam String userid){
        cartService.emptyCart(userid);
    }

    @PostMapping("/getTotal")
    public Total total (@RequestParam String userid){
       return new Total(cartService.getTotal(userid));
    }

    @PostMapping("/getTotalString")
    public double totalString (@RequestParam String userid){
       double total= new Total(cartService.getTotal(userid)).getTotal();
       return total;
    }
}
