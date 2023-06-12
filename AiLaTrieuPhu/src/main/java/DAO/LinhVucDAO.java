/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.ailatrieuphu.DTO.LinhVucDTO;
import java.sql.Connection;
import java.sql.ResultSet;
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
}
