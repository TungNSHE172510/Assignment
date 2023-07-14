/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null; 
    
    public ArrayList<Product> getAllProduct(){
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from product";
        try{
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(8),
                rs.getString(4),
                rs.getString(5),
                rs.getString(9)));
            }
        } catch (Exception e){
    }    
    return list;
    }
    public ArrayList<Category> getAllCategory(){
        ArrayList<Category> list = new ArrayList<>();
        String query = "select * from Category";
        try{
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Category(rs.getInt(1),
                rs.getString(2)));
            }
        } catch (Exception e){
    }    
    return list;
    }
    
    public Product getLast(){
        String sql = "select top 1 * from product order by pid desc";
        try{
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(8),
                rs.getString(4),
                rs.getString(5),
                rs.getString(9));
            }
        } catch (Exception e){
    }    
        return null;
    }
    
    public ArrayList<Product> getProductByCID(String cid){
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from product where cid=?";
        try{
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(query);
            ps.setString(1,cid);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(8),
                rs.getString(4),
                rs.getString(5),
                rs.getString(9)));
            }
        } catch (Exception e){
    }    
    return list;
    }
    
    public Product getProductByID(String id){
        String query = "select * from product where pid=?";
        try{
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(query);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Product(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(8),
                rs.getString(4),
                rs.getString(5),
                rs.getString(9));
            }
        } catch (Exception e){
    }    
    return null;
    }
    
    public ArrayList<Product> searchByName(String search){
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from Product where name like ?";
        try{
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+search+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getDouble(8),
                rs.getString(4),
                rs.getString(5),
                rs.getString(9)));
            }
        } catch (Exception e){
    }    
    return list;
    }
    
    public Account login(String user, String pass){
        String sql = "select * from Account\n" +
                    "where [name] = ?\n" +
                    "and pass = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
                }
            } catch (Exception e) {
        }
        return null;
    }
    
    public static void main(String[] args) {
        DAO dao = new DAO();
        ArrayList<Product> list = dao.getAllProduct();
        ArrayList<Category> listC = dao.getAllCategory();
        for (Category o : listC){
            System.out.println(o);
        }
    }
}
 