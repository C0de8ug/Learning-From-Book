package security.sqli;

import java.sql.*;

/**
 * Created by c0debug on 17-5-29.
 * 测试java的preparestatement对sql中存在'如何处理
 */
public class PrepareStatementTest {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/dvwa", "root","0313");
            String sql = "select * from users where first_name = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,"' or 1 = 1 ");

            //会对字符'做转义
            System.out.println(pst.toString());

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("user_id");
                System.out.println(id);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
