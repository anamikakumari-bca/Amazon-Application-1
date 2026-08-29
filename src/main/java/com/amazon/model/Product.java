package com.amazon.model;
public class Product {
    private int productId, sellerId, stock, cartQuantity; private String productName, description, category; private double price;
    public Product() {}
    public Product(int productId,int sellerId,String productName,String description,double price,int stock,String category){this.productId=productId;this.sellerId=sellerId;this.productName=productName;this.description=description;this.price=price;this.stock=stock;this.category=category;}
    public int getProductId(){return productId;} public void setProductId(int v){productId=v;} public int getSellerId(){return sellerId;} public void setSellerId(int v){sellerId=v;}
    public String getProductName(){return productName;} public void setProductName(String v){productName=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;}
    public double getPrice(){return price;} public void setPrice(double v){price=v;} public int getStock(){return stock;} public void setStock(int v){stock=v;}
    public String getCategory(){return category;} public void setCategory(String v){category=v;} public int getCartQuantity(){return cartQuantity;} public void setCartQuantity(int v){cartQuantity=v;}
    public double getCartTotal(){return price*cartQuantity;}
    @Override public String toString(){return "Product{"+"productId="+productId+", sellerId="+sellerId+", productName='"+productName+'\''+", price="+price+", stock="+stock+", category='"+category+'\''+'}';}
}
