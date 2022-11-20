package classTeaching.week13;

public class UpdateDemo {
    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection c = DriverManager.getConnection(
//                    "jdbc:mysql://127.0.0.1:3306/mydb2021?user=root&password=jinlei20011218");
//            Statement s = c.createStatement();
            String update = "update member set password='112233' where name ='À×±¦'";
            MyDB db = new MyDB();
            db.doUpdate(update);
            db.close();
//            int n = s.executeUpdate(update);
//            if(n>0){
//                JOptionPane.showMessageDialog(null,"ÐÞ¸Ä³É¹¦£¡");
//            }
//            s.close();
//            c.close();
//            System.exit(0);
//        } catch (ClassNotFoundException | SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
}
