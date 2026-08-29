package com.amazon.model;
public class CartItem {
    private int cartItemId; private int cartId; private int productId; private int quantity;
    public CartItem() {}
    public CartItem(int cartItemId, int cartId, int productId, int quantity) { this.cartItemId=cartItemId; this.cartId=cartId; this.productId=productId; this.quantity=quantity; }
    public int getCartItemId(){return cartItemId;} public void setCartItemId(int v){cartItemId=v;}
    public int getCartId(){return cartId;} public void setCartId(int v){cartId=v;}
    public int getProductId(){return productId;} public void setProductId(int v){productId=v;}
    public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;}
    @Override public String toString(){return "CartItem{"+"cartItemId="+cartItemId+", cartId="+cartId+", productId="+productId+", quantity="+quantity+'}';}
}
