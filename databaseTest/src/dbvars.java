import java.sql.*;
import java.util.Scanner;

public class dbvars {

    private int bat_skill, bowl_skill;

    
    void vars(){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playersdb", "root", "AruniM@123");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter id of batsman");
            int bat_id = sc.nextInt();
            ResultSet rs = stmt.executeQuery("select* from trial1");
            rs.absolute(bat_id);
            bat_skill = rs.getInt(4);
            System.out.println("Batsman skill = " + bat_skill);
            System.out.println("Enter id of bowler");
            int bowl_id = sc.nextInt();
            rs.absolute(bowl_id);
            bowl_skill = rs.getInt(5);
            System.out.println("Bowler skill = " + bowl_skill);
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        
    }

    int getBat(){return bat_skill;}
    int getBowl(){return bowl_skill;}
}
