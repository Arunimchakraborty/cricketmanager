import java.util.Scanner;
import java.util.Random;
public class trial {
    Random random = new Random();
    int rand(int h, int l){
        return random.nextInt(h - l) + l;
    }
    Scanner sc = new Scanner(System.in);
    int runs;
    int balls;
    int bat_skill = 85;
    int bowl_skill = 82;
    int bat_agg = 3;
    int field_agg = 3;
    boolean out(boolean b){
        if(b == true){
        System.out.println("OUT!!");
        System.out.println("Total Runs Scored : " + runs);
        System.out.println("Total balls faced : " + balls);
        runs = 0;
        balls = 0;
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
        while (sc.nextLine() != "n"){
            int luck = rand(200, -145);
            int dice = 2*bat_skill - 2*bowl_skill + luck;
        if (bat_agg == 1 || field_agg == 1){
            luck = rand(280, -10);
        }
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


