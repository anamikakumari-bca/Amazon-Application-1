package com.amazon.model;
import java.sql.Timestamp;
public class Order {
 private int orderId,customerId; private Timestamp orderDate; private double totalAmount; private String orderStatus;
 public Order(){} public Order(int orderId,int customerId,Timestamp orderDate,double totalAmount,String orderStatus){this.orderId=orderId;this.customerId=customerId;this.orderDate=orderDate;this.totalAmount=totalAmount;this.orderStatus=orderStatus;}
 public int getOrderId(){return orderId;} public void setOrderId(int v){orderId=v;} public int getCustomerId(){return customerId;} public void setCustomerId(int v){customerId=v;} public Timestamp getOrderDate(){return orderDate;} public void setOrderDate(Timestamp v){orderDate=v;} public double getTotalAmount(){return totalAmount;} public void setTotalAmount(double v){totalAmount=v;} public String getOrderStatus(){return orderStatus;} public void setOrderStatus(String v){orderStatus=v;}
 @Override public String toString(){return "Order{"+"orderId="+orderId+", customerId="+customerId+", orderDate="+orderDate+", totalAmount="+totalAmount+", orderStatus='"+orderStatus+'\''+'}';}
}
