package classTeaching.week13;

import java.sql.*;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/mydb?user=root&password=20011218");

            String mysql = "select * from member where name = ? and password = ?";
            PreparedStatement ps = c.prepareStatement(mysql);
            ps.setString(1,"'½ðÀ×'");
            ps.setString(2,"'102030'");
            ResultSet rs = ps.executeQuery(mysql);

            while (rs.next()){
                System.out.println(rs.getString("name")+"\t"+rs.getString("password"));
            }
//            int index = 1;
//            while (rs.next()) {
//                while (index < rs.getMetaData().getColumnCount()) {
//                    System.out.print(rs.getString(index++) + "\t");
//                }
//            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nfinished!");
    }
}
