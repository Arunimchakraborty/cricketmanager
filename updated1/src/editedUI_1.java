import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class editedUI_1 extends JFrame{
    JFrame f;
    JPanel p1;
    Choice chooseBowlerChoice, lineAndLengthChoice,
        batsmanAggresionChoice, fieldAggressionChoice;
    JButton bowlButton;
    JLabel batsmanStatsLabel, bowlerStatsLabel,
        ChooseBowlerLabel, batsmanAggressionLabel,
            fieldingAggressionLabel;

    private void frameSettings(int x, int y, 
        int width, int height){
            setBounds(x, y, width, height);
    }

    private void addPanel(JPanel p, int x, int y, 
        int width, int height){
            p.setBounds(x, y, width, height);
            p.setForeground(new Color(34, 139, 34));
            p.setBackground(Color.WHITE);
    }

    private void setPanelLayout(JPanel p, LayoutManager mgr){
        p.setLayout(mgr);
    }

    private void setPanelBorder(JPanel p, String name){
        p.setBorder(new TitledBorder(new LineBorder(
            new Color(173, 216, 230), 2), name
                + "", TitledBorder.LEADING, TitledBorder.TOP, null, 
                    new Color(173, 216, 230)));
    }

    private void AddPanelToUI(JPanel p){
        add(p);
    }

    private void bowlButtonFunction(int x, int y, int width, 
        int height, String text){
        bowlButton = new JButton(text);
        bowlButton.setBackground(Color.BLACK);
        bowlButton.setForeground(Color.WHITE);
        bowlButton.setBounds(x,y,width,height);
        p1.add(bowlButton);
    }

    private void AddLabel(JLabel l, JPanel p, String label, 
        int x, int y, int width, int height){
        l = new JLabel(label);
        l.setForeground(Color.DARK_GRAY);
        l.setFont(new Font("Tahoma", Font.BOLD, 14));
        l.setBounds(x, y, width, height);
        p.add(l);
    }

    private void setChoiceComponent(Choice c, int x,
        int y, int width, int height){
            c.setBounds(x, y, width, height);
        }

    private void addChoiceItems(Choice c, String item){
        c.add(item);
    }

    private void addChoiceComponentToPanel(Choice c, JPanel p){
        p.add(c);
    }

    editedUI_1(){
        p1 = new JPanel();
        batsmanAggresionChoice = new Choice();
        lineAndLengthChoice = new Choice();
        fieldAggressionChoice = new Choice();
        chooseBowlerChoice = new Choice();
        frameSettings(400, 25, 700, 750);
        addPanel(p1, 30, 30, 650, 750);
        setPanelLayout(p1, null);
        setPanelBorder(p1, "Cricket Manager");
        AddPanelToUI(p1);
        bowlButtonFunction(350, 340, 120, 30, "Bowl");
        AddLabel(batsmanStatsLabel, p1, "Batsman Stats", 
            10, 100, 150,150);
        AddLabel(bowlerStatsLabel, p1, "Bowler Stats", 
            450 , 100, 150,150);
        AddLabel(ChooseBowlerLabel, p1, "Choose Bowler", 
            150 , 10, 120,100);
        AddLabel(batsmanAggressionLabel, p1, "Batsman Aggression", 
            10,500,150,100);
        AddLabel(fieldingAggressionLabel, p1, "Fielding Aggression", 
            450,500, 150,100);
        setChoiceComponent(chooseBowlerChoice, 300, 50 ,150, 100);
        setChoiceComponent(lineAndLengthChoice, 150, 350, 110,100);
        setChoiceComponent(batsmanAggresionChoice, 20,600 ,110, 100);
        setChoiceComponent(fieldAggressionChoice, 460,600, 110,100);

        addChoiceItems(chooseBowlerChoice, "Bowler 1");
        addChoiceItems(chooseBowlerChoice, "Bowler 2");
        addChoiceItems(lineAndLengthChoice, "line");
        addChoiceItems(lineAndLengthChoice, "length");
        addChoiceItems(batsmanAggresionChoice, "Option 1");
        addChoiceItems(batsmanAggresionChoice, "Option 2");
        addChoiceItems(fieldAggressionChoice, "Option 1");
        addChoiceItems(fieldAggressionChoice, "Option 2");

        addChoiceComponentToPanel(chooseBowlerChoice, p1);
        addChoiceComponentToPanel(lineAndLengthChoice, p1);
        addChoiceComponentToPanel(batsmanAggresionChoice, p1);
        addChoiceComponentToPanel(fieldAggressionChoice, p1);
    }

    public static void main(String[] args) {
        new editedUI_1().setVisible(true);
    }
    
}
