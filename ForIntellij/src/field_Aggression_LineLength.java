import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



public class field_Aggression_LineLength{
    static JFrame f;
    private JComboBox lineCB;
    private JLabel lineImg;
    private JComboBox lengthCB;
    private JLabel lengthImg;
    private JComboBox fieldAggressionCB;
    private JLabel fieldAggImg;
    private JPanel mainPanel;
    private JLabel Heading;

    int line;
    int length;
    int fieldAggression;

    field_Aggression_LineLength(){
        f = new JFrame();
        f.setContentPane(mainPanel);
        setImages();
        f.setSize(300,500);
        f.setTitle("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        f.revalidate();

    }

    void setter(int line, int length, int fieldAgg){
        this.line = line;
        this.length = length;
        this.fieldAggression = fieldAgg;
        setImages();
    }

    void noConstructorMethod(){
        f = new JFrame();
        f.setContentPane(mainPanel);
        setImages();
        f.setSize(300,500);
        f.setTitle("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }



    void setImages(){

        if(line==1){
            lineImg.setIcon(new ImageIcon("pictures/newPics/resized/wide outside off.png"));
        }
        else if(line==2){
            lineImg.setIcon(new ImageIcon("pictures/newPics/resized/offstump channel.png"));
        }
        else if(line==3){
            lineImg.setIcon(new ImageIcon("pictures/newPics/resized/offstump.png"));
        }
        else if(line==4){
            lineImg.setIcon(new ImageIcon("pictures/newPics/resized/middle stump.png"));
        }
        else if(line==5){
            lineImg.setIcon(new ImageIcon("pictures/newPics/resized/leg stump.png"));
        }

        if(length==1){
            lengthImg.setIcon(new ImageIcon("pictures/newPics/resized/yorker.jpeg"));
        }
        else if(length==2){
            lengthImg.setIcon(new ImageIcon("pictures/newPics/resized/full length.jpeg"));
        }
        else if(length==3){
            lengthImg.setIcon(new ImageIcon("pictures/newPics/resized/good length.jpeg"));
        }
        else if(length==4){
            lengthImg.setIcon(new ImageIcon("pictures/newPics/resized/short of good length.jpeg"));
        }
        else if(length==5){
            lengthImg.setIcon(new ImageIcon("pictures/newPics/resized/bouncer.jpeg"));
        }

        if(fieldAggression==1){
            fieldAggImg.setIcon(new ImageIcon("pictures/newPics/resized/very defensive.jpeg"));
        }
        else if(fieldAggression==2){
            fieldAggImg.setIcon(new ImageIcon("pictures/newPics/resized/defensive.jpeg"));
        }
        else if(fieldAggression==3){
            fieldAggImg.setIcon(new ImageIcon("pictures/newPics/resized/moderate.jpeg"));
        }
        else if(fieldAggression==4){
            fieldAggImg.setIcon(new ImageIcon("pictures/newPics/resized/aggressive.jpeg"));
        }
        else if(fieldAggression==5){
            fieldAggImg.setIcon(new ImageIcon("pictures/newPics/resized/very aggressive.jpeg"));
        }


    }


}
