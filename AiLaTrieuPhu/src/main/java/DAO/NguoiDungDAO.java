/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mycompany.ailatrieuphu.DTO.NguoiDungDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nguyen.vu
 */
public class NguoiDungDAO {
    public static NguoiDungDTO login(String taiKhoan, String matKhau){
        NguoiDungDTO nguoiDung = null;
        try{
            String query = "SELECT TAI_KHOAN, HO_TEN, GIOI_TINH, NAM_SINH, QUE_QUAN FROM NGUOI_DUNG WHERE TAI_KHOAN = ? AND MAT_KHAU = ?";
            Connection con = DatabaseUtil.DatabaseConnection.createConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, taiKhoan);
            statement.setString(2, matKhau);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                nguoiDung = new NguoiDungDTO();
                nguoiDung.setTaiKhoan(rs.getString(1));
                nguoiDung.setHoTen(rs.getString(2));
                nguoiDung.setGioiTinh(rs.getString(3));
                nguoiDung.setNamSinh(rs.getInt(4));
                nguoiDung.setQueQuan(rs.getString(5));
            }
        }
        catch(Exception e){
            e.printStackTrace(); // In lỗi
        }
        return nguoiDung;
    }
    
    public static int register(NguoiDungDTO nguoiDung) throws SQLException{
        int success = 0; // 0 rows inserted
        Connection con = DatabaseUtil.DatabaseConnection.createConnection();

        try{
            String query = "INSERT INTO nguoi_dung " +
                        "(" +
                        "	tai_khoan," +
                        "	mat_khau," +
                        "	ho_ten," +
                        "	gioi_tinh," +
                        "	nam_sinh," +
                        "	que_quan" +
                        ") " +
                        "VALUES" +
                        "(" +
                        "	?," +
                        "    ?," +
                        "    ?," +
                        "    ?," +
                        "    ?," +
                        "    ?" +
                        ")";

            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, nguoiDung.getTaiKhoan());
            statement.setString(2, nguoiDung.getMatKhau());
            statement.setString(3, nguoiDung.getHoTen());
            statement.setString(4, nguoiDung.getGioiTinh());
            statement.setInt(5, nguoiDung.getNamSinh());
            statement.setString(6, nguoiDung.getQueQuan());
            
            success = statement.executeUpdate(); // Trả về số 1, tức có 1 dòng dc ghi xuống csdl
            
        }
        catch(Exception e){
            e.printStackTrace();
            con.rollback();
        }
        
        return success;
    }
}
