//This is not the correct code, refer to GUI.java, backend.java and App.java
import java.util.Scanner;
import java.util.Random;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Main extends Applet implements ItemListener, ActionListener{
/*
 <applet code="Main" width=300 height=250>
 </applet>
*/

Random random = new Random();
    GUI gui = new GUI();
    int rand(int h, int l){
        return random.nextInt(h - l) + l;
    }
    Scanner sc = new Scanner(System.in);
    int runs;
    int game_runs;
    int balls;
    int game_balls;
    int bat_skill = 85;
    int bowl_skill = 82;
    int bat_agg = 3;
    int field_agg = 3;
    int wickets = 0;
    int overs = 0;
    String imdt_outcome;
    boolean out(boolean b){
        if(b == true){
        System.out.println("OUT!!");
        wickets++;
        System.out.println("Runs Scored : " + runs);
        System.out.println("balls faced : " + balls);
        System.out.println("Score - " + game_runs + "/" + wickets);
        runs = 0;
        balls = 0;
        imdt_outcome = "OUT!";
        return true;
        }
        else {
            return false;
        }
    }

    int run0(){
        //System.out.println("0 Runs");
        balls++;
        game_balls++;
        imdt_outcome = "0";
        return(0);
    }

    int run1(){
        // System.out.println("1 Run");
        runs++;
        game_runs++;
        balls++;
        game_balls++;
        imdt_outcome = "1";
        return(1);
    }

    int run2(){
        // System.out.println("2 Run");
        runs+=2;
        game_runs+=2;
        balls++;
        game_balls++;
        imdt_outcome = "2";
        return(2);
    }

    int run3() {
        // System.out.println("3 Run");
        runs += 3;
        game_runs+=3;
        balls++;
        game_balls++;
        imdt_outcome = "3";
        return(3);
    }

    int run4() {
        // System.out.println("4 Run");
        runs += 4;
        game_runs+=4;
        balls++;
        game_balls++;
        imdt_outcome = "4";
        return(4);
    }

    int run6() {
        // System.out.println("6 Run");
        runs += 6;
        game_runs+=6;
        balls++;
        game_balls++;
        imdt_outcome = "6";
        return(6);
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
    int h = 200;
    int l = -143;

    int outcomeDetermine(){     
        h = 200;
        l = -143;
        if (bat_agg == 1 || field_agg == 1){
            h-=40;
            l+=20;
        }
        if (bat_agg == 2 || field_agg == 2){
            h-=20;
            l+=10;
        }
        if (bat_agg == 3 || field_agg == 3){
            h+=0;
            l+=0;
        }
        if (bat_agg == 4 || field_agg == 4){
            h+=20;
            l-=12;
        }
        if (bat_agg == 5 || field_agg == 5){
            h+=40;
            l-=24;
        }
        int luck = rand(h, l);
        int dice = 2*bat_skill - 2*bowl_skill + luck;
        if(random.nextInt(200) == 100){
            out(true);
        }    
        if(dice<=hout){
            out(true);
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

        if (game_balls == 6){
            over();
        }

        if (overs == 20 || wickets == 10){
            innings();
        }
        return -10;
        
    
    }

    void over(){
        System.out.println("End of over");
        System.out.println("Score - " + game_runs + "/" + wickets);
        overs++;
        System.out.println("Overs " + overs);
        game_balls = 0;
    }

    void innings(){
        if(overs == 20){
            System.out.println("End of innings");
            System.out.println("Total runs - " + game_runs);
            System.out.println("Total Wickets - " + wickets);
            if(overs != 10){
                System.out.println("Overs - " + overs + "." + game_balls);
                return;
            }
            else{
                System.out.println("Overs - 10.0");
                return;
            }
            
        }
    }





    Choice field, aggression;
    Button ball, changefield, changeaggressio;
    backend obj = new backend();
    public void init(){
        // setLayout(new GridLayout(2,3));
        field = new Choice();
        field.addItem("Very Aggressive");
        field.addItem("Aggressive");
        field.addItem("Moderate");
        field.addItem("Defensive");
        field.addItem("Very Defensive");
        aggression = new Choice();
        aggression.addItem("Very Aggressive");
        aggression.addItem("Aggressive");
        aggression.addItem("Moderate");
        aggression.addItem("Defensive");
        aggression.addItem("Very Defensive");
        Label agglb = new Label("Batsman Aggression");
        Label fieldlb = new Label("Field Aggression");
        ball.addActionListener(new Main());
        add(fieldlb);
        add(field);
        add(agglb);
        add(aggression);
        Label score = new Label(game_runs + "." + wickets + "\n" + "Overs - " + overs);
        add(score);
        Label outcomes = new Label("Outcomes \n\n" + imdt_outcome + "\n");
        add(outcomes);
    }

    public void itemStateChanged(ItemEvent ie) {
        if(field.getSelectedItem().equals("Very Aggressive"))
        {obj.field_agg = 5;}
        else if(field.getSelectedItem().equals("Aggressive"))
        {obj.field_agg = 4;}
        else if(field.getSelectedItem().equals("Moderate"))
        {obj.field_agg = 3;}
        else if(field.getSelectedItem().equals("Defensive"))
        {obj.field_agg = 2;}
        else if(field.getSelectedItem().equals("Very Defensive"))
        {obj.field_agg = 1;}

        if(aggression.getSelectedItem().equals("Very Aggressive"))
        {obj.bat_agg = 5;}
        else if(aggression.getSelectedItem().equals("Aggressive"))
        {obj.bat_agg = 4;}
        else if(aggression.getSelectedItem().equals("Moderate"))
        {obj.bat_agg = 3;}
        else if(aggression.getSelectedItem().equals("Defensive"))
        {obj.bat_agg = 2;}
        else if(aggression.getSelectedItem().equals("Very Defensive"))
        {obj.bat_agg = 1;}

        

        repaint();
    }

    public void actionPerformed(ActionEvent ae) {
            obj.outcomeDetermine();
    }

    public void paint(Graphics g){
            g.drawString("Cricket Game", 100, 100);
    }

    

    
}

    


