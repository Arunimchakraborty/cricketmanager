import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class editedUI_2 extends JFrame{
    JFrame f;
    JPanel panelForStats, panelForScore, mainPanel, panelForBowlerChoice, panelForAggressionChoice,
        panelForBowlButton, panelForLineAndLength, chooseBowlerLeftSidePanel;
    Choice chooseBowlerChoice, lineChoice, lengthChoice,
        batsmanAggresionChoice, fieldAggressionChoice;
    JButton bowlButton;
    JLabel batsmanStatsLabel, bowlerStatsLabel,
        ChooseBowlerLabel, batsmanAggressionLabel,
            fieldingAggressionLabel, scoreLabel;

    private void frameSettings(int x, int y, 
        int width, int height){
            setBounds(x, y, width, height);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    private void bowlButtonFunction(String text){
        bowlButton = new JButton(text);
        bowlButton.setBackground(Color.BLACK);
        bowlButton.setForeground(Color.WHITE);
    }

    private void AddLabel(JLabel l, JPanel p, String label){
        l = new JLabel(label);
        l.setForeground(Color.DARK_GRAY);
        l.setFont(new Font("Tahoma", Font.BOLD, 14));
        l.setHorizontalTextPosition(SwingConstants.CENTER);
        p.add(l);
    }

    private void addChoiceItems(Choice c, String item){
        c.add(item);
    }

    private void addChoiceComponentToPanel(Choice c, JPanel p){
        p.add(c);
    }

    editedUI_2(){
        panelForStats = new JPanel();
        panelForScore = new JPanel();
        mainPanel = new JPanel();
        panelForBowlerChoice = new JPanel();
        panelForAggressionChoice = new JPanel();
        panelForBowlButton = new JPanel();
        panelForLineAndLength = new JPanel();
        chooseBowlerLeftSidePanel = new JPanel();

        scoreLabel = new JLabel("Bowl");

        batsmanAggresionChoice = new Choice();
        lineChoice = new Choice();
        lengthChoice = new Choice();
        fieldAggressionChoice = new Choice();
        chooseBowlerChoice = new Choice();

        frameSettings(400, 25, 700, 750);

        addPanel(mainPanel, 30, 30, 650, 750);
        setPanelLayout(mainPanel, null);
        setPanelBorder(mainPanel, "Cricket Manager");

        addPanel(panelForScore, 30, 30, 650, 60*2);
        setPanelLayout(panelForScore, new GridLayout(1,1, 650/8, 7*2));

        addPanel(panelForStats, 30, 30+120, 650, 60*2);
        setPanelLayout(panelForStats, new GridLayout(1,2,20,7*2));

        addPanel(panelForBowlerChoice, 30, 150+120, 650, 80*2);
        setPanelLayout(panelForBowlerChoice, new GridLayout(1,2,20,7*2));

        addPanel(panelForAggressionChoice, 30, 150+120+160, 650, 80*2);
        setPanelLayout(panelForAggressionChoice, new GridLayout(2,2,10,3));

        addPanel(panelForBowlButton, 30, 150+120+160+160+20, 650, 50);
        setPanelLayout(panelForBowlButton, new GridLayout(1,2,20,6*2));

        addPanel(panelForLineAndLength, 30+650/2, 150+120, 650/2, 80*2);
        setPanelLayout(panelForLineAndLength, new GridLayout(4,1,10,7/2));

        addPanel(chooseBowlerLeftSidePanel, 30, 150+120, 650/2, 80*2);
        setPanelLayout(chooseBowlerLeftSidePanel, new GridLayout(2,1,10,7*2));


        bowlButtonFunction("Bowl");


        addChoiceItems(batsmanAggresionChoice, "itemBAgg");
        addChoiceItems(fieldAggressionChoice, "itemFAgg");
        addChoiceItems(chooseBowlerChoice, "itemChooseBowler");
        addChoiceItems(lineChoice, "itemLine");
        addChoiceItems(lengthChoice, "itemLength");

        
        AddLabel(scoreLabel, panelForScore, "Score"); //Adding Score at the first panel

        AddLabel(batsmanStatsLabel, panelForStats, "Batsman Stats");
        AddLabel(bowlerStatsLabel, panelForStats, "Bowler Stats");

        panelForAggressionChoice.add(new JLabel("Batsman Aggression"));
        panelForAggressionChoice.add(new JLabel("Field Aggression"));
        addChoiceComponentToPanel(batsmanAggresionChoice, panelForAggressionChoice);
        addChoiceComponentToPanel(fieldAggressionChoice, panelForAggressionChoice);

        chooseBowlerLeftSidePanel.add(new JLabel("Choose Bowler"));
        addChoiceComponentToPanel(chooseBowlerChoice, chooseBowlerLeftSidePanel);
        panelForLineAndLength.add(new JLabel("Choose Line"));
        addChoiceComponentToPanel(lineChoice, panelForLineAndLength);
        panelForLineAndLength.add(new JLabel("Choose Length"));
        addChoiceComponentToPanel(lengthChoice, panelForLineAndLength);

        panelForBowlButton.add(bowlButton);


        mainPanel.add(panelForScore);
        mainPanel.add(panelForStats);
        mainPanel.add(panelForAggressionChoice);
        mainPanel.add(panelForBowlerChoice);
        mainPanel.add(panelForBowlButton);
        panelForBowlerChoice.add(chooseBowlerLeftSidePanel);
        panelForBowlerChoice.add(panelForLineAndLength);
        
        AddPanelToUI(mainPanel);
        
    }

    public static void main(String[] args) {
        new editedUI_2().setVisible(true);
    }
    
}
