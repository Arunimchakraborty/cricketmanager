import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

public class dbclass1 extends JFrame implements variablesForUse {
    String url = "jdbc:mysql://localhost:3306/cric_manager";
    String username = "root";
    String password = "AruniM@123";
    Connection con;
    Statement stmt;

    void setConn() {
        try {
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    void setAllSkillsFromDB() throws Exception {
        String selectFromPlayerTeamQ = "SELECT * FROM batting_skills b JOIN player_info p ON p.id = b.id WHERE p.country = 'India'";
        String selectFromPlayerTeamQBowl = "SELECT * FROM bowling_skills b JOIN player_info p ON p.id = b.id WHERE p.country = 'India'";
        String selectFromOppTeamQ = "SELECT * FROM batting_skills b JOIN player_info p ON p.id = b.id WHERE p.country = 'England'";
        String selectFromOppTeamQBowl = "SELECT * FROM bowling_skills b JOIN player_info p ON p.id = b.id WHERE p.country = 'England'";

        ResultSet rs1 = stmt.executeQuery(selectFromPlayerTeamQ);
        rs1.next();
        for (int i = 0; i < 11; i++) {
            frontFootSkill[i] = rs1.getInt("front_foot");
            backFootSkill[i] = rs1.getInt("back_foot");
            offSideSkill[i] = rs1.getInt("off_side");
            onSideSkill[i] = rs1.getInt("on_side");
            strokePlay[i] = rs1.getInt("stroke_play");
            AgainstSpin[i] = rs1.getInt("against_spin");
            AgainstPace[i] = rs1.getInt("against_pace");
            rs1.next();
        }
        rs1.close();

        ResultSet rs1b = stmt.executeQuery(selectFromPlayerTeamQBowl);
        rs1b.next();
        for (int i = 0; i < 11; i++) {

            bowlerCategory[i] = rs1b.getInt("bowling_style");
            spin[i] = seam[i] = rs1b.getInt("spin/seam");
            drift[i] = swing[i] = rs1b.getInt("drift/swing");
            accuracy[i] = rs1b.getInt("accuracy");
            variations[i] = rs1b.getInt("variations");

            rs1b.next();

        }
        rs1b.close();

        ResultSet rs2 = stmt.executeQuery(selectFromOppTeamQ);
        rs2.next();
        for (int j = 11; j < 22; j++) {
            frontFootSkill[j] = rs2.getInt("front_foot");
            backFootSkill[j] = rs2.getInt("back_foot");
            offSideSkill[j] = rs2.getInt("off_side");
            onSideSkill[j] = rs2.getInt("on_side");
            strokePlay[j] = rs2.getInt("stroke_play");
            AgainstSpin[j] = rs2.getInt("against_spin");
            AgainstPace[j] = rs2.getInt("against_pace");
            rs2.next();
        }
        rs2.close();

        ResultSet rs2b = stmt.executeQuery(selectFromOppTeamQBowl);
        rs2b.next();

        for (int j = 11; j < 22; j++) {

            bowlerCategory[j] = rs2b.getInt("bowling_style");
            spin[j] = seam[j] = rs2b.getInt("spin/seam");
            drift[j] = swing[j] = rs2b.getInt("drift/swing");
            accuracy[j] = rs2b.getInt("accuracy");
            variations[j] = rs2b.getInt("variations");

            rs2b.next();
        }
        rs2b.close();
    }

    void setnames() throws SQLException {
        String query = "SELECT * FROM player_info";

        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        for (int i = 0; i < 22; i++) {
            playerName[i] = rs.getString("first_name") + " " + rs.getString("last_name");
            rs.next();
        }
        rs.close();

    }

    dbclass1() {
        setConn();
        try {
            setAllSkillsFromDB();
            setnames();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
