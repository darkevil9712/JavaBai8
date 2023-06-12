/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.ailatrieuphu.DTO.MucDoDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author nguyen.vu
 */
public class MucDoDAO {
    public static List<MucDoDTO> getDanhSachMucDo(){
        List<MucDoDTO> result = new ArrayList<MucDoDTO>(); // khai báo danh sách đối tượng rỗng
        try{
            String query = "SELECT * FROM MUC_DO";
            Connection con = DatabaseUtil.DatabaseConnection.createConnection();
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while(rs.next()){
                MucDoDTO mucDo = new MucDoDTO();
                mucDo.setId(rs.getInt(1));
                mucDo.setName(rs.getString(2));
                
                result.add(mucDo);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
}
