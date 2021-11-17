import java.sql.*;
import java.util.Scanner;


public class db{

    void show(){
    try {
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/playersdb","root","AruniM@123");
    Statement stmt=con.createStatement();  
    ResultSet rs = stmt.executeQuery("select* from trial1");
    while(rs.next())
    System.out.println("Database Id : " + rs.getInt(1) + " ID: " + rs.getRow() + " Name: " + rs.getString(2) + " Role: " + rs.getString(3) + " Batskill: " + rs.getInt(4) + " Bowlskill: " + rs.getInt(5));
        }
    catch(Exception e){System.out.println(e);}
    }

    void insert(){
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playersdb", "root", "AruniM@123");
            PreparedStatement stmt = con.prepareStatement("insert into trial1(name,role,batskill,bowlskill) values(?,?,?,?)");
            System.out.println("Enter name first, role second, batskill third, bowlskill fourth");
            String name = sc.nextLine();
            String role = sc.nextLine();
            int batskill = sc.nextInt();
            int bowlskill = sc.nextInt();
            stmt.setString(1, name);
            stmt.setString(2, role);
            stmt.setInt(3, batskill);
            stmt.setInt(4, bowlskill);
            int i = stmt.executeUpdate();
            System.out.println(i+" records affected"); 
            return;

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void delete(){
        try {
            Scanner sc = new Scanner(System.in);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playersdb", "root", "AruniM@123");
            PreparedStatement stmt = con.prepareStatement("delete from trial1 where id = ?;");
            PreparedStatement reset = con.prepareStatement("ALTER TABLE trial1 AUTO_INCREMENT = 1");
            System.out.println("Enter ID you wish to delete");
            int id = sc.nextInt();
            stmt.setInt(1, id);
            int result = stmt.executeUpdate();
            reset.executeUpdate();
            System.out.println("Number of records affected :: " + result);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
}
