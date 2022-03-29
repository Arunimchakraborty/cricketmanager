import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbclass1 {
    String url;
    String username;
    String password;
    Connection con;
    Statement stmt;

    void setConn() {
        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
