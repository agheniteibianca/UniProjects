package Presentation.Waiter;

import Business.MenuItem;
import Data.FileWriterClass;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import javax.swing.*;

public class View_Waiter extends JFrame {
    Model_Waiter model;
    JPanel panel;
    SpringLayout layout;
    JTable tabel;
    MenuItem[][] data;

    JTable tabel2;
    MenuItem[][] orderData;
    JButton orderBtn = new JButton("Place order ");
    JCheckBox c1 = new JCheckBox("Generate bill");
    JLabel titleLabel=new JLabel();
    JLabel descriptionLabel=new JLabel();

    public View_Waiter(Model_Waiter m) {
        this.model=m;
        prepareGUI();
    }



    private void prepareGUI(){
        this.setTitle("hello!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);

        panel=new JPanel();

        displayBasic();
        displayTable();
        displayOrderTable();
        this.setVisible(true);

    }

    public void displayBasic() {
        panel.setBackground(new Color(186,225,255));
        layout = new SpringLayout();
        panel.setLayout(layout);
        panel.add(orderBtn);
        panel.add(c1);

        descriptionLabel.setText("Select items from the menu and press the button to compute order. Check the box to generate bill!");
        int xdescrier=10;
        int ydescrier=50;
        layout.putConstraint(SpringLayout.WEST, descriptionLabel,xdescrier, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, descriptionLabel,ydescrier, SpringLayout.NORTH, panel);
        panel.add(descriptionLabel);


        titleLabel.setText("Mod WAITER");
        int xtitlu=260;
        int ytitlu=15;
        layout.putConstraint(SpringLayout.WEST, titleLabel,xtitlu, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, titleLabel,ytitlu, SpringLayout.NORTH, panel);
        panel.add(titleLabel);

        int x=150;
        int y=280;
        layout.putConstraint(SpringLayout.WEST, orderBtn,x, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, orderBtn,y, SpringLayout.NORTH, panel);


        int xdescriere=300;
        int ydescriere=280;
        layout.putConstraint(SpringLayout.WEST, c1,xdescriere, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, c1,ydescriere, SpringLayout.NORTH, panel);


        this.add(panel);
        this.setVisible(true);
    }


    public void displayTable(){
        data =new MenuItem[100][1];
        String[] columnNames = { "MenuItem"};

        //compute data to add
        int i=0;
        for(MenuItem e: model.restaurant.menu){
            data[i][0]=model.restaurant.menu.get(i);
            i++;
        }
        tabel = new JTable(data, columnNames);
        JScrollPane sp = new JScrollPane(tabel);
        panel.add(sp);

        int xtabel=80;
        int ytabel=100;
        layout.putConstraint(SpringLayout.WEST, sp,xtabel, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sp,ytabel, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, sp,-320, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, sp,-100, SpringLayout.SOUTH, panel);
    }
    public void updateTable() {
        for(int i=0;i<100;i++){
            data[i][0]=null;
        }
        int i=0;
        for(MenuItem e: model.restaurant.menu){
            data[i][0]=model.restaurant.menu.get(i);
            i++;
        }
        tabel.repaint();
    }



    public void displayOrderTable(){

        orderData=new MenuItem[100][1];
        String[] columnNames2 = {"Order"};

        //compute data to add
        int i=0;
        for(MenuItem e: model.orderItems){
            orderData[i][0]=model.orderItems.get(i);
            i++;
        }
        tabel2 = new JTable(orderData, columnNames2);
        JScrollPane sp2 = new JScrollPane(tabel2);
        panel.add(sp2);

        int xtabel2=330;
        int ytabel2=100;
        layout.putConstraint(SpringLayout.WEST, sp2,xtabel2, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sp2,ytabel2, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, sp2,-80, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, sp2,-100, SpringLayout.SOUTH, panel);
    }
    public void refreshOrderData() {

        for(int i=0;i<100;i++){
            orderData[i][0]=null;
        }
        int i=0;
        for(MenuItem e: model.orderItems){
            orderData[i][0]=model.orderItems.get(i);
            i++;
        }
        tabel2.repaint();
    }


    public void addTabelListener(MouseAdapter mal) {
        tabel.addMouseListener(mal);
    }
    public void addOrderListener(ActionListener mal) {
        orderBtn.addActionListener(mal);
    }
    public void addCheckListener(ItemListener mal) {
        c1.addItemListener(mal);
    }








}
