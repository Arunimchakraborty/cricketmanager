import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class field_Aggression_LineLength extends backend2{
    static JFrame f;
    private JComboBox lineCB;
    private JLabel lineImg;
    private JComboBox lengthCB;
    private JLabel lengthImg;
    private JComboBox fieldAggressionCB;
    private JLabel fieldAggImg;
    private JPanel mainPanel;
    private JLabel Heading;

    field_Aggression_LineLength(){
        f = new JFrame();
        f.setContentPane(mainPanel);
        addElementsInChoices();
        setImages();
        f.setSize(300,500);
        f.setTitle("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    void noConstructorMethod(){
        f = new JFrame();
        f.setContentPane(mainPanel);
        addElementsInChoices();
        setImages();
        f.setSize(300,500);
        f.setTitle("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    void addElementsInChoices(){
        String lines[] = {
                "Wide Outside OffStump",
                "OffStump Channel",
                "OffStump",
                "Middle Stump",
                "Leg Stump"
        };
        String lengths[] = {
                "Yorker",
                "Full Length",
                "Good Length",
                "Short of Good Length",
                "Bouncer"
        };
        String fieldAggressions[] = {
                "Very Defensive",
                "Defensive",
                "Normal",
                "Aggressive",
                "Very Aggressive"
        };
//        lineCB = new JComboBox(lines);
//        lengthCB = new JComboBox(lengths);
//        fieldAggressionCB = new JComboBox(fieldAggressions);

        for (int i = 0; i < 5; i++) {
            lineCB.addItem(lines[i]);
            lengthCB.addItem(lengths[i]);
            fieldAggressionCB.addItem(fieldAggressions[i]);
        }

//        lineCB.addItem(lines);
//        lengthCB.addItem(lengths);
//        fieldAggressionCB.addItem(fieldAggressions);

    }

    void setImages(){

        lineImg.setIcon(new ImageIcon("pictures/pictures_resized/offstump.png"));
        lengthImg.setIcon(new ImageIcon("pictures/pictures_resized/yorker.png"));
        fieldAggImg.setIcon(new ImageIcon("pictures/pictures_resized/base pitch main.png"));

    }


}
