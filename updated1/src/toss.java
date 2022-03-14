import java.util.Random;

public class toss {
    
    Random rand = new Random();

    private String tossOutcome = "";
    public String tossChosen = "";
    public String tossWinStatus = "";
    public String choiceUserAfterWinningToss = "";

    void setTossOutcomeUsingRandomVariable(){
        int tossVar = rand.nextInt(2);
        if(tossVar == 0){
            tossOutcome = "Heads";
        }
        else if(tossVar == 1){
            tossOutcome = "Tails";
        }
    }

    void determineTossOutcome(){
        if(tossChosen == tossOutcome){
            tossWinStatus = "Win";
        }
        else{
            tossWinStatus = "Loss";
        }
    }


    


}
