/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.ailatrieuphu.DTO.LinhVucDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyen.vu
 */
public class LinhVucDAO {
    public static List<LinhVucDTO> getDanhSachLinhVuc(){
        List<LinhVucDTO> result = new ArrayList<LinhVucDTO>(); // khai báo danh sách đối tượng rỗng
        try{
            String query = "SELECT * FROM LINH_VUC";
            Connection con = DatabaseUtil.DatabaseConnection.createConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                LinhVucDTO linhVuc = new LinhVucDTO();
                linhVuc.setId(rs.getInt(1));
                linhVuc.setName(rs.getString(2));
                
                result.add(linhVuc);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static int checkExists(int id){
        int result = 0;
        try{
            String query = "SELECT COUNT(*) FROM LINH_VUC LV, CAU_HOI CH WHERE LV.ID = CH.LINH_VUC AND LV.ID = ?";
            Connection con = DatabaseUtil.DatabaseConnection.createConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                result = rs.getInt(1);
            }
        }
         catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public static int checkDuplicateLinhVuc(String name){
        int result = 0;
        try{
            String query = "SELECT COUNT(*) FROM LINH_VUC WHERE NAME = ?";
            Connection con = DatabaseUtil.DatabaseConnection.createConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                result = rs.getInt(1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    
    public static int getNextId(){
        int id = 0;
        try{
            String query = "select MAX(ID) + 1 from linh_vuc";
            Connection con = DatabaseUtil.DatabaseConnection.createConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()){
                id = rs.getInt(1);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }
    
    public static int deleteLinhVuc(int id) throws SQLException{
        int result = 0;
        Connection con = DatabaseUtil.DatabaseConnection.createConnection();
        try{
            String query = "DELETE FROM LINH_VUC WHERE ID = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            
            result = pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            con.rollback();
        }
        return result;
    }
    
    public static int updateLinhVuc(LinhVucDTO linhVuc) throws SQLException{
        int result = 0;
        Connection con = DatabaseUtil.DatabaseConnection.createConnection();
        try{
            String query = "UPDATE LINH_VUC SET NAME = ? WHERE ID = ? ";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, linhVuc.getName());
            pst.setInt(2, linhVuc.getId());
            
            result = pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            con.rollback();
        }
        return result;
    }
    
    public static int insertLinhVuc(LinhVucDTO linhVuc) throws SQLException{
        int result = 0;
        Connection con = DatabaseUtil.DatabaseConnection.createConnection();
        try{
            String query = "INSERT INTO LINH_VUC(ID, NAME) VALUES(? , ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, linhVuc.getId());
            pst.setString(2, linhVuc.getName());
            
            result = pst.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            con.rollback();
        }
        return result;
    }
}
