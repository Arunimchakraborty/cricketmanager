import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class editedUI_3 extends backend{
    JFrame f;
    JPanel panelForStats, panelForScore, mainPanel, panelForBowlerChoice, panelForAggressionChoice,
        panelForBowlButton, panelForLineAndLength, chooseBowlerLeftSidePanel;
    Choice chooseBowlerChoice, lineChoice, lengthChoice,
        batsmanAggresionChoice, fieldAggressionChoice;
    JButton bowlButton;
    JLabel batsmanStatsLabel, bowlerStatsLabel,
        ChooseBowlerLabel, batsmanAggressionLabel,
            fieldingAggressionLabel, scoreLabel;
    backend b;

    private void frameSettings(int x, int y, int width, int height){
            setBounds(x, y, width, height);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addPanel(JPanel p, int x, int y, int width, int height){
            p.setBounds(x, y, width, height);
            p.setForeground(new Color(34, 139, 34));
            p.setBackground(Color.WHITE);
    }

    private void setPanelLayout(JPanel p, LayoutManager mgr){
        p.setLayout(mgr);
    }

    private void setPanelBorder(JPanel p, String name){
        p.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), name
                + "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
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

    void declaringPanelsTogether(){
        panelForStats = new JPanel();
        panelForScore = new JPanel();
        mainPanel = new JPanel();
        panelForBowlerChoice = new JPanel();
        panelForAggressionChoice = new JPanel();
        panelForBowlButton = new JPanel();
        panelForLineAndLength = new JPanel();
        chooseBowlerLeftSidePanel = new JPanel();
    }

    void declaringlabelsTogether(){
        scoreLabel = new JLabel("Bowl");
    }

    void declaringChoicesTogether(){
        batsmanAggresionChoice = new Choice();
        lineChoice = new Choice();
        lengthChoice = new Choice();
        fieldAggressionChoice = new Choice();
        chooseBowlerChoice = new Choice();
    }

    void addingPanelsTogether(){
        addPanel(mainPanel, 30, 30, 650, 750);
        addPanel(panelForScore, 30, 30, 650, 60*2);
        addPanel(panelForStats, 30, 30+120, 650, 60*2);
        addPanel(panelForBowlerChoice, 30, 150+120, 650, 80*2);
        addPanel(panelForAggressionChoice, 30, 150+120+160, 650, 80*2);
        addPanel(panelForBowlButton, 30, 150+120+160+160+20, 650, 50);
        addPanel(panelForLineAndLength, 30+650/2, 150+120, 650/2, 80*2);
        addPanel(chooseBowlerLeftSidePanel, 30, 150+120, 650/2, 80*2);
    }

    void settingPanelLayoutTogether(){
        setPanelLayout(mainPanel, null);
        setPanelLayout(panelForScore, new GridLayout(1,1, 650/8, 7*2));
        setPanelLayout(panelForStats, new GridLayout(1,2,20,7*2));
        setPanelLayout(panelForBowlerChoice, new GridLayout(1,2,20,7*2));
        setPanelLayout(panelForAggressionChoice, new GridLayout(2,2,10,3));
        setPanelLayout(panelForBowlButton, new GridLayout(1,2,20,6*2));
        setPanelLayout(panelForLineAndLength, new GridLayout(4,1,10,7/2));
        setPanelLayout(chooseBowlerLeftSidePanel, new GridLayout(2,1,10,7*2));
    }

    void addingChoiceItemTogether(){
        addChoiceItems(batsmanAggresionChoice, "Very Defensive");
        addChoiceItems(batsmanAggresionChoice, "Defensive");
        addChoiceItems(batsmanAggresionChoice, "Normal");
        addChoiceItems(batsmanAggresionChoice, "Aggressive");
        addChoiceItems(batsmanAggresionChoice, "Very Aggressive");

        addChoiceItems(fieldAggressionChoice, "Very Defensive");
        addChoiceItems(fieldAggressionChoice, "Defensive");
        addChoiceItems(fieldAggressionChoice, "Normal");
        addChoiceItems(fieldAggressionChoice, "Aggressive");
        addChoiceItems(fieldAggressionChoice, "Very Aggressive");

        addChoiceItems(chooseBowlerChoice, "Bowler1");
        addChoiceItems(chooseBowlerChoice, "Bowler2");
        addChoiceItems(chooseBowlerChoice, "Bowler3");
        addChoiceItems(chooseBowlerChoice, "Bowler4");
        addChoiceItems(chooseBowlerChoice, "Bowler5");

        addChoiceItems(lineChoice, "wide outside offstump");
        addChoiceItems(lineChoice, "offstump channel");
        addChoiceItems(lineChoice, "offstump");
        addChoiceItems(lineChoice, "middle stump");
        addChoiceItems(lineChoice, "leg stump");
        
        addChoiceItems(lengthChoice, "yorker");
        addChoiceItems(lengthChoice, "full length");
        addChoiceItems(lengthChoice, "good length");
        addChoiceItems(lengthChoice, "short of good length");
        addChoiceItems(lengthChoice, "bouncer");
    }

    void scorePartOfUI(){
        AddLabel(scoreLabel, panelForScore, "<html>"+team_runs+"/"+wickets+
            "<br/>"+"Overs - "+overs+"."+over_balls+"</html>"); //Adding Score at the first panel
    }

    void statsPartOfUI(){
        AddLabel(batsmanStatsLabel, panelForStats, "Batsman Stats");
        AddLabel(bowlerStatsLabel, panelForStats, "Bowler Stats");
    }

    void aggressionPartOfUI(){
        panelForAggressionChoice.add(new JLabel("Batsman Aggression"));
        panelForAggressionChoice.add(new JLabel("Field Aggression"));
        addChoiceComponentToPanel(batsmanAggresionChoice, panelForAggressionChoice);
        addChoiceComponentToPanel(fieldAggressionChoice, panelForAggressionChoice);
    }

    void bowlerPartofUI(){
        chooseBowlerLeftSidePanel.add(new JLabel("Choose Bowler"));
        addChoiceComponentToPanel(chooseBowlerChoice, chooseBowlerLeftSidePanel);
        panelForLineAndLength.add(new JLabel("Choose Line"));
        addChoiceComponentToPanel(lineChoice, panelForLineAndLength);
        panelForLineAndLength.add(new JLabel("Choose Length"));
        addChoiceComponentToPanel(lengthChoice, panelForLineAndLength);
    }

    void bowlButtonPartOfUI(){
        panelForBowlButton.add(bowlButton);
    }

    void addingToPanels(){
        mainPanel.add(panelForScore);
        mainPanel.add(panelForStats);
        mainPanel.add(panelForAggressionChoice);
        mainPanel.add(panelForBowlerChoice);
        mainPanel.add(panelForBowlButton);
        panelForBowlerChoice.add(chooseBowlerLeftSidePanel);
        panelForBowlerChoice.add(panelForLineAndLength);
    }



    editedUI_3(){

        declaringPanelsTogether();
        declaringlabelsTogether();
        declaringChoicesTogether();

        frameSettings(400, 25, 700, 750);

        addingPanelsTogether();
        settingPanelLayoutTogether();
        setPanelBorder(mainPanel, "Cricket Manager");

        bowlButtonFunction("Bowl");


        addingChoiceItemTogether();
        

        scorePartOfUI();
        
        statsPartOfUI();

        aggressionPartOfUI();

        bowlerPartofUI();

        bowlButtonPartOfUI();


        addingToPanels();
        
        AddPanelToUI(mainPanel);
        
    }

    public static void main(String[] args) {
        new editedUI_3().setVisible(true);
    }
    
}
