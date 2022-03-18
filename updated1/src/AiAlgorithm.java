public class AiAlgorithm extends backend2 {

    private boolean userBatting;

    int lowestFinder(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    AiAlgorithm() {

        float runRate = (float) team_runs / ((float) overs + (float) over_balls * 100 / 6);
        if (userBatting == false) {

            if (overs < 6) {
                if (runRate >= 9) {
                    fieldAggression = 3;
                } else if (runRate <= 7 || wickets >= 2) {
                    fieldAggression = 5;
                } else {
                    fieldAggression = 4;
                }
            } else if (overs >= 6 & overs < 15) {
                if (runRate >= 9) {
                    fieldAggression = 1;
                } else if (runRate <= 6.5 || wickets >= 5) {
                    fieldAggression = 3;
                } else {
                    fieldAggression = 2;
                }
            } else if (overs >= 15) {
                fieldAggression = 1;
            }

        }

    }

}
