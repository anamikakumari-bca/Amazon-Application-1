package com.amazon.dao;

import com.amazon.model.Order;
import com.amazon.model.OrderItem;
import com.amazon.model.Product;
import com.amazon.util.DBConnection;
import java.sql.*;
import java.util.*;

public class OrderDAO {
    public int createOrder(Order order){String sql="INSERT INTO orders (customer_id,total_amount,order_status) VALUES (?,?,?)";try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){ps.setInt(1,order.getCustomerId());ps.setDouble(2,order.getTotalAmount());ps.setString(3,order.getOrderStatus());ps.executeUpdate();try(ResultSet rs=ps.getGeneratedKeys()){if(rs.next())return rs.getInt(1);}}catch(Exception e){e.printStackTrace();}return -1;}
    public boolean addOrderItem(OrderItem item){String sql="INSERT INTO order_items (order_id,product_id,quantity,price) VALUES (?,?,?,?)";try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)){ps.setInt(1,item.getOrderId());ps.setInt(2,item.getProductId());ps.setInt(3,item.getQuantity());ps.setDouble(4,item.getPrice());return ps.executeUpdate()>0;}catch(Exception e){e.printStackTrace();return false;}}
    public int placeOrder(Order order,List<Product> products){
        try(Connection con=DBConnection.getConnection()){
            con.setAutoCommit(false);
            try(PreparedStatement ps=con.prepareStatement("INSERT INTO orders (customer_id,total_amount,order_status) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS)){ps.setInt(1,order.getCustomerId());ps.setDouble(2,order.getTotalAmount());ps.setString(3,order.getOrderStatus());ps.executeUpdate();}
            int orderId;try(PreparedStatement ps=con.prepareStatement("SELECT LAST_INSERT_ID()")){try(ResultSet rs=ps.executeQuery()){if(!rs.next()){con.rollback();return -1;}orderId=rs.getInt(1);}}
            for(Product p:products){try(PreparedStatement ps=con.prepareStatement("SELECT stock FROM products WHERE product_id=? FOR UPDATE")){ps.setInt(1,p.getProductId());try(ResultSet rs=ps.executeQuery()){if(!rs.next()||rs.getInt("stock")<p.getCartQuantity()){con.rollback();return -1;}}}
                try(PreparedStatement ps=con.prepareStatement("UPDATE products SET stock=stock-? WHERE product_id=? AND stock>=?")){ps.setInt(1,p.getCartQuantity());ps.setInt(2,p.getProductId());ps.setInt(3,p.getCartQuantity());if(ps.executeUpdate()!=1){con.rollback();return -1;}}
                try(PreparedStatement ps=con.prepareStatement("INSERT INTO order_items (order_id,product_id,quantity,price) VALUES (?,?,?,?)")){ps.setInt(1,orderId);ps.setInt(2,p.getProductId());ps.setInt(3,p.getCartQuantity());ps.setDouble(4,p.getPrice());ps.executeUpdate();}}
            con.commit();return orderId;
        }catch(Exception e){e.printStackTrace();return -1;}
    }
    public List<Order> getOrdersByCustomer(int customerId){List<Order> orders=new ArrayList<>();String sql="SELECT order_id,customer_id,order_date,total_amount,order_status FROM orders WHERE customer_id=? ORDER BY order_id DESC";try(Connection con=DBConnection.getConnection();PreparedStatement ps=con.prepareStatement(sql)){ps.setInt(1,customerId);try(ResultSet rs=ps.executeQuery()){while(rs.next()){Order o=new Order();o.setOrderId(rs.getInt("order_id"));o.setCustomerId(rs.getInt("customer_id"));o.setOrderDate(rs.getTimestamp("order_date"));o.setTotalAmount(rs.getDouble("total_amount"));o.setOrderStatus(rs.getString("order_status"));orders.add(o);}}}catch(Exception e){e.printStackTrace();}return orders;}
}
