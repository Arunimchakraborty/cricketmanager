public class pointsAllocForBowling {

    int oversInGame;
    int oversOfBowler;
    int wicketsOfBowler;
    int wicketsInGame;
    int bowlerType;

    float[] points = new float[22];

    public pointsAllocForBowling(int oversInGame, int wicketsInGame) {
        this.oversInGame = oversInGame;
        this.wicketsInGame = wicketsInGame;
    }

    void setPointsAtStart(){
        for (int i = 0; i < 22; i++) {
            points[i] = 20;
        }
    }

    float[] setPoints(int bowlerType){

        if(oversInGame<6){

        }





        return points;
    }
}
