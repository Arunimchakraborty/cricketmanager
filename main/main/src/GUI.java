import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*
 <applet code="GUI" width=600 height=500>
 </applet>
*/
public class GUI extends Applet implements ItemListener, ActionListener{
    String imdt_outcome;
    Choice field, aggression;
    Button ball, changefield, changeaggressio;
    backend obj = new backend();
    public void init(){
        // setLayout(new GridLayout(2,3));
        field = new Choice();
        field.addItem("Very Aggressive");
        field.addItem("Aggressive");
        field.addItem("Moderate");
        field.addItem("Defensive");
        field.addItem("Very Defensive");
        field.addItemListener(this);
        aggression = new Choice();
        aggression.addItem("Very Aggressive");
        aggression.addItem("Aggressive");
        aggression.addItem("Moderate");
        aggression.addItem("Defensive");
        aggression.addItem("Very Defensive");
        aggression.addItemListener(this);
        Label agglb = new Label("Batsman Aggression");
        Label fieldlb = new Label("Field Aggression");
        ball = new Button("Bowl");
        ball.addActionListener(this);
        add(fieldlb);
        add(field);
        add(agglb);
        add(aggression);
        // Label score = new Label("Score " + obj.game_runs + "." + obj.wickets + " " + "Overs - " + obj.overs);
        // add(score);
        // Label outcomes = new Label("Outcomes " + obj.imdt_outcome + " ");
        // add(outcomes);
        add(ball);
    }

    public void itemStateChanged(ItemEvent ie) {
        if(field.getSelectedItem().equals("Very Aggressive"))
        obj.field_agg = 5;
        else if(field.getSelectedItem().equals("Aggressive"))
        obj.field_agg = 4;
        else if(field.getSelectedItem().equals("Moderate"))
        obj.field_agg = 3;
        else if(field.getSelectedItem().equals("Defensive"))
        obj.field_agg = 2;
        else if(field.getSelectedItem().equals("Very Defensive"))
        obj.field_agg = 1;

        if(aggression.getSelectedItem().equals("Very Aggressive"))
        obj.bat_agg = 5;
        else if(aggression.getSelectedItem().equals("Aggressive"))
        obj.bat_agg = 4;
        else if(aggression.getSelectedItem().equals("Moderate"))
        obj.bat_agg = 3;
        else if(aggression.getSelectedItem().equals("Defensive"))
        obj.bat_agg = 2;
        else if(aggression.getSelectedItem().equals("Very Defensive"))
        obj.bat_agg = 1;

        

        repaint();
    }

    public void actionPerformed(ActionEvent ae) {
            this.obj.outcomeDetermine();

            repaint();
    }

    public void paint(Graphics g){
        g.drawString("Score " + obj.game_runs + "/" + obj.wickets + " " + "Overs - " + obj.overs + "." + obj.game_balls, 50, 200);
        // g.drawString("Outcomes " + obj.imdt_outcome[1] + " " + obj.imdt_outcome[2] + " " + obj.imdt_outcome[3] + " " + obj.imdt_outcome[4] + " " + obj.imdt_outcome[5] + " " + obj.imdt_outcome[6] + " ", 50, 240);
        if(obj.imdt_outcome[1] != null){
            g.drawString("Ball 1 - " + obj.imdt_outcome[1], 50, 220);
        }
        if(obj.imdt_outcome[2] != null){
            g.drawString("Ball 2 - " + obj.imdt_outcome[2], 50, 240);
        }
        if(obj.imdt_outcome[3] != null){
            g.drawString("Ball 3 - " + obj.imdt_outcome[3], 50, 260);
        }
        if(obj.imdt_outcome[4] != null){
            g.drawString("Ball 4 - " + obj.imdt_outcome[4], 50, 280);
        }
        if(obj.imdt_outcome[5] != null){
            g.drawString("Ball 5 - " + obj.imdt_outcome[5], 50, 300);
        }
        if(obj.imdt_outcome[6] != null){
            g.drawString("Ball 6 - " + obj.imdt_outcome[6], 50, 320);
        }
        if(obj.overs == 20 || obj.wickets == 10){
            g.drawString("End of Innings", 150, 250);
        }
    }


    

    
}
