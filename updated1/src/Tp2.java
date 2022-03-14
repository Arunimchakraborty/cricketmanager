import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Tp2 extends JFrame {
    JFrame f;
    JPanel p1;
    Choice c1,c2,c3,c4;
    JButton b1;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2;
    Tp2(){ 
        
        setBounds(400, 25, 700, 750);
        
        p1 = new JPanel();
        
        p1.setBounds(30, 30, 650, 300);
        
        p1.setLayout( null);
        p1.setBackground(Color.WHITE);
        p1.setForeground(new Color(34, 139, 34));
        p1.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Enter some game title here"
        		+ "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        add(p1);
        
        b1 = new JButton("Bowl");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(350, 340, 120, 30);
        p1.add(b1);
        
        JLabel l1 = new JLabel("Batsman Stats");
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Tahoma", Font.BOLD, 14));
        l1.setBounds(10, 100, 150,150);
        p1.add(l1);
        
        JLabel l2 = new JLabel("Bowler Stats");
        l2.setForeground(Color.DARK_GRAY);
        l2.setFont(new Font("Tahoma", Font.BOLD, 14));
        l2.setBounds(450 , 100, 150,150);
        p1.add(l2);
        
        JLabel l3 = new JLabel("Choose Bowler");
        l3.setForeground(Color.DARK_GRAY);
        l3.setFont(new Font("Tahoma", Font.BOLD, 14));
        l3.setBounds(150 , 10, 120,100);
        p1.add(l3);

        JLabel l4 = new JLabel("Batsman Aggression");
        l4.setForeground(Color.DARK_GRAY);
        l4.setFont(new Font("Tahoma", Font.BOLD, 14));
        l4.setBounds(10,500,150,100);
        p1.add(l4);

        JLabel l5 = new JLabel("Fielding Aggresion");
        l5.setForeground(Color.DARK_GRAY);
        l5.setFont(new Font("Tahoma", Font.BOLD, 14));
        l5.setBounds(450,500, 150,100);
        p1.add(l5);

        c1 = new Choice();
        c1.add("Bowler1");
        c1.add("Bowler2");
        c1.setBounds(300, 50 ,150, 100);
        p1.add(c1);

        c2 = new Choice();
        c2.add("line");
        c2.add("length");
        c2.setBounds(150, 350, 110,100);
        p1.add(c2);

        c3 = new Choice();
        c3.add("Option1");
        c3.add("option2");
        c3.setBounds(20,600 ,110, 100);
        p1.add(c3);

        c4 = new Choice();
        c4.add("Option1");
        c4.add("Option2");
        c4.setBounds(460,600, 110,100);
        p1.add(c4);

        
        
        
        
        
       
        
        
    }
    
   
    public static void main(String[] args){
        new Tp2().setVisible(true);
    }
}