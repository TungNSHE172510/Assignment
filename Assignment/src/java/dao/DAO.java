/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Manufacturer;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


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
    
    public ArrayList<Account> getAllUser(){
        ArrayList<Account> list = new ArrayList<>();
        String query = "select * from account";
        try{
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Account(rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4),
                rs.getInt(5)));
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
    
    public ArrayList<Manufacturer> getAllManufacturer(){
        ArrayList<Manufacturer> list = new ArrayList<>();
        String query = "select * from Manufacturer";
        try{
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Manufacturer(rs.getInt(1),
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
    
    public ArrayList<Product> getProductByMID(String cid){
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from product where mid=?";
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
    
    public ArrayList<Product> getProductByUID(int id){
        ArrayList<Product> list = new ArrayList<>();
        String query = "select * from product where sellId=?";
        try{
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
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
                    "where [user] = ?\n" +
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
    
    public Account checkAccount(String user){
        String sql = "select * from Account\n" +
                    "where [user] = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
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
    
    public void  signup(String user, String pass){
        String sql = "insert into account values(?,?,0,0)";
        try {
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();//ko tra ve bang result
        } catch (Exception e) {
        }
    }
    
    public void delete(String pid){
        String sql = "delete from product where pid=?";
            try {
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            ps.executeUpdate();//ko tra ve bang result
        } catch (Exception e) {
        }
    }
    
    public void deleteUser(String uid){
        String sql = "delete from account where uid=?";
            try {
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            ps.executeUpdate();//ko tra ve bang result
        } catch (Exception e) {
        }
    }
    
    public void add(String name, String image, String title, String description, String mID,
    int sellID, String Price, String capacity, String cid){
        String sql = "Insert [dbo].[Product]\n" +
                    "([name],[image],[title],[description],[mid],[sellID],[Price],[capacity],[cid])\n" +
                    "VALUES (?,?,?,?,?,?,?,?,?)";
            try {
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, title);
            ps.setString(4, description);
            ps.setString(5, mID);
            ps.setInt(6, sellID);
            ps.setString(7, Price);
            ps.setString(8, capacity);
            ps.setString(9, cid);
            ps.executeUpdate();//ko tra ve bang result
        } catch (Exception e) {
        }
    }
    
    public void edit(String name, String image, String title, String description, String mID
            , String Price, String capacity, String cid, String pid){
        String sql = "update Product\n" +
                    "set [name] = ?,\n" +
                    "[image] = ?,\n" +
                    "title = ?,\n" +
                    "[description] = ?,\n" +
                    "mID = ?,\n" +
                    "Price = ?,\n" +
                    "capacity = ?,\n" +
                    "cid = ?\n" +
                    "where pID = ?";
            try {
            conn = new DBContext().getConnection();//mo ket noi sql sv
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, title);
            ps.setString(4, description);
            ps.setString(5, mID);
            ps.setString(6, Price);
            ps.setString(7, capacity);
            ps.setString(8, cid);
            ps.setString(9, pid);
            ps.executeUpdate();//ko tra ve bang result
        } catch (Exception e) {
        }
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
 