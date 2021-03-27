package View;

import Model.MVC_Model;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class MVC_View extends JFrame {


    private JFrame mainframe;
    JButton addBtn = new JButton("Addition");
    JButton subBtn = new JButton("Substraction");
    JButton mulBtn = new JButton("Multiplication");
    JButton divBtn = new JButton("Division");
    JButton derBtn = new JButton("Derivation");
    JButton intBtn = new JButton("Integration");

    JButton rez1Btn = new JButton("Add");
    JButton rez2Btn = new JButton("Substract");
    JButton rez3Btn = new JButton("Derivate");
    JButton rez4Btn = new JButton("Integrate");
    JButton rez5Btn = new JButton("Multiply");
    JButton rez6Btn = new JButton("Divide");

    JTextField input1Fld = new JTextField(20);
    JTextField input2Fld = new JTextField(20);
    JTextField rezFld = new JTextField(20);
    JTextField restFld = new JTextField(20);

    JLabel input1Lbl = new JLabel("Input1: ");
    JLabel input2Lbl = new JLabel("Input2: ");
    JLabel rezLbl = new JLabel("Result: ");
    JLabel restLbl = new JLabel("Rest: ");


    JLabel titlu1 = new JLabel("Calculatorul de polinoame al Biancai!");
    JLabel titlu2 = new JLabel("Alege o operatie :)");


    JPanel dreapta;
    JPanel stanga;


    public MVC_View(MVC_Model m) {
        prepareGUI();
    }

    private void prepareGUI(){


        this.setTitle("hello!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);


        this.setLayout(new GridLayout(1, 2));
        dreapta = new JPanel();
        dreapta.setLayout(new GridLayout(1, 1));
        stanga = new JPanel();
        stanga.setLayout(new GridLayout(1, 1)); //nu mergea cand nu scriam asta!
        this.add(stanga);
        this.add(dreapta);

        DisplayStd();
        this.setVisible(true);

    }


    public void DisplayStd(){  //afisam butoanele care sunt afisate in orice caz

        addBtn.setBackground(new Color(255,0,0));
        addBtn.setPreferredSize(new Dimension(150, 30));
        subBtn.setBackground(new Color(255,100,0));
        subBtn.setPreferredSize(new Dimension(150, 30));
        mulBtn.setBackground(new Color(255,165,0));
        mulBtn.setPreferredSize(new Dimension(150, 30));
        divBtn.setBackground(new Color(0,100,0));
        divBtn.setPreferredSize(new Dimension(150, 30));
        derBtn.setBackground(new Color(0,128,128));
        derBtn.setPreferredSize(new Dimension(150, 30));
        intBtn.setBackground(new Color(199,21,133));
        intBtn.setPreferredSize(new Dimension(150, 30));

        dreapta.setBackground(new Color(186,225,255));
        stanga.setBackground(new Color(186,225,255));


        JPanel menu =new JPanel();
        menu.setBackground(new Color(186,225,255));
        SpringLayout layout = new SpringLayout();
        menu.setLayout(layout);

        menu.add(titlu1);
        titlu1.setSize(30,30);
        int x0=40;
        int y0=25;
        layout.putConstraint(SpringLayout.WEST, titlu1,x0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, titlu1,y0, SpringLayout.NORTH, this);

        menu.add(titlu2);
        int x00=70;
        int y00=60;
        layout.putConstraint(SpringLayout.WEST, titlu2,x00, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, titlu2,y00, SpringLayout.NORTH, this);


        menu.add(addBtn);
        int x1=60;
        int y1=100;
        layout.putConstraint(SpringLayout.WEST, addBtn,x1, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, addBtn,y1, SpringLayout.NORTH, this);

        menu.add(subBtn);
        int x2=60;
        int y2=140;
        layout.putConstraint(SpringLayout.WEST, subBtn,x2, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, subBtn,y2, SpringLayout.NORTH, this);


        menu.add(mulBtn);
        int x3=60;
        int y3=180;
        layout.putConstraint(SpringLayout.WEST, mulBtn,x3, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, mulBtn,y3, SpringLayout.NORTH, this);

        menu.add(divBtn);
        int x4=60;
        int y4=220;
        layout.putConstraint(SpringLayout.WEST, divBtn,x4, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, divBtn,y4, SpringLayout.NORTH, this);

        menu.add(derBtn);
        int x5=60;
        int y5=260;
        layout.putConstraint(SpringLayout.WEST, derBtn,x5, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, derBtn,y5, SpringLayout.NORTH, this);

        menu.add(intBtn);
        int x6=60;
        int y6=300;
        layout.putConstraint(SpringLayout.WEST, intBtn,x6, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, intBtn,y6, SpringLayout.NORTH, this);


        stanga.add(menu);
        this.setVisible(true);

    }

    public void DisplayAdd() {

        dreapta.removeAll(); //golesc panelul din dreapta ca sa nu adaug addPaneluri la el in continuu
        stanga.removeAll();
        DisplayStd();

        JPanel panel=new JPanel();
        panel.setBackground(new Color(186,225,255));
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        addBtn.setBackground(new Color(255, 255, 255));

        panel.add(input1Lbl);
        panel.add(input1Fld);
        panel.add(input2Lbl);
        panel.add(input2Fld);
        panel.add(rezLbl);
        panel.add(rezFld);
        panel.add(rez1Btn);

        int x1=60;
        int y1=100;
        layout.putConstraint(SpringLayout.EAST, input1Lbl,-5, SpringLayout.WEST, input1Fld);
        layout.putConstraint(SpringLayout.WEST, input1Fld,x1, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Fld,y1, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Lbl,y1, SpringLayout.NORTH, dreapta);
        int x2=60;
        int y2=140;
        layout.putConstraint(SpringLayout.EAST, input2Lbl,-5, SpringLayout.WEST, input2Fld);
        layout.putConstraint(SpringLayout.WEST, input2Fld,x2, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input2Fld,y2, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input2Lbl,y2, SpringLayout.NORTH, dreapta);
        int x3=60;
        int y3=180;
        layout.putConstraint(SpringLayout.EAST, rezLbl,-5, SpringLayout.WEST, rezFld);
        layout.putConstraint(SpringLayout.WEST, rezFld,x3, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezFld,y3, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezLbl,y3, SpringLayout.NORTH, dreapta);

        int x4=100;
        int y4=300;
        layout.putConstraint(SpringLayout.WEST, rez1Btn,x4, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rez1Btn,y4, SpringLayout.NORTH, dreapta);


        dreapta.add(panel);
        this.setVisible(true);

    }


    public void DisplaySub() {

        dreapta.removeAll(); //golesc panelul din dreapta ca sa nu adaug addPaneluri la el in continuu
        stanga.removeAll();
        DisplayStd();


        JPanel subPanel=new JPanel();
        subPanel.setBackground(new Color(186,225,255));
        SpringLayout layout = new SpringLayout();
        subPanel.setLayout(layout);
        subBtn.setBackground(new Color(255, 255, 255));
        subPanel.add(input1Lbl);
        subPanel.add(input1Fld);
        subPanel.add(input2Lbl);
        subPanel.add(input2Fld);
        subPanel.add(rezLbl);
        subPanel.add(rezFld);
        subPanel.add(rez2Btn);

        int x1=60;
        int y1=100;
        layout.putConstraint(SpringLayout.EAST, input1Lbl,-5, SpringLayout.WEST, input1Fld);
        layout.putConstraint(SpringLayout.WEST, input1Fld,x1, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Fld,y1, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Lbl,y1, SpringLayout.NORTH, dreapta);
        int x2=60;
        int y2=140;
        layout.putConstraint(SpringLayout.EAST, input2Lbl,-5, SpringLayout.WEST, input2Fld);
        layout.putConstraint(SpringLayout.WEST, input2Fld,x2, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input2Fld,y2, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input2Lbl,y2, SpringLayout.NORTH, dreapta);
        int x3=60;
        int y3=180;
        layout.putConstraint(SpringLayout.EAST, rezLbl,-5, SpringLayout.WEST, rezFld);
        layout.putConstraint(SpringLayout.WEST, rezFld,x3, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezFld,y3, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezLbl,y3, SpringLayout.NORTH, dreapta);

        int x4=100;
        int y4=300;
        layout.putConstraint(SpringLayout.WEST, rez2Btn,x4, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rez2Btn,y4, SpringLayout.NORTH, dreapta);


        dreapta.add(subPanel);
        this.setVisible(true);

    }


    public void DisplayDer() {

        dreapta.removeAll(); //golesc panelul din dreapta ca sa nu adaug addPaneluri la el in continuu
        stanga.removeAll();
        DisplayStd();

        JPanel panel=new JPanel();
        panel.setBackground(new Color(186,225,255));
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        derBtn.setBackground(new Color(255, 255, 255));

        panel.add(input1Lbl);
        panel.add(input1Fld);

        panel.add(rezLbl);
        panel.add(rezFld);

        panel.add(rez3Btn);

        int x1=60;
        int y1=100;
        layout.putConstraint(SpringLayout.EAST, input1Lbl,-5, SpringLayout.WEST, input1Fld);
        layout.putConstraint(SpringLayout.WEST, input1Fld,x1, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Fld,y1, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Lbl,y1, SpringLayout.NORTH, dreapta);


        int x3=60;
        int y3=180;
        layout.putConstraint(SpringLayout.EAST, rezLbl,-5, SpringLayout.WEST, rezFld);
        layout.putConstraint(SpringLayout.WEST, rezFld,x3, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezFld,y3, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezLbl,y3, SpringLayout.NORTH, dreapta);

        int x4=100;
        int y4=300;
        layout.putConstraint(SpringLayout.WEST, rez3Btn,x4, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rez3Btn,y4, SpringLayout.NORTH, dreapta);

        dreapta.add(panel);
        this.setVisible(true);

    }


    public void DisplayInt() {

        dreapta.removeAll(); //golesc panelul din dreapta ca sa nu adaug addPaneluri la el in continuu
        stanga.removeAll();
        DisplayStd();

        JPanel panel=new JPanel();
        panel.setBackground(new Color(186,225,255));
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        intBtn.setBackground(new Color(255, 255, 255));

        panel.add(input1Lbl);
        panel.add(input1Fld);

        panel.add(rezLbl);
        panel.add(rezFld);

        panel.add(rez4Btn);

        int x1=60;
        int y1=100;
        layout.putConstraint(SpringLayout.EAST, input1Lbl,-5, SpringLayout.WEST, input1Fld);
        layout.putConstraint(SpringLayout.WEST, input1Fld,x1, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Fld,y1, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Lbl,y1, SpringLayout.NORTH, dreapta);


        int x3=60;
        int y3=180;
        layout.putConstraint(SpringLayout.EAST, rezLbl,-5, SpringLayout.WEST, rezFld);
        layout.putConstraint(SpringLayout.WEST, rezFld,x3, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezFld,y3, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezLbl,y3, SpringLayout.NORTH, dreapta);

        int x4=100;
        int y4=300;
        layout.putConstraint(SpringLayout.WEST, rez4Btn,x4, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rez4Btn,y4, SpringLayout.NORTH, dreapta);

        dreapta.add(panel);
        this.setVisible(true);

    }




    public void DisplayMul() {

        dreapta.removeAll(); //golesc panelul din dreapta ca sa nu adaug addPaneluri la el in continuu
        stanga.removeAll();
        DisplayStd();


        JPanel panel=new JPanel();
        panel.setBackground(new Color(186,225,255));
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        mulBtn.setBackground(new Color(255, 255, 255));
        panel.add(input1Lbl);
        panel.add(input1Fld);
        panel.add(input2Lbl);
        panel.add(input2Fld);
        panel.add(rezLbl);
        panel.add(rezFld);


        panel.add(rez5Btn);

        int x1=60;
        int y1=100;
        layout.putConstraint(SpringLayout.EAST, input1Lbl,-5, SpringLayout.WEST, input1Fld);
        layout.putConstraint(SpringLayout.WEST, input1Fld,x1, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Fld,y1, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Lbl,y1, SpringLayout.NORTH, dreapta);
        int x2=60;
        int y2=140;
        layout.putConstraint(SpringLayout.EAST, input2Lbl,-5, SpringLayout.WEST, input2Fld);
        layout.putConstraint(SpringLayout.WEST, input2Fld,x2, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input2Fld,y2, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input2Lbl,y2, SpringLayout.NORTH, dreapta);
        int x3=60;
        int y3=180;
        layout.putConstraint(SpringLayout.EAST, rezLbl,-5, SpringLayout.WEST, rezFld);
        layout.putConstraint(SpringLayout.WEST, rezFld,x3, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezFld,y3, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezLbl,y3, SpringLayout.NORTH, dreapta);

        int x4=100;
        int y4=300;
        layout.putConstraint(SpringLayout.WEST, rez5Btn,x4, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rez5Btn,y4, SpringLayout.NORTH, dreapta);



        dreapta.add(panel);
        this.setVisible(true);

    }


    public void DisplayDiv() {

        dreapta.removeAll(); //golesc panelul din dreapta ca sa nu adaug addPaneluri la el in continuu
        stanga.removeAll();
        DisplayStd();


        JPanel panel=new JPanel();
        panel.setBackground(new Color(186,225,255));
        SpringLayout layout = new SpringLayout();
        panel.setLayout(layout);
        divBtn.setBackground(new Color(255, 255, 255));
        panel.add(input1Lbl);
        panel.add(input1Fld);
        panel.add(input2Lbl);
        panel.add(input2Fld);
        panel.add(rezLbl);
        panel.add(rezFld);
        panel.add(restLbl);
        panel.add(restFld);

        panel.add(rez6Btn);

        int x1=60;
        int y1=100;
        layout.putConstraint(SpringLayout.EAST, input1Lbl,-5, SpringLayout.WEST, input1Fld);
        layout.putConstraint(SpringLayout.WEST, input1Fld,x1, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Fld,y1, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input1Lbl,y1, SpringLayout.NORTH, dreapta);
        int x2=60;
        int y2=140;
        layout.putConstraint(SpringLayout.EAST, input2Lbl,-5, SpringLayout.WEST, input2Fld);
        layout.putConstraint(SpringLayout.WEST, input2Fld,x2, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input2Fld,y2, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, input2Lbl,y2, SpringLayout.NORTH, dreapta);
        int x3=60;
        int y3=180;
        layout.putConstraint(SpringLayout.EAST, rezLbl,-5, SpringLayout.WEST, rezFld);
        layout.putConstraint(SpringLayout.WEST, rezFld,x3, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezFld,y3, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rezLbl,y3, SpringLayout.NORTH, dreapta);

        int x5=60;
        int y5=220;
        layout.putConstraint(SpringLayout.EAST, restLbl,-5, SpringLayout.WEST, restFld);
        layout.putConstraint(SpringLayout.WEST, restFld,x5, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, restFld,y5, SpringLayout.NORTH, dreapta);
        layout.putConstraint(SpringLayout.NORTH, restLbl,y5, SpringLayout.NORTH, dreapta);


        int x4=100;
        int y4=300;
        layout.putConstraint(SpringLayout.WEST, rez6Btn,x4, SpringLayout.WEST, dreapta);
        layout.putConstraint(SpringLayout.NORTH, rez6Btn,y4, SpringLayout.NORTH, dreapta);


        dreapta.add(panel);
        this.setVisible(true);

    }





    //for buttons
    public void addAddListener(ActionListener mal) {
        addBtn.addActionListener(mal);
    }
    public void addSubListener(ActionListener mal) {
        subBtn.addActionListener(mal);
    }
    public void addDerListener(ActionListener mal) {
        derBtn.addActionListener(mal);
    }
    public void addIntListener(ActionListener mal) {
        intBtn.addActionListener(mal);
    }
    public void addMulListener(ActionListener mal) {
        mulBtn.addActionListener(mal);
    }
    public void addDivListener(ActionListener mal) {
        divBtn.addActionListener(mal);
    }


    //for fields
    public String getUserInput1() { return input1Fld.getText(); }
    public String getUserInput2() {
        return input2Fld.getText();
    }

    public void setRez(String a) {
        rezFld.setText(a);
    }
    public void setRest(String a) {
        restFld.setText(a);
    }

    //for result
    public void addRez1Listener(ActionListener mal) {
        rez1Btn.addActionListener(mal);
    }
    public void addRez2Listener(ActionListener mal) {
        rez2Btn.addActionListener(mal);
    }
    public void addRez3Listener(ActionListener mal) {
        rez3Btn.addActionListener(mal);
    }
    public void addRez4Listener(ActionListener mal) {
        rez4Btn.addActionListener(mal);
    }
    public void addRez5Listener(ActionListener mal) {
        rez5Btn.addActionListener(mal);
    }
    public void addRez6Listener(ActionListener mal) {
        rez6Btn.addActionListener(mal);
    }


}
