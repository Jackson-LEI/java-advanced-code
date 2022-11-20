package classTeaching.week13;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDemo {
    public static void main(String[] args) {
        MyDB md = new MyDB();
        String s = "select * from member;";
        ResultSet rs = md.doQuery(s);
        try {
            while(rs.next()){
                System.out.println(rs.getMetaData());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
