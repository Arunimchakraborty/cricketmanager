import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editedUI_4 extends backend2 {

    // Declaring all important variables to be used in the class
    // These variables are only declared but are initialised later in the class.
    JFrame f;
    JPanel panelForStats, panelForScore, mainPanel, panelForBowlerChoice, panelForAggressionChoice,
            panelForBowlButton, panelForLineAndLength, chooseBowlerLeftSidePanel;
    Choice chooseBowlerChoice, lineChoice, lengthChoice,
            batsmanAggresionChoice, fieldAggressionChoice;
    JButton bowlButton;
    JLabel batsmanStatsLabel = new JLabel();
    JLabel bowlerStatsLabel = new JLabel();
    JLabel ChooseBowlerLabel = new JLabel();
    JLabel batsmanAggressionLabel = new JLabel();
    JLabel fieldingAggressionLabel = new JLabel();
    JLabel scoreLabel = new JLabel();
    ActionListener ALObject;
    int line, length, bowlerIndex, batsmanAggression, fieldAggression;
    // backend2 b = new backend2(line, length, fieldAggression, batsmanAggression,
    // bowlerIndex);

    private void frameSettings(int x, int y, int width, int height) {// setting the frame size
        setBounds(x, y, width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addPanel(JPanel p, int x, int y, int width, int height) {
        // method for adding panels
        // Accepts paremeters like a jpanel and normal x,y,width,height
        p.setBounds(x, y, width, height);
        p.setForeground(new Color(34, 139, 34));
        p.setBackground(Color.WHITE);
    }

    private void setPanelLayout(JPanel p, LayoutManager mgr) {
        // for setting panel layout
        // maybe set to null
        p.setLayout(mgr);
    }

    private void setPanelBorder(JPanel p, String name) {
        // for setting border
        // only to be used for the main panel not other sub panels
        p.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), name
                + "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
    }

    private void AddPanelToUI(JPanel p) {
        // for adding the created panel to the UI
        // kept separate for ease of access
        add(p);
    }

    private void bowlButtonFunction(String text) {
        // method for creating the bowl Jbutton
        // since there is only one button in the UI theres
        // no meaning to keep a complete abstract method for it
        // thus a specific button method for the bowl button
        bowlButton = new JButton(text);
        bowlButton.setBackground(Color.BLACK);
        bowlButton.setForeground(Color.WHITE);
    }

    private void AddLabel(JLabel l, JPanel p, String label) {
        // method for creating a JLabel
        // accepts parameters like a jlabel object, a jpanel object and the string to be
        // displayed
        l = new JLabel(label);
        l.setForeground(Color.DARK_GRAY);
        l.setFont(new Font("Tahoma", Font.BOLD, 14));
        l.setHorizontalTextPosition(SwingConstants.CENTER);
        p.add(l);
    }

    private void addChoiceItems(Choice c, String item) {
        // adding items to a choice list
        // accepts parameters like a choice object, a string item that is to be added
        c.add(item);
    }

    private void addChoiceComponentToPanel(Choice c, JPanel p) {
        // method for adding choice object to the jpanel
        // accepts parameters as a choice object and a jpanel object
        p.add(c);
    }

    void choiceIfElse() {
        // Batsman Aggression
        if (batsmanAggresionChoice.getSelectedItem() == "Very Defensive") {
            batsmanAggression = 1;
        } else if (batsmanAggresionChoice.getSelectedItem() == "Defensive") {
            batsmanAggression = 2;
        } else if (batsmanAggresionChoice.getSelectedItem() == "Normal") {
            batsmanAggression = 3;
        } else if (batsmanAggresionChoice.getSelectedItem() == "Aggressive") {
            batsmanAggression = 4;
        } else if (batsmanAggresionChoice.getSelectedItem() == "Very Aggressive") {
            batsmanAggression = 5;
        }

        // Field Aggression
        if (fieldAggressionChoice.getSelectedItem() == "Very Defensive") {
            fieldAggression = 1;
        } else if (fieldAggressionChoice.getSelectedItem() == "Defensive") {
            fieldAggression = 2;
        } else if (fieldAggressionChoice.getSelectedItem() == "Normal") {
            fieldAggression = 3;
        } else if (fieldAggressionChoice.getSelectedItem() == "Aggressive") {
            fieldAggression = 4;
        } else if (fieldAggressionChoice.getSelectedItem() == "Very Aggressive") {
            fieldAggression = 5;
        }

        // Selection of Bowler
        if (chooseBowlerChoice.getSelectedItem() == "Bowler 1") {
            bowlerIndex = 1;
        } else if (chooseBowlerChoice.getSelectedItem() == "Bowler 2") {
            bowlerIndex = 2;
        } else if (chooseBowlerChoice.getSelectedItem() == "Bowler 3") {
            bowlerIndex = 3;
        } else if (chooseBowlerChoice.getSelectedItem() == "Bowler 4") {
            bowlerIndex = 4;
        } else if (chooseBowlerChoice.getSelectedItem() == "Bowler 5") {
            bowlerIndex = 5;
        } else if (chooseBowlerChoice.getSelectedItem() == "Bowler 6") {
            bowlerIndex = 6;
        } else if (chooseBowlerChoice.getSelectedItem() == "Bowler 7") {
            bowlerIndex = 7;
        } else if (chooseBowlerChoice.getSelectedItem() == "Bowler 8") {
            bowlerIndex = 8;
        } else if (chooseBowlerChoice.getSelectedItem() == "Bowler 9") {
            bowlerIndex = 9;
        } else if (chooseBowlerChoice.getSelectedItem() == "Bowler 10") {
            bowlerIndex = 10;
        } else if (chooseBowlerChoice.getSelectedItem() == "Bowler 11") {
            bowlerIndex = 11;
        }

        // Line Choice
        if (lineChoice.getSelectedItem() == "wide outside offstump") {
            line = 1;
        } else if (lineChoice.getSelectedItem() == "offstump channel") {
            line = 2;
        } else if (lineChoice.getSelectedItem() == "offstump") {
            line = 3;
        } else if (lineChoice.getSelectedItem() == "middle stump") {
            line = 4;
        } else if (lineChoice.getSelectedItem() == "leg stump") {
            line = 5;
        }

        // Length Choice
        if (lengthChoice.getSelectedItem() == "yorker") {
            length = 1;
        } else if (lengthChoice.getSelectedItem() == "full length") {
            length = 2;
        } else if (lengthChoice.getSelectedItem() == "good length") {
            length = 3;
        } else if (lengthChoice.getSelectedItem() == "short of good length") {
            length = 4;
        } else if (lengthChoice.getSelectedItem() == "bouncer") {
            length = 5;
        }
    }

    private void addingALtogether() {
        ALObject = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                choiceIfElse();
                setOrderOfEvents();

                scoreLabel = new JLabel();
                batsmanStatsLabel = new JLabel();
                bowlerStatsLabel = new JLabel();
                scoreLabel.setText("<html>" + team_runs + "/" + wickets +
                        "<br/>" + "Overs - " + overs + "." + over_balls + "</html>");
                batsmanStatsLabel.setText(
                        "<html>" + "Batsman " + batsmanIndexOnStrike + " - " + batsman_runs[batsmanIndexOnStrike] +
                                "(" + batsman_balls_played[batsmanIndexOnStrike] + ")" + "<br/>" +
                                "Batsman " + batsmanIndexOffStrike + " - " + batsman_runs[batsmanIndexOffStrike] +
                                "(" + batsman_balls_played[batsmanIndexOffStrike] + ")" + "</html>");
                bowlerStatsLabel.setText("Bowler " + (11 - bowlerIndex) + " - " + bowler_wickets[bowlerIndex] + "/" +
                        bowler_runs[bowlerIndex] + " (" + bowler_overs[bowlerIndex] + "." + over_balls + ")");
            }
        };
    }

    void declaringPanelsTogether() {
        // a non parameterized method for declaring all panels together
        // only created for grouping and organising similar lines of codes together
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
        // for declaring all labels together
        // only for organising the code better
        scoreLabel = new JLabel("Bowl");
    }

    void declaringChoicesTogether() {
        // for declaring all choices together
        // for organisation purpose
        batsmanAggresionChoice = new Choice();
        lineChoice = new Choice();
        lengthChoice = new Choice();
        fieldAggressionChoice = new Choice();
        chooseBowlerChoice = new Choice();
    }

    void addingPanelsTogether() {
        // adding all panels to UI together
        addPanel(mainPanel, 30, 30, 650, 750);
        addPanel(panelForScore, 30, 30, 650, 60 * 2);
        addPanel(panelForStats, 30, 30 + 120, 650, 60 * 2);
        addPanel(panelForBowlerChoice, 30, 150 + 120, 650, 80 * 2);
        addPanel(panelForAggressionChoice, 30, 150 + 120 + 160, 650, 80 * 2);
        addPanel(panelForBowlButton, 30, 150 + 120 + 160 + 160 + 20, 650, 50);
        addPanel(panelForLineAndLength, 30 + 650 / 2, 150 + 120, 650 / 2, 80 * 2);
        addPanel(chooseBowlerLeftSidePanel, 30, 150 + 120, 650 / 2, 80 * 2);
    }

    void settingPanelLayoutTogether() {
        // setting panel layouts together
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
        // adding all choice items to all choice objects together
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

    void scorePartOfUI() {
        // for designing the score panel of UI
        AddLabel(scoreLabel, panelForScore, ""); // Adding Score at the first panel
        String score = "<html>" + team_runs + "/" + wickets +
                "<br/>" + "Overs - " + overs + "." + over_balls + "</html>";
        scoreLabel.setText(score);
    }

    void statsPartOfUI() {
        // for designing the stats part of UI
        // setBatsmanIndexAtOpeners();//delete this line later its just here for testing
        // purpose
        String batsmanStatsString = "<html>" + "Batsman " + batsmanIndexOnStrike + " - "
                + batsman_runs[batsmanIndexOnStrike] +
                "(" + batsman_balls_played[batsmanIndexOnStrike] + ")" + "<br/>" +
                "Batsman " + batsmanIndexOffStrike + " - " + batsman_runs[batsmanIndexOffStrike] +
                "(" + batsman_balls_played[batsmanIndexOffStrike] + ")" + "</html>";
        AddLabel(batsmanStatsLabel, panelForStats, batsmanStatsString);
        batsmanStatsLabel.setText(batsmanStatsString);

        String BowlerStatsString = "Bowler " + (11 - bowlerIndex) + " - " + bowler_wickets[bowlerIndex] + "/" +
                bowler_runs[bowlerIndex] + " (" + bowler_overs[bowlerIndex] + "." + over_balls + ")";
        AddLabel(bowlerStatsLabel, panelForStats, BowlerStatsString);
        bowlerStatsLabel.setText(BowlerStatsString);
    }

    void aggressionPartOfUI() {
        // for designing the aggressions part of UI
        panelForAggressionChoice.add(new JLabel("Batsman Aggression"));
        panelForAggressionChoice.add(new JLabel("Field Aggression"));
        addChoiceComponentToPanel(batsmanAggresionChoice, panelForAggressionChoice);
        addChoiceComponentToPanel(fieldAggressionChoice, panelForAggressionChoice);
    }

    void bowlerPartofUI() {
        // for designing the bowler Interface part of the UI
        chooseBowlerLeftSidePanel.add(new JLabel("Choose Bowler"));
        addChoiceComponentToPanel(chooseBowlerChoice, chooseBowlerLeftSidePanel);
        panelForLineAndLength.add(new JLabel("Choose Line"));
        addChoiceComponentToPanel(lineChoice, panelForLineAndLength);
        panelForLineAndLength.add(new JLabel("Choose Length"));
        addChoiceComponentToPanel(lengthChoice, panelForLineAndLength);
    }

    void bowlButtonPartOfUI() {
        // for adding the bowl button to the panel for bowl button
        panelForBowlButton.add(bowlButton);
    }

    void addingToPanels() {
        // method for grouping all addition of panels together
        mainPanel.add(panelForScore);
        mainPanel.add(panelForStats);
        mainPanel.add(panelForAggressionChoice);
        mainPanel.add(panelForBowlerChoice);
        mainPanel.add(panelForBowlButton);
        panelForBowlerChoice.add(chooseBowlerLeftSidePanel);
        panelForBowlerChoice.add(panelForLineAndLength);
    }

    void addingActionListener() {
        bowlButton.addActionListener(ALObject);
    }

    editedUI_4() {

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
        new editedUI_4().setVisible(true);
    }

}
