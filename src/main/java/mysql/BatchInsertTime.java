package main.java.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchInsertTime {
    public static void main(String args[]) throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }

        String url="jdbc:mysql://localhost:3306/test";

        Connection conn;
        try {
            String sql1 = "insert into test values(1)";


            long startTime=System.currentTimeMillis();

            conn = DriverManager.getConnection(url,"","");
            conn.setAutoCommit(false);
            long endTime=System.currentTimeMillis();
            System.out.println("connect db time: " + (endTime - startTime));

            PreparedStatement pst = conn.prepareStatement(sql1);

            for (int i = 0; i < 10000; i++) {
                pst.addBatch(sql1);
            }
            pst.executeBatch();
            conn.commit();
            pst.close();
            conn.close();

            long endTime2 =System.currentTimeMillis();
            System.out.println("insert time: " + (endTime2 - endTime));
            System.out.println("total time: " + (endTime2 - startTime));

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
