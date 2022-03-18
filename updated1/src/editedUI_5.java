import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editedUI_5 extends backend2 {
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
    backend b;
    ActionListener ALObject;

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
    }

    private void AddLabel(JLabel l, JPanel p, String label) {
        l = new JLabel(label);
        l.setForeground(Color.DARK_GRAY);
        l.setFont(new Font("Tahoma", Font.BOLD, 14));
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
                    "Bowler " + (bowlerIndex + 1) + " has completed all 4 over\nPlease select some other bowler",
                    "Inane error", JOptionPane.ERROR_MESSAGE);
        }
    }

    boolean alternateBowling() {
        if (overs != 0) {
            if (bowlerIndex == whichBowlerBowledWhichOver[overs - 1]) {
                JOptionPane.showMessageDialog(null,
                        "Bowler " + (bowlerIndex + 1) + " bowled the last over\nPlease select some other bowler",
                        "Inane error", JOptionPane.ERROR_MESSAGE);
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

        addChoiceItems(chooseBowlerChoice, "Bowler1");
        addChoiceItems(chooseBowlerChoice, "Bowler2");
        addChoiceItems(chooseBowlerChoice, "Bowler3");
        addChoiceItems(chooseBowlerChoice, "Bowler4");
        addChoiceItems(chooseBowlerChoice, "Bowler5");
        addChoiceItems(chooseBowlerChoice, "Bowler6");
        addChoiceItems(chooseBowlerChoice, "Bowler7");
        addChoiceItems(chooseBowlerChoice, "Bowler8");
        addChoiceItems(chooseBowlerChoice, "Bowler9");
        addChoiceItems(chooseBowlerChoice, "Bowler10");
        addChoiceItems(chooseBowlerChoice, "Bowler11");
        chooseBowlerChoice.select(10);

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
        scoreLabel.setText("<html>" + team_runs + "/" + wickets +
                "<br/>" + "Overs - " + overs + "." + over_balls + "</html>");
        batsmanStatsLabel.setText(
                "<html>" + "Batsman " + (batsmanIndexOnStrike + 1) + " - " + batsman_runs[batsmanIndexOnStrike] +
                        "(" + batsman_balls_played[batsmanIndexOnStrike] + ")" + "<br/>" +
                        "Batsman " + (batsmanIndexOffStrike + 1) + " - " + batsman_runs[batsmanIndexOffStrike] +
                        "(" + batsman_balls_played[batsmanIndexOffStrike] + ")" + "</html>");
        bowlerStatsLabel.setText("Bowler " + (bowlerIndex + 1) + " - " + bowler_wickets[bowlerIndex] + "/" +
                bowler_runs[bowlerIndex] + " (" + bowler_overs[bowlerIndex] + "." + over_balls + ")");
    }

    void choiceIfElse() {

        // Batsman Aggression
        if (batsmanAggresionChoice.getSelectedIndex() == 0) {
            battingAggression = 1;
        } else if (batsmanAggresionChoice.getSelectedIndex() == 1) {
            battingAggression = 2;
        } else if (batsmanAggresionChoice.getSelectedIndex() == 2) {
            battingAggression = 3;
        } else if (batsmanAggresionChoice.getSelectedIndex() == 3) {
            battingAggression = 4;
        } else if (batsmanAggresionChoice.getSelectedIndex() == 4) {
            battingAggression = 5;
        }

        // Field Aggression
        if (fieldAggressionChoice.getSelectedIndex() == 0) {
            fieldAggression = 1;
        } else if (fieldAggressionChoice.getSelectedIndex() == 1) {
            fieldAggression = 2;
        } else if (fieldAggressionChoice.getSelectedIndex() == 2) {
            fieldAggression = 3;
        } else if (fieldAggressionChoice.getSelectedIndex() == 3) {
            fieldAggression = 4;
        } else if (fieldAggressionChoice.getSelectedIndex() == 4) {
            fieldAggression = 5;
        }

        // Selection of Bowler
        if (chooseBowlerChoice.getSelectedIndex() == 0) {
            bowlerIndex = 0;
        } else if (chooseBowlerChoice.getSelectedIndex() == 1) {
            bowlerIndex = 1;
        } else if (chooseBowlerChoice.getSelectedIndex() == 2) {
            bowlerIndex = 2;
        } else if (chooseBowlerChoice.getSelectedIndex() == 3) {
            bowlerIndex = 3;
        } else if (chooseBowlerChoice.getSelectedIndex() == 4) {
            bowlerIndex = 4;
        } else if (chooseBowlerChoice.getSelectedIndex() == 5) {
            bowlerIndex = 5;
        } else if (chooseBowlerChoice.getSelectedIndex() == 6) {
            bowlerIndex = 6;
        } else if (chooseBowlerChoice.getSelectedIndex() == 7) {
            bowlerIndex = 7;
        } else if (chooseBowlerChoice.getSelectedIndex() == 8) {
            bowlerIndex = 8;
        } else if (chooseBowlerChoice.getSelectedIndex() == 9) {
            bowlerIndex = 9;
        } else if (chooseBowlerChoice.getSelectedIndex() == 10) {
            bowlerIndex = 10;
        }

        // Line Choice
        if (lineChoice.getSelectedIndex() == 0) {
            line = 1;
        } else if (lineChoice.getSelectedIndex() == 1) {
            line = 2;
        } else if (lineChoice.getSelectedIndex() == 2) {
            line = 3;
        } else if (lineChoice.getSelectedIndex() == 3) {
            line = 4;
        } else if (lineChoice.getSelectedIndex() == 4) {
            line = 5;
        }

        // Length Choice
        if (lengthChoice.getSelectedIndex() == 0) {
            length = 1;
        } else if (lengthChoice.getSelectedIndex() == 1) {
            length = 2;
        } else if (lengthChoice.getSelectedIndex() == 2) {
            length = 3;
        } else if (lengthChoice.getSelectedIndex() == 3) {
            length = 4;
        } else if (lengthChoice.getSelectedIndex() == 4) {
            length = 5;
        }

    }

    private void addingALtogether() {
        ALObject = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (overs == 20 || wickets == 10) {
                    return;
                }
                choiceIfElse();
                backend2setters(line, length, fieldAggression, battingAggression, bowlerIndex);
                removeBowlersWhoseOversAreComplete();
                if (bowler_overs[bowlerIndex] == 4 || alternateBowling() & overs != 0) {
                    return;
                } else if (powerplay() & (overs == 0 || over_balls != 0)) {
                    return;
                } else if (powerplay() & overs != 0) {
                    return;
                }
                setOrderOfEvents();
                settingStats();
            }
        };
    }

    void addingActionListener() {
        bowlButton.addActionListener(ALObject);
    }

    editedUI_5() {

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

        addingALtogether();

        addingActionListener();

    }

    public static void main(String[] args) {
        new editedUI_5().setVisible(true);
    }

}
