import java.util.Random;
import java.sql.*;
import java.util.Scanner;

class funcOnVars extends dbvars{
    
    dbvars obj1 = new dbvars();
    int bat_skill;
    int bowl_skill;
    Random random = new Random();
    int runs, balls;

    int rand(int h, int l){
        int rand = random.nextInt(h) - l;
        return rand;
    }

    app a = new app();
    
    Scanner sc = new Scanner(System.in);

    void selctBatsman(){
        try{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playersdb", "root", "AruniM@123");
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of batsman");
        int bat_id = sc.nextInt();
        ResultSet rs = stmt.executeQuery("select* from trial1");
        rs.absolute(bat_id);
        bat_skill = rs.getInt(4);
        System.out.println("Enter id of bowler");
        int bowl_id = sc.nextInt();
        rs.absolute(bowl_id);
        bowl_skill = rs.getInt(5);
        }
        catch(SQLException e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    boolean out(boolean b){
        if(b == true){
        System.out.println("OUT!!");
        System.out.println("Total Runs Scored : " + runs);
        System.out.println("Total balls faced : " + balls);
        runs = 0;
        return true;
        }
        else {
            return false;
        }
    }

    void run0(){
        System.out.println("0 Runs");
        balls++;
    }

    void run1(){
        System.out.println("1 Run");
        runs++;
        balls++;
    }

    void run2(){
        System.out.println("2 Run");
        runs+=2;
        balls++;
    }

    void run3() {
        System.out.println("3 Run");
        runs += 3;
        balls++;
    }

    void run4() {
        System.out.println("4 Run");
        runs += 4;
        balls++;
    }

    void run6() {
        System.out.println("6 Run");
        runs += 6;
        balls++;
    }

    int lout = -137;
    int hout = -120;
    int l0 = -119;
    int h0 = 0;
    int l1 = 1;
    int h1 = 124;
    int l2 = 125;
    int h2 = 146;
    int l3 = 147;
    int l4 = 148;
    int h4 = 185;
    int l6 = 186;
    int h6 = 200;


    void outcomeDetermine(){
        selctBatsman();        
        while (sc.nextLine() != "n"){
            int luck = rand(350, 150);
            int dice = 2*bat_skill - 2*bowl_skill + luck;
        if(random.nextInt(200) == 100){
            out(true);
            break;
        }    
        if(dice<=hout){
            out(true);
            break;
        }
        if (dice >= l0 && dice <= h0) {
            run0();
        }
        if (dice >= l1 && dice <= h1) {
            run1();
        }
        if (dice >= l2 && dice <= h2) {
            run2();
        }
        if(dice==l3){
            run3();
        }
        if (dice >= l4 && dice <= h4) {
            run4();
        }
        if (dice >= l6) {
            run6();
        }
        
    }
    }

}
