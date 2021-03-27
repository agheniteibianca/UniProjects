package Presentation;

import Business.MenuItem;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Chef extends JFrame  implements java.io.Serializable{

    JLabel notificationLabel;
    JLabel titleLabel=new JLabel();

    public Chef() {
        prepareGUI();
    }
    private void prepareGUI(){
        this.setTitle("hello!");
        titleLabel.setText("Mod CHEF");
        titleLabel.setBounds(200,10,1000,30);
        this.add(titleLabel);


        notificationLabel = new JLabel();
        notificationLabel.setText("Waiting for order....");
        notificationLabel.setBounds(50,50,1000,20);
        this.add(notificationLabel);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,200);
        getContentPane().setBackground(Color.PINK);

        this.setLayout(null);
        this.setVisible(true);
    }


    //Observable
    public void update(ArrayList<MenuItem> items)
    {
        notificationLabel.setText("New order! The ingredients are: " + items.toString());

        this.repaint();
    }
}
