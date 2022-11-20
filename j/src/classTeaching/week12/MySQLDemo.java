package classTeaching.week12;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class MySQLDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            String dbURL = "jdbc:mysql://localhost:3306/mydb";
//            String dbUser = "root";
//            String dbPassword = "20011218";
//            Connection c = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/mydb?user=root&password=20011218");

            Statement statement = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String mysql = "select * from member";
            ResultSet rs = statement.executeQuery(mysql);

            TableModel tb = new AbstractTableModel() {
                @Override
                public int getRowCount() {
                    int rowCount;
                    try {
                        rs.last();
                        rowCount = rs.getRow();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    return rowCount;
                }

                @Override
                public int getColumnCount() {
                    int columnCount;
                    try {
                        columnCount = rs.getMetaData().getColumnCount();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    return columnCount;
                }

                @Override
                public Object getValueAt(int rowIndex, int columnIndex) {
                    Object o;
                    try {
                        rs.absolute(rowIndex+1);
                        o = rs.getObject(columnIndex+1);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    return o;
                }

                @Override
                public String getColumnName(int column) {
                    String columnName = "";
                    try {
                        columnName = rs.getMetaData().getColumnName(column+1);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return columnName;
                }
            };

            JFrame j = new JFrame();
            JTable jt = new JTable(tb);
            j.add(new JScrollPane(jt));
            j.setSize(600,400);
            j.setVisible(true);
            j.setLocationRelativeTo(null);
            j.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    try {
                        rs.close();
                        statement.close();
                        c.close();
                        System.exit(0);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });

//            rs.absolute(3);
//            rs.updateString("password","777777");
//            rs.updateRow();
//            rs.updateString("name","777777");
//            rs.cancelRowUpdates();
//            rs.beforeFirst();

//            rs.moveToInsertRow();
//            rs.updateString(1,"Ð¡À×À×");
//            rs.updateString(2,"0000");
//            rs.insertRow();

//            rs.absolute(2);
//            rs.deleteRow();

//            while (rs.next()) {
//                System.out.println(rs.getString(1) + "\t"+rs.getString(2) + "\t"+rs.getString(3) +
//                        "\t"+rs.getString(4) + "\t"+rs.getString(5) + "\t"+rs.getString(6) + "\t"+rs.getString(7) + "\t");
//            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\nfinished!");
    }
}
