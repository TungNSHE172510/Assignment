/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import dal.DBContext;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author kiemq
 */
public class StudentDAO extends DBContext {
    
    public ArrayList<Student> getAll(){
        try {
            String sql = "Select * from Student";
            ArrayList<Student> list = new ArrayList();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getBoolean("gender"));
                student.setDob(rs.getDate("dob"));
                list.add(student);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void delete(int id){
        try {
            String sql = "DELETE FROM Student WHERE Id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void add(Student student){
        try {
            String sql = "insert into Student(name, gender, dob) values (?, ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, student.getName());
                ps.setBoolean(2, student.isGender());
                ps.setDate(3, new java.sql.Date(student.getDob().getTime()));
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Student get(int id){
        try {
            String sql = "Select * from Student Where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getBoolean("gender"));
                student.setDob(rs.getDate("dob"));
            return student;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void update(Student student){
        try {
            String sql = "UPDATE Student SET name = ?, gender = ?, dob = ? WHERE id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, student.getName());
                ps.setBoolean(2, student.isGender());
                ps.setDate(3, new java.sql.Date(student.getDob().getTime()));
                ps.setInt(4, student.getId());
                ps.execute();
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
