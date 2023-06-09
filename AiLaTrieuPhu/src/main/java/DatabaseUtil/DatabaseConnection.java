/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nguyen.vu
 */
public class DatabaseConnection {
    public static Connection createConnection(){
        Connection con = null;
        try{
            // Khai báo kết nối CSDL
            String url = "jdbc:mysql://localhost:3306/altp?autoReconnect=true&useSSL=false";
            String username = "root";
            String password = "";
            // Kết nói csdl
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection(url,username,password);  
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.out.println("Bị lỗi");
        }
        
        return con;
    }
}
