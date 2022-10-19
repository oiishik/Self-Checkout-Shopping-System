package com.example.smartshopping.smartshopping.Cart;

import java.util.List;

public interface CartService {
    public String addProductToCart(Cart cart);

   public boolean productExist(String product, String userid);

   public String updateProductquantity(String barcode,String userid);

    public List<Cart> getCartItems(String userid);

    public void deleteItem(String userid, String barcode);

    public void emptyCart(String userid);

    public Cart getItem(String userid, String barcode);

    public void deleteItemUpdate(String barcode,String userid);

    public String cartIsEmpty(String userid);

    public double getTotal(String userid);
}
