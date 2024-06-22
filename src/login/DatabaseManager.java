package login;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class DatabaseManager {
    private static String DB_URL = "jdbc:mysql://localhost:3306/appchat?useSSL=false";
    private static String USER_NAME = "root";
    private static String PASSWORD = "27105";

    public static void main(String args[]) {
        try {
            
            Connection conn = openConnection();
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("select * from login");
            
            while (rs.next()) {
                System.out.println(rs.getString(1) 
                        + "  " + rs.getString(2)+ " " + rs.getString(3) + " " + rs.getString(4));
            }
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}