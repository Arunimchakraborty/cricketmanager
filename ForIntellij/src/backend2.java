import java.util.Random;

import javax.swing.JFrame;

public class backend2 extends dbclass1 {

    int startIndexForBowler = 11;
    miscFuncs m = new miscFuncs();

    // Creating objects for utility purpose
    public Random randobj = new Random();

    int rand(int h, int l) {// method for generating random values bw some range
        int rand = randobj.nextInt((h - l) + 1) + l;
        return rand;
    }

    int pitch = randobj.nextInt(5);

    // Creating variables

    // Batting related Attributes

    // Game mechanics related Attributes

    public int[] batsmanFinalSkill = new int[22];
    public int[] bowlerFinalSkill = new int[22];
    public int team_runs;
    public int wickets;
    public int overs;
    public int over_balls;
    private int innings_balls = 0;
    private int[] runs_in_over = new int[20];
    private int[] wickets_in_over = new int[20];
    public int batsmanIndexOnStrike = 0;
    public int batsmanIndexOffStrike = 1;
    public int bowlerIndex;
    public int fieldAggression = 3;
    public int battingAggression = 3;
    public int outcomeForDB;

    public int var1 = 0;

    // Bowling related Attributes

    public int[] bowler_runs = new int[22];
    public int[] bowler_wickets = new int[22];
    public int[] bowler_overs = new int[22];
    public int[] bowler_balls = new int[22];
    public float[] bowler_runRate = new float[22];
    public float[] bowler_points = new float[11];
    public float[] bowler_points_final = new float[11];

    // Skill Assignment Variables
    private int movementOfPitch;
    private int movementInAir;
    private int SideSkill;
    private int FootSkill;
    private int AgainstSkill;
    private int bowlerSkill;
    private int batsmanSkill;
    protected int line = 3;
    protected int length = 3;
    public int batsmanindex;
    public int[] whichBowlerBowledWhichOver = new int[20];
    public int target;
    public int whichInnings = 0;

    public int[] runsInEveryBall = new int[120];

    boolean userBatting = true;

    void setRunRates() {
        for (int i = 0; i < 22; i++) {
            if (bowler_overs[i] == 0) {
                continue;
            }
            bowler_runRate[i] = (float) bowler_runs[i] / (float) bowler_overs[i];
        }
    }

    void setIndexes() {
        if (!userBatting) {
            startIndexForBowler = 0;
            batsmanIndexOnStrike = 11;
            batsmanIndexOffStrike = 12;
        } else {
            startIndexForBowler = 11;
            batsmanIndexOnStrike = 0;
            batsmanIndexOffStrike = 1;
        }
    }

    void reset() {
        userBatting = !userBatting;
        var1 = 1;

        innings_balls = 0;
        target = team_runs;
        team_runs = 0;
        wickets = 0;
        overs = 0;
        over_balls = 0;
        for (int i = 0; i < 20; i++) {
            runs_in_over[i] = 0;
            wickets_in_over[i] = 0;
        }
        setIndexes();
    }

    /**
     * Basically
     */

    void setSkills() {

        // For bowlers
        if (bowlerCategory[bowlerIndex] == 1) {// For Fast Bowlers
            this.movementInAir = swing[bowlerIndex];
            this.movementOfPitch = seam[bowlerIndex];
            this.bowlerFinalSkill[bowlerIndex] = (movementInAir + movementOfPitch + accuracy[bowlerIndex]) / 3;
        } else if (bowlerCategory[bowlerIndex] == 0) {
            this.movementInAir = drift[bowlerIndex];
            this.movementOfPitch = spin[bowlerIndex];
            this.bowlerFinalSkill[bowlerIndex] = (movementInAir + movementOfPitch + accuracy[bowlerIndex] +
                    variations[bowlerIndex]) / 4;
        }

        // For Batsman
        // Line
        if (line == 1 || line == 2 || line == 3) {
            this.SideSkill = offSideSkill[batsmanIndexOnStrike];
        } else if (line == 3) {
            if (randobj.nextInt(2) == 1) {
                this.SideSkill = offSideSkill[batsmanIndexOnStrike];
            } else {
                this.SideSkill = onSideSkill[batsmanIndexOnStrike];
            }
        } else if (line == 4 || line == 5) {
            this.SideSkill = onSideSkill[batsmanIndexOnStrike];
        }

        // Length
        if (length == 4 || length == 5) {
            this.FootSkill = backFootSkill[batsmanIndexOnStrike];
        } else if (length == 3) {
            if (randobj.nextInt(2) == 1) {
                this.FootSkill = backFootSkill[batsmanIndexOnStrike];
            } else {
                this.FootSkill = frontFootSkill[batsmanIndexOnStrike];
            }
        } else if (length == 1 || length == 2) {
            this.FootSkill = frontFootSkill[batsmanIndexOnStrike];
        }

        // spin or pace skill
        if (bowlerCategory[bowlerIndex] == 1) {
            AgainstSkill = AgainstPace[batsmanIndexOnStrike];
        } else {
            AgainstSkill = AgainstSpin[batsmanIndexOnStrike];
        }

        // batsman skill
        batsmanFinalSkill[batsmanIndexOnStrike] = (FootSkill + SideSkill + strokePlay[batsmanIndexOnStrike]
                + AgainstSkill) / 4;

    }

    void setLine(int Line) {
        /*
         * 1 - wide outside offstump
         * 2 - offstump channel
         * 3 - offstump
         * 4 - middle stump
         * 5 - leg stump
         */
        this.line = Line;
    }

    void setLength(int Length) {
        /*
         * 1 - yorker
         * 2 - full length
         * 3 - good length
         * 4 - short of good length
         * 5 - bouncer
         */
        this.length = Length;
    }

    void backendIfElses() {


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

        if (battingAggression == 1 || fieldAggression == 1) {
            h -= 40;
            l += 15;
        }
        if (battingAggression == 2 || fieldAggression == 2) {
            h -= 20;
            l += 7;
        }
        if (battingAggression == 3 || fieldAggression == 3) {
            h += 0;
            l += 0;
        }
        if (battingAggression == 4 || fieldAggression == 4) {
            h += 20;
            l -= 7;
        }
        if (battingAggression == 5 || fieldAggression == 5) {
            h += 40;
            l -= 15;
        }

        int luck = rand(h, l);
        int dice = 2 * ((batsmanFinalSkill[batsmanIndexOnStrike]) - bowlerFinalSkill[bowlerIndex]) + luck;

        if (dice <= hout) {
            outcomeForDB = out();
        }
        if (dice >= l0 && dice <= h0) {
            outcomeForDB = run0();

        }
        if (dice >= l1 && dice <= h1) {
            outcomeForDB = run1();
        }
        if (dice >= l2 && dice <= h2) {
            outcomeForDB = run2();
        }
        if (dice == l3) {
            outcomeForDB = run3();
        }
        if (dice >= l4 && dice <= h4) {
            outcomeForDB = run4();
        }
        if (dice >= l6) {
            outcomeForDB = run6();
        }

        if (over_balls == 6) {
            over();
        }

        if (overs == 20 || wickets == 10) {
            innings();
        }
        return;

    }

    void changeStrike() {
        int temp = batsmanIndexOnStrike;
        batsmanIndexOnStrike = batsmanIndexOffStrike;
        batsmanIndexOffStrike = temp;
    }

    int out() {
        System.out.println("Out");
        runsInEveryBall[innings_balls] = -1;
        over_balls++;
        batsman_balls_played[batsmanIndexOnStrike]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        newBatsman();
        wickets++;
        bowler_wickets[bowlerIndex]++;
        wickets_in_over[overs]++;
        return (-1);
    }

    int run0() {
        System.out.println("0 Runs");
        runsInEveryBall[innings_balls] = 0;
        over_balls++;
        batsman_balls_played[batsmanIndexOnStrike]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        return (0);
    }

    int run1() {
        System.out.println("1 Run");
        runsInEveryBall[innings_balls] = 1;
        team_runs++;
        batsman_runs[batsmanIndexOnStrike]++;
        bowler_runs[bowlerIndex]++;
        runs_in_over[overs]++;
        over_balls++;
        batsman_balls_played[batsmanIndexOnStrike]++;
        bowler_balls[bowlerIndex]++;
        changeStrike();
        innings_balls++;
        return (1);
    }

    int run2() {
        System.out.println("2 Run");
        runsInEveryBall[innings_balls] = 2;
        team_runs += 2;
        batsman_runs[batsmanIndexOnStrike] += 2;
        bowler_runs[bowlerIndex] += 2;
        runs_in_over[overs] += 2;
        over_balls++;
        batsman_balls_played[batsmanIndexOnStrike]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        return (2);
    }

    int run3() {
        System.out.println("3 Run");
        runsInEveryBall[innings_balls] = 3;
        team_runs += 3;
        batsman_runs[batsmanIndexOnStrike] += 3;
        bowler_runs[bowlerIndex] += 3;
        runs_in_over[overs] += 3;
        over_balls++;
        batsman_balls_played[batsmanIndexOnStrike]++;
        bowler_balls[bowlerIndex]++;
        changeStrike();
        innings_balls++;
        return (3);
    }

    int run4() {
        System.out.println("4 Run");
        runsInEveryBall[innings_balls] = 4;
        team_runs += 4;
        batsman_runs[batsmanIndexOnStrike] += 4;
        bowler_runs[bowlerIndex] += 4;
        runs_in_over[overs] += 4;
        over_balls++;
        batsman_balls_played[batsmanIndexOnStrike]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        return (4);
    }

    int run6() {
        System.out.println("6 Run");
        runsInEveryBall[innings_balls] = 6;
        team_runs += 6;
        batsman_runs[batsmanIndexOnStrike] += 6;
        bowler_runs[bowlerIndex] += 6;
        runs_in_over[overs] += 6;
        over_balls++;
        batsman_balls_played[batsmanIndexOnStrike]++;
        bowler_balls[bowlerIndex]++;
        innings_balls++;
        return (6);
    }

    void over() {
        System.out.println("End of over");
        System.out.println("Score - " + team_runs + "/" + wickets);
        overs++;
        System.out.println("Overs " + overs);
        over_balls = 0;
        bowler_overs[bowlerIndex]++;
        whichBowlerBowledWhichOver[overs - 1] = bowlerIndex;
        System.out.println("batsman" + batsmanIndexOnStrike + ":" + batsman_runs[batsmanIndexOnStrike]);
        System.out.println("batsman" + batsmanIndexOffStrike + ":" + batsman_runs[batsmanIndexOffStrike]);
        System.out.println("bowlerIndex:" + bowlerIndex);
        System.out.println("Bowler who bowled the prev over: " + whichBowlerBowledWhichOver[overs - 1]);
        System.out.println("bat agg:" + battingAggression + " field:" + fieldAggression);
        System.out.println("line" + line + " length:" + length);
        System.out.println(playerName[batsmanIndexOnStrike]);
        changeStrike();
        bowlerIndexChooser();
    }

    void bowlerIndexChooser() {
        setPointsAtStart();
        bowlerIndex = (int) m.findMaxElementInArray(bowler_points_final)[0] + startIndexForBowler;
        if (bowlerIndex == whichBowlerBowledWhichOver[overs - 1]) {
            bowlerIndex = m.findSecondHighest(bowler_points_final) + startIndexForBowler;
        }
        if (bowler_overs[bowlerIndex] == 4) {
            bowlerIndex = m.findSecondHighest(bowler_points_final) + startIndexForBowler;
        }
        if ((accuracy[bowlerIndex] + variations[bowlerIndex] + swing[bowlerIndex] + seam[bowlerIndex]) < 220) {
            bowlerIndex = m.findSecondHighest(bowler_points_final) + startIndexForBowler;
        }
        System.out.println("Bowler recommended : " + playerName[bowlerIndex] + " Index : " + bowlerIndex);
    }

    void innings() {
        System.out.println("End of innings");
        System.out.println("Total runs - " + team_runs);
        System.out.println("Total Wickets - " + wickets);
        if (overs != 20) {
            System.out.println("Overs - " + overs + "." + over_balls);
        } else {
            System.out.println("Overs - 20.0");
        }
        System.out.println("\n\n---------------------\n\n");
        inningsSummary();
        if (userBatting == true) {
            reset();
        }

    }

    void settingAttributesRandomly() {
        // /**
        // * Because we dont have the db yet
        // * we have to set all attributes of all 11 players randomly
        // * when the db arrives we will have no use for this method
        // */
        // int it = 0;
        // for (int i = 0; i < 11; i++) {
        // frontFootSkill[i] = rand(90, 80) - it;
        // backFootSkill[i] = rand(90, 80) - it;
        // offSideSkill[i] = rand(90, 80) - it;
        // onSideSkill[i] = rand(90, 80) - it;
        // AgainstPace[i] = rand(90, 80) - it;
        // AgainstSpin[i] = rand(90, 80) - it;
        // strokePlay[i] = rand(90, 80) - it;
        // it += 3;
        // }
        // it = 0;
        // for (int i = 10; i > -1; i--) {
        // if (bowlerCategory[i] == 1) {
        // swing[i] = rand(90, 80) - it;
        // seam[i] = rand(90, 80) - it;
        // accuracy[i] = rand(90, 80) - it;
        // variations[i] = rand(90, 80) - it;
        // it += 3;
        // } else {
        // spin[i] = rand(90, 80) - it;
        // drift[i] = rand(90, 80) - it;
        // accuracy[i] = rand(90, 80) - it;
        // variations[i] = rand(90, 80) - it;
        // it += 3;
        // }
        // }
        // it = 0;
        // for (int i = 0; i < 11; i++) {
        // if (i > 6) {
        // bowlerCategory[i] = randobj.nextInt(1);
        // } else {
        // bowlerCategory[i] = randobj.nextInt(1);
        // }
        // }
    }

    void setOrderOfEvents() {
        // this is for setting order of events
        // whenever the bowl button will be pressed this method will get called
        // settingAttributesRandomly();
        setSkills();
        // set line
        // set length
        backendIfElses();
    }

    public backend2() {
        // an empty constructor
    }

    void inningsSummary() {
        for (int i = 0; i < 11; i++) {
            System.out.println("Batsman " + (i + 1) + " :" + batsman_runs[i] + "(" + batsman_balls_played[i] + ")");
        }
        System.out.println("\n------------------------------------\n");
        for (int i = 0; i < 11; i++) {
            System.out.println("Bowler " + (i + 1) + " :" + bowler_wickets[i + startIndexForBowler] + "/"
                    + bowler_runs[i + startIndexForBowler] + "(" + bowler_overs[i + startIndexForBowler] + "."
                    + (bowler_balls[i + startIndexForBowler] % 6) + ")");
        }
    }

    public boolean inningEndorNot() {
        if (overs == 20 || wickets == 10) {
            return false;
        } else {
            return true;
        }
    }

    void newBatsman() {
        if (batsmanIndexOnStrike > batsmanIndexOffStrike) {
            batsmanIndexOnStrike++;
        } else if (batsmanIndexOffStrike > batsmanIndexOnStrike) {
            batsmanIndexOnStrike = batsmanIndexOffStrike + 1;
        }
    }

    void setBatsmanIndexAtOpeners() {
        batsmanIndexOnStrike = 0;
        batsmanIndexOffStrike = 1;
    }

    public void backend2setters(int line, int length, int fieldAggression, int battingAggression, int bowlerIndex) {
        this.line = line;
        this.length = length;
        this.fieldAggression = fieldAggression;
        this.battingAggression = battingAggression;
        this.bowlerIndex = bowlerIndex;
        aIAlgorithmBackend();

    }

    public void setPointsAtStart() {


        for (int i = 0; i < bowler_points.length; i++) {
            bowler_points[i] = 800;
        }
        setPoints();
    }

    public void setPoints() {
        int categoryMod = 0;
        for (int i = 0; i < bowler_points.length; i++) {

            int j = i + startIndexForBowler;

            if (overs < 6) {
                if (bowlerCategory[j] == 1) {
                    bowler_points[i] -= (overs * 8);
                } else if (bowlerCategory[j] == 0) {
                    bowler_points[i] += overs * 8;
                }
            } else if (overs > 5 & overs < 15) {
                if (bowlerCategory[j] == 1) {
                    bowler_points[i] += (overs - 6) * 8;
                } else if (bowlerCategory[j] == 0) {
                    bowler_points[i] -= (overs - 6) * 8;
                }
            } else if (overs >= 15) {
                if (bowlerCategory[j] == 1) {
                    bowler_points[i] -= (overs - 12.5) * 8;
                } else if (bowlerCategory[j] == 0) {
                    bowler_points[i] += (overs - 12.5) * 8;
                }
            }

            if (bowlerCategory[j] == 1) {
                categoryMod = 1;
            } else if (bowlerCategory[j] == 0) {
                categoryMod = -1;
            }

            bowler_points[i] -= (categoryMod * (pitch - 2)) * 6;

            bowler_points[i] -= bowler_wickets[j] * 55;


            if (bowler_overs[j] == 0) {
                bowler_points_final[i] = (accuracy[j] + variations[j] +
                        swing[j] + seam[j]) / bowler_points[i];
                continue;
            }


            bowler_points[i] += bowler_overs[j] * bowler_overs[j] * 30;

            bowler_points[i] += (bowler_runs[j] / bowler_overs[j]) * 15;
            bowler_points_final[i] = (accuracy[j] + variations[j] +
                    swing[j] + seam[j]) / bowler_points[i];


        }
    }

    public void aIAlgorithmBackend() {

        float runRate = (float) team_runs / ((float) overs + (float) over_balls * 100 / 6);

        if (userBatting) {

            line = new Random().nextInt(5) % 4 + 1;
            length = new Random().nextInt(5) % 4 + 1;



            if (overs < 6) {
                fieldAggression = 4;
            } else if (overs >= 6 & overs < 15) {
                fieldAggression = 2;
            } else if (overs >= 15) {
                fieldAggression = 1;
            }
        } else {

            if (overs < 6) {
                battingAggression = 3;

                if (runRate < 7.5) {
                    battingAggression = 4;
                }

                if (wickets <= 2 & wickets != 0) {
                    battingAggression = 2;
                }

                if (wickets > 2) {
                    battingAggression = 1;
                }

            } else if (overs >= 6 & overs < 16) {

                battingAggression = 3;

                if (runRate < 7) {
                    battingAggression = 4;
                }

                if (wickets <= 4 & wickets != 0) {
                    battingAggression = 2;
                }

                if (wickets > 4) {
                    battingAggression = 1;
                }


            } else if (overs >= 16) {

                battingAggression = 5;

                if (wickets > 6) {
                    battingAggression = 4;
                }

                if (wickets > 8) {
                    battingAggression = 3;
                }


            }

        }


    }

}
