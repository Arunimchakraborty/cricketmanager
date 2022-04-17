import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editedUI_6 extends backend2 {
    JFrame f;
    JPanel panelForStats, panelForScore, mainPanel, panelForBowlerChoice, panelForAggressionChoice,
            panelForBowlButton, panelForLineAndLength, chooseBowlerLeftSidePanel;
    Choice chooseBowlerChoice, lineChoice, lengthChoice,
            batsmanAggresionChoice, fieldAggressionChoice;
    JButton bowlButton;
    JLabel batsmanStatsLabel = new JLabel();
    JLabel bowlerStatsLabel = new JLabel();
    JLabel ChooseBowlerLabel = new JLabel();
    JLabel battingAggressionLabel = new JLabel();
    JLabel fieldingAggressionLabel = new JLabel();
    JLabel scoreLabel = new JLabel();

    ActionListener ALObject;

    field_Aggression_LineLength fObj;


    private void frameSettings(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addPanel(JPanel p, int x, int y, int width, int height) {
        p.setBounds(x, y, width, height);
        p.setForeground(new Color(34, 139, 34));
        p.setBackground(Color.WHITE);
    }

    private void setPanelLayout(JPanel p, LayoutManager mgr) {
        p.setLayout(mgr);
    }

    private void setPanelBorder(JPanel p, String name) {
        p.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), name
                + "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
    }

    private void AddPanelToUI(JPanel p) {
        add(p);
    }

    private void bowlButtonFunction(String text) {
        bowlButton = new JButton(text);
        bowlButton.setBackground(Color.BLACK);
        bowlButton.setForeground(Color.WHITE);
        bowlButton.setFont(new Font("Elephant", Font.BOLD, 18));
    }

    private void AddLabel(JLabel l, JPanel p, String label) {
        l = new JLabel(label);
        l.setForeground(Color.DARK_GRAY);
        l.setFont(new Font("Elephant", Font.BOLD, 14));
        l.setHorizontalTextPosition(SwingConstants.CENTER);
        p.add(l);
    }

    private void addChoiceItems(Choice c, String item) {
        c.add(item);
    }

    private void addChoiceComponentToPanel(Choice c, JPanel p) {
        p.add(c);
    }

    void declaringPanelsTogether() {
        panelForStats = new JPanel();
        panelForScore = new JPanel();
        mainPanel = new JPanel();
        panelForBowlerChoice = new JPanel();
        panelForAggressionChoice = new JPanel();
        panelForBowlButton = new JPanel();
        panelForLineAndLength = new JPanel();
        chooseBowlerLeftSidePanel = new JPanel();
    }

    void declaringlabelsTogether() {
        scoreLabel = new JLabel("Bowl");
        scoreLabel.setFont(new Font("Elephant", Font.BOLD, 18));
        batsmanStatsLabel.setFont(new Font("Elephant", Font.BOLD, 16));
        bowlerStatsLabel.setFont(new Font("Elephant", Font.BOLD, 16));

    }

    void declaringChoicesTogether() {
        batsmanAggresionChoice = new Choice();
        lineChoice = new Choice();
        lengthChoice = new Choice();
        fieldAggressionChoice = new Choice();
        chooseBowlerChoice = new Choice();
    }

    void addingPanelsTogether() {
        addPanel(mainPanel, 30, 30, 650, 750);
        addPanel(panelForScore, 30, 30, 650, 60 * 2);
        addPanel(panelForStats, 30, 30 + 120, 650, 60 * 2);
        addPanel(panelForBowlerChoice, 30, 150 + 120, 650, 80 * 2);
        addPanel(panelForAggressionChoice, 30, 150 + 120 + 160, 650, 80 * 2);
        addPanel(panelForBowlButton, 30, 150 + 120 + 160 + 160 + 20, 650, 50);
        addPanel(panelForLineAndLength, 30 + 650 / 2, 150 + 120, 650 / 2, 80 * 2);
        addPanel(chooseBowlerLeftSidePanel, 30, 150 + 120, 650 / 2, 80 * 2);
    }

    void removeBowlersWhoseOversAreComplete() {
        if (bowler_overs[bowlerIndex] == 4) {
            JOptionPane.showMessageDialog(null,
                    playerName[bowlerIndex] + " has completed all 4 over\nPlease select some other bowler",
                    "Inane error", JOptionPane.ERROR_MESSAGE);
        }
    }

    boolean alternateBowling() {
        if (overs != 0) {
            if (bowlerIndex == whichBowlerBowledWhichOver[overs - 1]) {
                JOptionPane.showMessageDialog(null,
                        playerName[bowlerIndex] + " bowled the last over\nPlease select some other bowler",
                        "Inane error", JOptionPane.ERROR_MESSAGE);
                bowlerIndex=m.findSecondHighest(bowler_points_final);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    boolean powerplay() {
        if (overs != 0) {
            if (overs < 6 & (fieldAggression == 2 || fieldAggression == 1)) {
                JOptionPane.showMessageDialog(null,
                        "Powerplay is in effect\nPlease select some other field",
                        "Inane error", JOptionPane.ERROR_MESSAGE);
                return true;
            } else {
                return false;
            }
        } else if (overs == 0 & over_balls != 0) {
            if (overs < 6 & (fieldAggression == 2 || fieldAggression == 1)) {
                JOptionPane.showMessageDialog(null,
                        "Powerplay is in effect\nPlease select some other field",
                        "Inane error", JOptionPane.ERROR_MESSAGE);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    void removeVisibilityOfChoosingBowlers() {
        if (over_balls != 5) {
            chooseBowlerChoice.setVisible(false);
            ChooseBowlerLabel.setVisible(false);
        } else if (over_balls == 5) {
            chooseBowlerChoice.setVisible(true);
            ChooseBowlerLabel.setVisible(false);
        }
    }

    void settingPanelLayoutTogether() {
        setPanelLayout(mainPanel, null);
        setPanelLayout(panelForScore, new GridLayout(1, 1, 650 / 8, 7 * 2));
        setPanelLayout(panelForStats, new GridLayout(1, 2, 20, 7 * 2));
        setPanelLayout(panelForBowlerChoice, new GridLayout(1, 2, 20, 7 * 2));
        setPanelLayout(panelForAggressionChoice, new GridLayout(2, 2, 10, 3));
        setPanelLayout(panelForBowlButton, new GridLayout(1, 2, 20, 6 * 2));
        setPanelLayout(panelForLineAndLength, new GridLayout(4, 1, 10, 7 / 2));
        setPanelLayout(chooseBowlerLeftSidePanel, new GridLayout(2, 1, 10, 7 * 2));
    }

    void addingChoiceItemTogether() {
        addChoiceItems(batsmanAggresionChoice, "Very Defensive");
        addChoiceItems(batsmanAggresionChoice, "Defensive");
        addChoiceItems(batsmanAggresionChoice, "Normal");
        addChoiceItems(batsmanAggresionChoice, "Aggressive");
        addChoiceItems(batsmanAggresionChoice, "Very Aggressive");
        batsmanAggresionChoice.select(2);

        addChoiceItems(fieldAggressionChoice, "Very Defensive");
        addChoiceItems(fieldAggressionChoice, "Defensive");
        addChoiceItems(fieldAggressionChoice, "Normal");
        addChoiceItems(fieldAggressionChoice, "Aggressive");
        addChoiceItems(fieldAggressionChoice, "Very Aggressive");
        fieldAggressionChoice.select(2);

        chooseBowlerChoice.removeAll();

        if (userBatting == true) {
            addChoiceItems(chooseBowlerChoice, playerName[0 + 11]);
            addChoiceItems(chooseBowlerChoice, playerName[1 + 11]);
            addChoiceItems(chooseBowlerChoice, playerName[2 + 11]);
            addChoiceItems(chooseBowlerChoice, playerName[3 + 11]);
            addChoiceItems(chooseBowlerChoice, playerName[4 + 11]);
            addChoiceItems(chooseBowlerChoice, playerName[5 + 11]);
            addChoiceItems(chooseBowlerChoice, playerName[6 + 11]);
            addChoiceItems(chooseBowlerChoice, playerName[7 + 11]);
            addChoiceItems(chooseBowlerChoice, playerName[8 + 11]);
            addChoiceItems(chooseBowlerChoice, playerName[9 + 11]);
            addChoiceItems(chooseBowlerChoice, playerName[10 + 11]);
            chooseBowlerChoice.select(10);
        } else {
            addChoiceItems(chooseBowlerChoice, playerName[0]);
            addChoiceItems(chooseBowlerChoice, playerName[1]);
            addChoiceItems(chooseBowlerChoice, playerName[2]);
            addChoiceItems(chooseBowlerChoice, playerName[3]);
            addChoiceItems(chooseBowlerChoice, playerName[4]);
            addChoiceItems(chooseBowlerChoice, playerName[5]);
            addChoiceItems(chooseBowlerChoice, playerName[6]);
            addChoiceItems(chooseBowlerChoice, playerName[7]);
            addChoiceItems(chooseBowlerChoice, playerName[8]);
            addChoiceItems(chooseBowlerChoice, playerName[9]);
            addChoiceItems(chooseBowlerChoice, playerName[10]);
            chooseBowlerChoice.select(10);
        }

        addChoiceItems(lineChoice, "wide outside offstump");
        addChoiceItems(lineChoice, "offstump channel");
        addChoiceItems(lineChoice, "offstump");
        addChoiceItems(lineChoice, "middle stump");
        addChoiceItems(lineChoice, "leg stump");
        lineChoice.select(2);

        addChoiceItems(lengthChoice, "yorker");
        addChoiceItems(lengthChoice, "full length");
        addChoiceItems(lengthChoice, "good length");
        addChoiceItems(lengthChoice, "short of good length");
        addChoiceItems(lengthChoice, "bouncer");
        lengthChoice.select(2);
    }

    void scorePartOfUI() {
        // AddLabel(scoreLabel, panelForScore, "<html>" + team_runs + "/" + wickets +
        // "<br/>" + "Overs - " + overs + "." + over_balls + "</html>"); // Adding Score
        // at the first panel
        panelForScore.add(scoreLabel);
    }

    void statsPartOfUI() {
        // AddLabel(batsmanStatsLabel, panelForStats, "Batsman Stats");
        // AddLabel(bowlerStatsLabel, panelForStats, "Bowler Stats");
        panelForStats.add(batsmanStatsLabel);
        panelForStats.add(bowlerStatsLabel);
    }

    void aggressionPartOfUI() {
        panelForAggressionChoice.add(new JLabel("Batsman Aggression"));
        panelForAggressionChoice.add(new JLabel("Field Aggression"));
        addChoiceComponentToPanel(batsmanAggresionChoice, panelForAggressionChoice);
        addChoiceComponentToPanel(fieldAggressionChoice, panelForAggressionChoice);
    }

    void bowlerPartofUI() {
        chooseBowlerLeftSidePanel.add(new JLabel("Choose Bowler"));
        addChoiceComponentToPanel(chooseBowlerChoice, chooseBowlerLeftSidePanel);
        panelForLineAndLength.add(new JLabel("Choose Line"));
        addChoiceComponentToPanel(lineChoice, panelForLineAndLength);
        panelForLineAndLength.add(new JLabel("Choose Length"));
        addChoiceComponentToPanel(lengthChoice, panelForLineAndLength);
    }

    void bowlButtonPartOfUI() {
        panelForBowlButton.add(bowlButton);
    }

    void addingToPanels() {
        mainPanel.add(panelForScore);
        mainPanel.add(panelForStats);
        mainPanel.add(panelForAggressionChoice);
        mainPanel.add(panelForBowlerChoice);
        mainPanel.add(panelForBowlButton);
        panelForBowlerChoice.add(chooseBowlerLeftSidePanel);
        panelForBowlerChoice.add(panelForLineAndLength);
    }

    void settingStats() {
        String targetSt = "";
        if (userBatting == true) {
            targetSt = "";
        } else {
            targetSt = "Target - " + Integer.toString(target);
        }
        scoreLabel.setText("<html>" + team_runs + "/" + wickets +
                "<br/>" + "Overs - " + overs + "." + over_balls + "<br/>" + targetSt + "</html>");
        batsmanStatsLabel.setText(
                "<html>" + playerName[batsmanIndexOnStrike] + " - " + batsman_runs[batsmanIndexOnStrike] +
                        "(" + batsman_balls_played[batsmanIndexOnStrike] + ")" + "<br/>" +
                        playerName[batsmanIndexOffStrike] + " - " + batsman_runs[batsmanIndexOffStrike] +
                        "(" + batsman_balls_played[batsmanIndexOffStrike] + ")" + "</html>");
        bowlerStatsLabel.setText(playerName[bowlerIndex] + " - " + bowler_wickets[bowlerIndex] + "/" +
                bowler_runs[bowlerIndex] + " (" + bowler_overs[bowlerIndex] + "." + over_balls + ")");
    }

    void choiceIfElse() {


        if(userBatting){
            battingAggression = batsmanAggresionChoice.getSelectedIndex()+1;

            fieldAggressionChoice.select(fieldAggression-1);
            //chooseBowlerChoice.select(bowlerIndex-startIndexForBowler);
            lineChoice.select(line-1);
            lengthChoice.select(length-1);
        }
        else{
            fieldAggression = fieldAggressionChoice.getSelectedIndex()+1;
            bowlerIndex = chooseBowlerChoice.getSelectedIndex()+startIndexForBowler;
            line = lineChoice.getSelectedIndex() + 1;
            length = lengthChoice.getSelectedIndex()+1;

            batsmanAggresionChoice.select(battingAggression-1);
        }







    }

    private void addingALtogether() {
        ALObject = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (userBatting == false & var1 == 0) {
                    setVisible(false);
                    new editedUI_5(target);
                }
                if (wickets == 10) {

                    if(whichInnings==1){
                        if(team_runs>target){
                            new endScreen("won");
                        }
                        else if(team_runs==target){
                            new endScreen("drew");
                        }
                        else{
                            new endScreen("lost");
                        }
                    }
                    innings();
                    chooseBowlerChoice.removeAll();
                    choiceAddSecondInnings();
                }

                else if(overs==19 & over_balls==5){
                    if(whichInnings==1){
                        if(team_runs>target){
                            new endScreen("won");
                        }
                        else if(team_runs==target){
                            new endScreen("drew");
                        }
                        else{
                            new endScreen("lost");
                        }
                    }
                    innings();
                    chooseBowlerChoice.removeAll();
                    choiceAddSecondInnings();
                }
                aIAlgorithmBackend();

                fObj.setter(line,length,fieldAggression);
                int a2 = 2+3;
                choiceIfElse();
                backend2setters(line, length, fieldAggression, battingAggression, bowlerIndex);
                removeBowlersWhoseOversAreComplete();
                if(over_balls==6){
                    setPointsAtStart();
                }
                if (bowler_overs[bowlerIndex] == 4 || alternateBowling() & overs != 0) {
                    bowlerIndex=m.findSecondHighest(bowler_points_final);
                    return;
                } else if (powerplay() & (overs == 0 || over_balls != 0)) {
                    return;
                } else if (powerplay() & overs != 0) {
                    return;
                }
                if (over_balls != 5) {
                    chooseBowlerChoice.setVisible(false);
                } else {
                    chooseBowlerChoice.setVisible(true);
                }
                setOrderOfEvents();
                settingStats();
            }
        };
    }

    void addingActionListener() {
        bowlButton.addActionListener(ALObject);
    }


    void choiceAddSecondInnings() {
//        addChoiceItems(chooseBowlerChoice, playerName[0]);
//        addChoiceItems(chooseBowlerChoice, playerName[1]);
//        addChoiceItems(chooseBowlerChoice, playerName[2]);
//        addChoiceItems(chooseBowlerChoice, playerName[3]);
//        addChoiceItems(chooseBowlerChoice, playerName[4]);
//        addChoiceItems(chooseBowlerChoice, playerName[5]);
//        addChoiceItems(chooseBowlerChoice, playerName[6]);
//        addChoiceItems(chooseBowlerChoice, playerName[7]);
//        addChoiceItems(chooseBowlerChoice, playerName[8]);
//        addChoiceItems(chooseBowlerChoice, playerName[9]);
//        addChoiceItems(chooseBowlerChoice, playerName[10]);

        chooseBowlerChoice.add(playerName[0]);
        chooseBowlerChoice.add(playerName[1]);
        chooseBowlerChoice.add(playerName[2]);
        chooseBowlerChoice.add(playerName[3]);
        chooseBowlerChoice.add(playerName[4]);
        chooseBowlerChoice.add(playerName[5]);
        chooseBowlerChoice.add(playerName[6]);
        chooseBowlerChoice.add(playerName[7]);
        chooseBowlerChoice.add(playerName[8]);
        chooseBowlerChoice.add(playerName[9]);
        chooseBowlerChoice.add(playerName[10]);

        chooseBowlerChoice.select(10);
    }



    editedUI_6() {


        declaringPanelsTogether();
        declaringlabelsTogether();
        declaringChoicesTogether();

        frameSettings(400, 25, 700, 750);

        addingPanelsTogether();
        settingPanelLayoutTogether();
        setPanelBorder(mainPanel, "Cricket Manager");

        bowlButtonFunction("Bowl");

        chooseBowlerChoice.removeAll();

        choiceAddSecondInnings();

        addingChoiceItemTogether();

        scorePartOfUI();

        statsPartOfUI();

        aggressionPartOfUI();

        bowlerPartofUI();

        bowlButtonPartOfUI();

        addingToPanels();

        AddPanelToUI(mainPanel);

        fObj = new field_Aggression_LineLength();

        bowlerIndex = 10+startIndexForBowler;

        addingALtogether();

        addingActionListener();



    }

    editedUI_6(int innings) {
        reset();
        this.whichInnings = innings;
        dispose();
        declaringPanelsTogether();
        declaringlabelsTogether();
        declaringChoicesTogether();

        frameSettings(670, 25, 700, 750);

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

        addingALtogether();

        addingActionListener();
    }

    public static void main(String[] args) {
        editedUI_6 ui = new editedUI_6();
        ui.setVisible(true);
    }

}