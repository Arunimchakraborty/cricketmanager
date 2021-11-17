import java.util.Scanner;

public class app{
    public static void main(String[] args) {
        
        
        db obj = new db();
        dbvars obj1 = new dbvars();
        funcOnVars obj2 = new funcOnVars();
        int k = 10;
        int choice;
        while(k>5){
        Scanner sc = new Scanner(System.in);    
        System.out.println("Enter 1 to insert record, 2 to show record, 3 to delete a record and 4 to get specific info, 5 to exit, 6 to play");  
        choice = sc.nextInt();
        switch (choice) {
            case 1:
                obj.insert();
                k++;
                break;

            case 2:
                obj.show();
                k++;
                break;

            case 3:
                obj.delete();
                k++;
                break;

            case 4:
                obj1.vars();
                k++;
                break;

            case 5:
                k++;
                return;

            case 6:
                obj2.outcomeDetermine();
                break;
            default:
                k++;
                System.out.println("Enter valid input");
                break;   

        }
    }
}
}