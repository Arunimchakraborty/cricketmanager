import java.util.Scanner;
import java.util.Random;
public class backend {
    Random random = new Random();
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
    int bat_agg=3;
    int field_agg=3;
    int wickets = 0;
    int overs = 0;
    int toss;
    int toss_called;

    String imdt_outcome[] = new String[7];
    boolean out(boolean b){
        if(b == true){
        System.out.println("OUT!!");
        wickets++;
        balls++;
        game_balls++;
        System.out.println("Runs Scored : " + runs);
        System.out.println("balls faced : " + balls);
        System.out.println("Score - " + game_runs + "/" + wickets);
        runs = 0;
        balls = 0;
        imdt_outcome[game_balls] = "OUT!";
        return true;
        }
        else {
            return false;
        }
    }

    int run0(){
        System.out.println("0 Runs");
        balls++;
        game_balls++;
        imdt_outcome[game_balls] = "0";
        return(0);
    }

    int run1(){
        System.out.println("1 Run");
        runs++;
        game_runs++;
        balls++;
        game_balls++;
        imdt_outcome[game_balls] = "1";
        return(1);
    }

    int run2(){
        System.out.println("2 Run");
        runs+=2;
        game_runs+=2;
        balls++;
        game_balls++;
        imdt_outcome[game_balls] = "2";
        return(2);
    }

    int run3() {
        System.out.println("3 Run");
        runs += 3;
        game_runs+=3;
        balls++;
        game_balls++;
        imdt_outcome[game_balls] = "3";
        return(3);
    }

    int run4() {
        System.out.println("4 Run");
        runs += 4;
        game_runs+=4;
        balls++;
        game_balls++;
        imdt_outcome[game_balls] = "4";
        return(4);
    }

    int run6() {
        System.out.println("6 Run");
        runs += 6;
        game_runs+=6;
        balls++;
        game_balls++;
        imdt_outcome[game_balls] = "6";
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

    void outcomeDetermine(){     
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
        if(game_balls==1){
            imdt_outcome[2] = imdt_outcome[3] = imdt_outcome[4] = imdt_outcome[5] = imdt_outcome[6] = null;
        }
        return;
        
    
    }

    void over(){
        System.out.println("End of over");
        System.out.println("Score - " + game_runs + "/" + wickets);
        overs++;
        System.out.println("Overs " + overs);
        game_balls = 0;
    }

    void innings(){
            System.out.println("End of innings");
            System.out.println("Total runs - " + game_runs);
            System.out.println("Total Wickets - " + wickets);
            if(overs != 20){
                System.out.println("Overs - " + overs + "." + game_balls);
                return;
            }
            else{
                System.out.println("Overs - 20.0");
                return;
            }
            
        
    }

    int Toss(){
        toss = random.nextInt(2);
        return toss;
    }

}


