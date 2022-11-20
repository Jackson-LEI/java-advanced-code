package classTeaching.week13;

import java.sql.*;

public class MyDB {
    private Connection c;
    private Statement s;
    private PreparedStatement ps;
    private ResultSet rs;

    public MyDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","20011218");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int doUpdate(String sql) {
        int n = 0;
        try {
            this.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    public ResultSet doQuery(String sql) {
        try {
            rs = this.getStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (s != null) {
                s.close();
            }
            if(c !=null){
                c.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public MyDB(String dirverClass, String url, String user, String password) {
        try {
            Class.forName(dirverClass);
            c = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        try {
            s = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            ps = c.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

}
