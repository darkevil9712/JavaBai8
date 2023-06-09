/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.csdl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author nguyen.vu
 */
public class CSDL {

    public static void main(String[] args) {
        try{
            Connection con = DatabaseConnection.createConnection();
            
            
            String email = "nguyen@gmail.com"; // ' OR '1' = '1 = Test HACK SQL
            String password = "abc";
            
            String query = "SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ? ";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                System.out.println("Hello bạn " + rs.getString(2));
            }
            con.close();  
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Kết nối CSDL bị lỗi");
        }
    }
}
