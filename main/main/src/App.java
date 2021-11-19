public class App {
    public static void main(String[] args) throws Exception {
        backend obj = new backend();
        int i = 10;
        // while(i>5){
        //     obj.outcomeDetermine();
        //     if(obj.overs == 20 || obj.wickets == 10){
        //         break;
        //     }
        //     i++;
        // }
        Process p = Runtime.getRuntime().exec("appletviewer src/GUI.java");
    }
}
