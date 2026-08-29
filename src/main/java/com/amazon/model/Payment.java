package com.amazon.model;
import java.sql.Timestamp;
public class Payment {
 private int paymentId,orderId; private double amount; private String paymentMethod,paymentStatus,transactionId; private Timestamp paymentDate;
 public Payment(){} public Payment(int paymentId,int orderId,double amount,String paymentMethod,String paymentStatus,String transactionId,Timestamp paymentDate){this.paymentId=paymentId;this.orderId=orderId;this.amount=amount;this.paymentMethod=paymentMethod;this.paymentStatus=paymentStatus;this.transactionId=transactionId;this.paymentDate=paymentDate;}
 public int getPaymentId(){return paymentId;} public void setPaymentId(int v){paymentId=v;} public int getOrderId(){return orderId;} public void setOrderId(int v){orderId=v;} public double getAmount(){return amount;} public void setAmount(double v){amount=v;} public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;} public String getPaymentStatus(){return paymentStatus;} public void setPaymentStatus(String v){paymentStatus=v;} public String getTransactionId(){return transactionId;} public void setTransactionId(String v){transactionId=v;} public Timestamp getPaymentDate(){return paymentDate;} public void setPaymentDate(Timestamp v){paymentDate=v;}
 @Override public String toString(){return "Payment{"+"paymentId="+paymentId+", orderId="+orderId+", amount="+amount+", paymentMethod='"+paymentMethod+'\''+", paymentStatus='"+paymentStatus+'\''+", transactionId='"+transactionId+'\''+", paymentDate="+paymentDate+'}';}
}
