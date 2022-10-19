package com.example.smartshopping.smartshopping.Cart;

import com.example.smartshopping.smartshopping.Products.ProductServiceImplementation;
import com.example.smartshopping.smartshopping.Store.StoreRepo;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CartServiceImplementation implements CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductServiceImplementation productServiceImplementation;

    @Autowired
    StoreRepo storeRepo;

    @Override
    public String addProductToCart(Cart cart) {
        cartRepo.save(cart);
        return "Item added to cart";
    }

    @Override
    public boolean productExist(String barcode, String userid) {
        if(cartRepo.productExist(barcode,userid).size()>0)
            return true;
        return false;
    }

    @Override
    public String updateProductquantity(String barcode,String userid) {
        double cost = productServiceImplementation.getProduct(barcode).getProdcutPrice();
         if(cartRepo.updateProductQuantity(barcode,userid,cost)>=1)
            return "Item added to cart";
         else
             return "Some error adding product to cart";
    }

    @Override
    public List<Cart> getCartItems(String userid) {
        return cartRepo.getCartItems(userid);
    }

    public Cart getItem(String userid, String barcode){

        return cartRepo.getItem(userid,barcode);
    }

    @Override
    public void deleteItemUpdate(String userid, String barcode) {
        double cost = productServiceImplementation.getProduct(barcode).getProdcutPrice();
        System.out.println(cost);
        cartRepo.deleteItemUpdate(userid,barcode,cost);
    }

    @Override
    public String cartIsEmpty(String userid) {
            if(getCartItems(userid).size()>0) return "Bill Due";
            else {
                storeRepo.deleteUser(userid);
                return "Visit Again";
            }
        }

    @Override
    public double getTotal(String userid) {
        try {
            return cartRepo.getTotal(userid);
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public void deleteItem(String userid, String barcode) {
        if (cartRepo.getItem(userid,barcode).getQuantity()-1>0){
            deleteItemUpdate(userid,barcode);
        }
        else {
            cartRepo.deleteItem(barcode,userid);
        }
    }

    @Override
    public void emptyCart(String userid) {
        cartRepo.emptyCart(userid);
    }


}
