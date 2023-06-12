/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.ailatrieuphu.DTO.CauHoiDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nguyen.vu
 */
public class CauHoiDao {
    public static List<CauHoiDTO> getDanhSachCauHoi(int linhVuc, int mucDo){
        List<CauHoiDTO> lstCauHoi = new ArrayList<CauHoiDTO>();
        try{
            Connection con = DatabaseUtil.DatabaseConnection.createConnection();
            String query = "SELECT * FROM CAU_HOI WHERE LINH_VUC = ? AND MUC_DO = ? AND XOA = 0";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, linhVuc);
            preparedStatement.setInt(2, mucDo);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                CauHoiDTO cauHoiDTO = new CauHoiDTO();
                cauHoiDTO.setNoiDung(rs.getString(1));
                cauHoiDTO.setDapAnA(rs.getString(2));
                cauHoiDTO.setDapAnB(rs.getString(3));
                cauHoiDTO.setDapAnC(rs.getString(4));
                cauHoiDTO.setDapAnD(rs.getString(5));
                cauHoiDTO.setDapAnDung(rs.getString(6));
                cauHoiDTO.setLinhVuc(rs.getInt(7));
                cauHoiDTO.setMucDo(rs.getInt(8));
                cauHoiDTO.setXoa(rs.getInt(9));
                
                lstCauHoi.add(cauHoiDTO);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lstCauHoi;
    }
}
