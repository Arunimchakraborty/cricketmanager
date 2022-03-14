import java.util.Random;

public class App {

    static Random rand = new Random();

    public static void main(String[] args) throws Exception {
        int line, length, fieldAggression, battingAggression;
        backend bck;
        line = rand.nextInt(5)+1;
        length = rand.nextInt(5)+1;
        fieldAggression = rand.nextInt(5)+1;
        battingAggression = rand.nextInt(5)+1;
        bck = new backend(line, length, fieldAggression, battingAggression);

        while(true){
            bck.setOrderOfEvents();
            if(bck.inningEndorNot() == false){
                break;
            }
        }
    }
}
