package main.java.mysql;

import java.io.*;
import java.sql.*;

/**
 * Created by huangxiaolong on 2016/12/7.
 */
public class OnceDBTime {
    public static void main(String args[]){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }

        String url="jdbc:mysql://localhost:3306/test";

        Connection conn;
        try {
            String sql1 = "SELECT *" +
                    "FROM test" ;


            long startTime=System.currentTimeMillis();

            conn = DriverManager.getConnection(url,"","");

            long endTime=System.currentTimeMillis();
            System.out.println("connect db time: " + (endTime - startTime));

            PreparedStatement pst = conn.prepareStatement(sql1);
            ResultSet rs2 = pst.executeQuery();

            pst.close();
            conn.close();

            long endTime2 =System.currentTimeMillis();
            System.out.println("query time: " + (endTime2 - endTime));
            System.out.println("total time: " + (endTime2 - startTime));

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
