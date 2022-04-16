import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainArea extends field_Aggression_LineLength{
    private JLabel MainScore;
    private JButton BowlButton;
    private JLabel Batsman1Score;
    private JLabel Batsman2Score;
    private JLabel Bowler1Stats;
    private JLabel Bowler2Score;
    private JComboBox chooseBowlerCB;
    private JComboBox batsmanAggressionCB;
    private JPanel mainpanel_main;
    private JComboBox chooseBowlerinnings2;
    private String bowler2statSetterString;

    JFrame f;

    public MainArea() {

        comboBoxAddItems();

        f = new JFrame();
        f.setContentPane(mainpanel_main);
        f.setSize(500,700);
        f.setTitle("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(300,0,500,700);
        f.setVisible(true);

        BowlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseBowlerCB.setVisible(userBatting);
                if(userBatting==false){
                    mainpanel_main.remove(chooseBowlerCB);
                }
                chooseBowlerinnings2.setVisible(!userBatting);
                backend2setters(line, length, fieldAggression, battingAggression, bowlerIndex);
//                removeBowlersWhoseOversAreComplete();
//                if (bowler_overs[bowlerIndex] == 4 || alternateBowling() & overs != 0) {
//                    return;
//                } else if (powerplay() & (overs == 0 || over_balls != 0)) {
//                    return;
//                } else if (powerplay() & overs != 0) {
//                    return;
//                }
//                if (over_balls != 5) {
//                    chooseBowlerCB.setVisible(false);
//                } else {
//                    chooseBowlerCB.setVisible(true);
//                }
                setOrderOfEvents();
                settingStats();

            }
        });
        chooseBowlerCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                bowlerIndex = chooseBowlerCB.getSelectedIndex()+startIndexForBowler;
                Bowler1Stats.setText(playerName[bowlerIndex] + " - " + bowler_wickets[bowlerIndex] + "/" +
                        bowler_runs[bowlerIndex] + " (" + bowler_overs[bowlerIndex] + "." + over_balls + ")");
                if(overs>0){
                    Bowler2Score.setText(playerName[whichBowlerBowledWhichOver[overs-1]]
                            + " - " + bowler_wickets[whichBowlerBowledWhichOver[overs-1]] + "/" +
                            bowler_runs[whichBowlerBowledWhichOver[overs-1]] + " (" +
                            bowler_overs[whichBowlerBowledWhichOver[overs-1]]+")");
                }
                else{
                    Bowler2Score.setText("");
                }
            }
        });
        batsmanAggressionCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                battingAggression = batsmanAggressionCB.getSelectedIndex();
            }
        });
        chooseBowlerinnings2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                bowlerIndex = chooseBowlerinnings2.getSelectedIndex()+startIndexForBowler;
                Bowler1Stats.setText(playerName[bowlerIndex] + " - " + bowler_wickets[bowlerIndex] + "/" +
                        bowler_runs[bowlerIndex] + " (" + bowler_overs[bowlerIndex] + "." + over_balls + ")");
                if(overs>0){
                    Bowler2Score.setText(playerName[whichBowlerBowledWhichOver[overs-1]]
                            + " - " + bowler_wickets[whichBowlerBowledWhichOver[overs-1]] + "/" +
                            bowler_runs[whichBowlerBowledWhichOver[overs-1]] + " (" +
                            bowler_overs[whichBowlerBowledWhichOver[overs-1]]+")");
                }
                else{
                    Bowler2Score.setText("");
                }
            }
            
        });
    }

    void comboBoxAddItems(){

        chooseBowlerCB.removeAllItems();
        chooseBowlerCB.addItem(playerName[startIndexForBowler]);
        chooseBowlerCB.addItem(playerName[startIndexForBowler + 1]);
        chooseBowlerCB.addItem(playerName[startIndexForBowler + 2]);
        chooseBowlerCB.addItem(playerName[startIndexForBowler + 3]);
        chooseBowlerCB.addItem(playerName[startIndexForBowler + 4]);
        chooseBowlerCB.addItem(playerName[startIndexForBowler + 5]);
        chooseBowlerCB.addItem(playerName[startIndexForBowler + 6]);
        chooseBowlerCB.addItem(playerName[startIndexForBowler + 7]);
        chooseBowlerCB.addItem(playerName[startIndexForBowler + 8]);
        chooseBowlerCB.addItem(playerName[startIndexForBowler + 9]);
        chooseBowlerCB.addItem(playerName[startIndexForBowler + 10]);

        chooseBowlerinnings2.removeAllItems();
        chooseBowlerinnings2.addItem(playerName[0]);
        chooseBowlerinnings2.addItem(playerName[0 + 1]);
        chooseBowlerinnings2.addItem(playerName[0 + 2]);
        chooseBowlerinnings2.addItem(playerName[0 + 3]);
        chooseBowlerinnings2.addItem(playerName[0 + 4]);
        chooseBowlerinnings2.addItem(playerName[0 + 5]);
        chooseBowlerinnings2.addItem(playerName[0 + 6]);
        chooseBowlerinnings2.addItem(playerName[0 + 7]);
        chooseBowlerinnings2.addItem(playerName[0 + 8]);
        chooseBowlerinnings2.addItem(playerName[0 + 9]);
        chooseBowlerinnings2.addItem(playerName[0 + 10]);

        batsmanAggressionCB.addItem("Very Defensive");
        batsmanAggressionCB.addItem("Defensive");
        batsmanAggressionCB.addItem("Normal");
        batsmanAggressionCB.addItem("Aggressive");
        batsmanAggressionCB.addItem("Very Aggressive");
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

    void settingStats() {
        String targetSt = "";
        if (userBatting == true) {
            targetSt = "";
        } else {
            targetSt = "Target - " + Integer.toString(target);
        }
        MainScore.setText("<html>" + team_runs + "/" + wickets +
                "<br/>" + "Overs - " + overs + "." + over_balls + "<br/>" + targetSt + "</html>");
        Batsman1Score.setText(
                        playerName[batsmanIndexOnStrike] + " - " + batsman_runs[batsmanIndexOnStrike] +
                        "(" + batsman_balls_played[batsmanIndexOnStrike] + ")");
        Batsman2Score.setText(
                        playerName[batsmanIndexOffStrike] + " - " + batsman_runs[batsmanIndexOffStrike] +
                        "(" + batsman_balls_played[batsmanIndexOffStrike] + ")");
        Bowler1Stats.setText(playerName[bowlerIndex] + " - " + bowler_wickets[bowlerIndex] + "/" +
                bowler_runs[bowlerIndex] + " (" + bowler_overs[bowlerIndex] + "." + over_balls + ")");
    }
}
