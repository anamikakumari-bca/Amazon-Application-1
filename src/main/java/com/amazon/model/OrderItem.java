package com.amazon.model;
public class OrderItem {
 private int orderItemId,orderId,productId,quantity; private double price;
 public OrderItem(){} public OrderItem(int orderItemId,int orderId,int productId,int quantity,double price){this.orderItemId=orderItemId;this.orderId=orderId;this.productId=productId;this.quantity=quantity;this.price=price;}
 public int getOrderItemId(){return orderItemId;} public void setOrderItemId(int v){orderItemId=v;} public int getOrderId(){return orderId;} public void setOrderId(int v){orderId=v;} public int getProductId(){return productId;} public void setProductId(int v){productId=v;} public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;} public double getPrice(){return price;} public void setPrice(double v){price=v;}
 @Override public String toString(){return "OrderItem{"+"orderItemId="+orderItemId+", orderId="+orderId+", productId="+productId+", quantity="+quantity+", price="+price+'}';}
}
