import java.util.Random;

import javax.swing.JFrame;

public class backend extends JFrame{

    //Creating objects for utility purpose
    private Random randobj = new Random();

    int rand(int h, int l){
        int rand = randobj.nextInt((h-l)+1)+l;
        return rand;
    }
    
    

    //Creating variables

    //Batting related Attributes
    private int[] batsman_runs = new int[11];
    private int[] batsman_balls_played = new int[11];
    private int[] frontFootSkill = new int[11];
    private int[] backFootSkill = new int[11];
    private int[] offSideSkill = new int[11];
    private int[] onSideSkill = new int[11];
    private int[] strokePlay = new int[11];
    private int[] AgainstPace = new int[11];
    private int[] AgainstSpin = new int[11];
    private int[] batsmanFinalSkill = new int[11];

    //Game mechanics related Attributes
    public int team_runs;
    public int wickets;
    public int overs;
    public int over_balls;
    private int innings_balls;
    private int[] runs_in_over = new int[20];
    private int[] wickets_in_over = new int[20];
    private int batsmanIndex;
    private int bowlerIndex;
    private int fieldAggression;
    private int battingAggression;
    public int outcomeForDB;

    //Bowling related Attributes
    private int[] bowler_runs = new int[11];
    private int[] bowler_wickets = new int[11];
    private int[] bowler_overs = new int[11];
    private int[] bowler_balls = new int[11];
    private int[] spin = new int[11];
    private int[] seam = new int[11];
    private int[] drift = new int[11];
    private int[] swing = new int[11];
    private int[] accuracy = new int[11];
    private int[] variations = new int[11];
    private int[] bowlerFinalSkill = new int[11];
    private int[] bowlerCategory = new int[11];

    //Skill Assignment Variables
    private int movementOfPitch;
    private int movementInAir;
    private int SideSkill;
    private int FootSkill;
    private int AgainstSkill;
    private int bowlerSkill;
    private int batsmanSkill;
    private int line;
    private int length;


    public void batsmanIndexSetterAtDefault() {
        batsmanIndex = 1;
    }

    public void bowlerIndexSetterAtDefault() {
        bowlerIndex = 10;
    }
    


    

    void setSkills(){
        //For bowlers
        if(bowlerCategory[bowlerIndex] == 1){//For Fast Bowlers
            this.movementInAir = swing[bowlerIndex];
            this.movementOfPitch = seam[bowlerIndex];
            this.bowlerFinalSkill[bowlerIndex] = (movementInAir+movementOfPitch+accuracy[bowlerIndex])/3;
        }

        else if(bowlerCategory[bowlerIndex] == 0){
            this.movementInAir = drift[bowlerIndex];
            this.movementOfPitch = spin[bowlerIndex];
            this.bowlerFinalSkill[bowlerIndex] = (movementInAir+movementOfPitch+accuracy[bowlerIndex]+
                                    variations[bowlerIndex])/4;
        }

        //For Batsman
        //Line
        if(line==1 || line==2 || line==3){
            this.SideSkill = offSideSkill[batsmanIndex];
        }
        else if(line==3){
            if(randobj.nextInt(2)==1){
                this.SideSkill = offSideSkill[batsmanIndex];
            }
            else{
                this.SideSkill = onSideSkill[batsmanIndex];
            }
        }
        else if(line==4 || line==5){
            this.SideSkill = onSideSkill[batsmanIndex];
        }

        //Length
        if(length==4 || length == 5){
            this.FootSkill = backFootSkill[batsmanIndex];
        }
        else if(length==3){
            if(randobj.nextInt(2)==1){
                this.FootSkill = backFootSkill[batsmanIndex];
            }
            else{
                this.FootSkill = frontFootSkill[batsmanIndex];
            }
        }
        else if(length==1 || length==2){
            this.FootSkill = frontFootSkill[batsmanIndex];
        }

        //spin or pace skill
        if(bowlerCategory[bowlerIndex] == 1){
            AgainstSkill = AgainstPace[batsmanIndex];
        }
        else{
            AgainstSkill = AgainstSpin[batsmanIndex];
        }

        //batsman skill
        batsmanFinalSkill[batsmanIndex] = (FootSkill+SideSkill+strokePlay[batsmanIndex]+AgainstSkill)/4;

    }

    void setLine(int Line){
        /*
            1 - wide outside offstump
            2 - offstump channel
            3 - offstump
            4 - middle stump
            5 - leg stump
        */
        this.line = Line; 
    }

    void setLength(int Length){
        /*
            1 - yorker
            2 - full length
            3 - good length
            4 - short of good length
            5 - bouncer
        */
        this.length = Length;
    }

    void backendIfElses(){

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


    if (battingAggression == 1 || fieldAggression == 1){
        h-=40;
        l+=15;
    }
    if (battingAggression == 2 || fieldAggression == 2){
        h-=20;
        l+=7;
    }
    if (battingAggression == 3 || fieldAggression == 3){
        h+=0;
        l+=0;
    }
    if (battingAggression == 4 || fieldAggression == 4){
        h+=20;
        l-=7;
    }
    if (battingAggression == 5 || fieldAggression == 5){
        h+=40;
        l-=15;
    }


    int luck = rand(h, l);
    int dice = 4*(batsmanFinalSkill[batsmanIndex] - bowlerFinalSkill[bowlerIndex])/3 + luck;

    if(dice<=hout){
        outcomeForDB=out();
    }
    if (dice >= l0 && dice <= h0) {
        outcomeForDB=run0();
        
    }
    if (dice >= l1 && dice <= h1) {
        outcomeForDB=run1();
    }
    if (dice >= l2 && dice <= h2) {
        outcomeForDB=run2();
    }
    if(dice==l3){
        outcomeForDB=run3();
    }
    if (dice >= l4 && dice <= h4) {
        outcomeForDB=run4();
    }
    if (dice >= l6) {
        outcomeForDB=run6();
    }

    if (over_balls == 6){
        over();
    }

    if (overs == 20 || wickets == 10){
        innings();
    }
    return;

    }

    int out(){
        System.out.println("Out");
        over_balls++;
        batsman_balls_played[batsmanIndex]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        batsmanIndex++;
        wickets++;
        bowler_wickets[bowlerIndex]++;
        wickets_in_over[overs]++;
        return(-1);
    }

    int run0(){
        System.out.println("0 Runs");
        over_balls++;
        batsman_balls_played[batsmanIndex]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        return(0);
    }

    int run1(){
        System.out.println("1 Run");
        team_runs++;
        batsman_runs[batsmanIndex]++;
        bowler_runs[bowlerIndex]++;
        runs_in_over[overs]++;
        over_balls++;
        batsman_balls_played[batsmanIndex]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        return(1);
    }

    int run2(){
        System.out.println("2 Run");
        team_runs+=2;
        batsman_runs[batsmanIndex]+=2;
        bowler_runs[bowlerIndex]+=2;
        runs_in_over[overs]+=2;
        over_balls++;
        batsman_balls_played[batsmanIndex]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        return(2);
    }

    int run3() {
        System.out.println("3 Run");
        team_runs+=3;
        batsman_runs[batsmanIndex]+=3;
        bowler_runs[bowlerIndex]+=3;
        runs_in_over[overs]+=3;
        over_balls++;
        batsman_balls_played[batsmanIndex]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        return(3);
    }

    int run4() {
        System.out.println("4 Run");
        team_runs+=4;
        batsman_runs[batsmanIndex]+=4;
        bowler_runs[bowlerIndex]+=4;
        runs_in_over[overs]+=4;
        over_balls++;
        batsman_balls_played[batsmanIndex]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        return(4);
    }

    int run6() {
        System.out.println("6 Run");
        team_runs+=6;
        batsman_runs[batsmanIndex]+=6;
        bowler_runs[bowlerIndex]+=6;
        runs_in_over[overs]+=6;
        over_balls++;
        batsman_balls_played[batsmanIndex]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        return(6);
    }

    void over(){
        System.out.println("End of over");
        System.out.println("Score - " + team_runs + "/" + wickets);
        overs++;
        System.out.println("Overs " + overs);
        over_balls = 0;
        bowler_overs[bowlerIndex]++;
    }

    void innings(){
            System.out.println("End of innings");
            System.out.println("Total runs - " + team_runs);
            System.out.println("Total Wickets - " + wickets);
            if(overs != 20){
                System.out.println("Overs - " + overs + "." + over_balls);
                return;
            }
            else{
                System.out.println("Overs - 20.0");
                return;
            }
            
        
    }
 

    void settingAttributesRandomly(){
        int it = 0;
        for(int i =0; i<11; i++){
            frontFootSkill[i] = rand(90, 80) - it;
            backFootSkill[i] = rand(90, 80) - it;
            offSideSkill[i] = rand(90, 80) - it;
            onSideSkill[i] = rand(90, 80) - it;
            AgainstPace[i] = rand(90, 80) - it;
            AgainstSpin[i] = rand(90, 80) - it;
            strokePlay[i] = rand(90, 80) - it;
            it+=3;
        }
        it = 0;
        for(int i = 10; i>-1; i--){
            if(bowlerCategory[i] == 1){
                swing[i] = rand(90, 80) - it;
                seam[i] = rand(90, 80) - it;
                accuracy[i] = rand(90, 80) - it;
                variations[i] = rand(90, 80) - it;
                it+=3;
            }
            else{
                spin[i] = rand(90, 80) - it;
                drift[i] = rand(90, 80) - it;
                accuracy[i] = rand(90, 80) - it;
                variations[i] = rand(90, 80) - it;
                it+=3;
            }
        }
        it=0;
        for(int i = 0; i<11; i++){
            if(i>6){
                bowlerCategory[i] = randobj.nextInt(1);
            }
            else{
                bowlerCategory[i] = randobj.nextInt(1);
            }
        }
    }

    void setOrderOfEvents(){
        settingAttributesRandomly();
        bowlerIndexSetterAtDefault();
        batsmanIndexSetterAtDefault();
        setSkills();
        //set line
        //set length
        backendIfElses();
    }


    public backend() {
    }



    public backend(int line, int length, int fieldAggression, int battingAggression) {
        this.line = line;
        this.length = length;
        this.fieldAggression = fieldAggression;
        this.battingAggression = battingAggression;
    }

    public boolean inningEndorNot(){
        if(overs == 20 || wickets ==10){
            return false;
        }
        else{
            return true;
        }
    }


}