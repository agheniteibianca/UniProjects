package Presentation.Admin;
import Business.BaseProduct;
import Business.CompositeProduct;
import Business.MenuItem;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import javax.swing.*;


public class View_Admin extends JFrame {
    Model_Admin model;
    JLabel titleLabel=new JLabel();
    JLabel descriptionLabel=new JLabel();
    JPanel panel;
    SpringLayout layout;

    JButton rez1Btn = new JButton("Add base ");
    JTextField input1Fld = new JTextField(15);
    JLabel input1Lbl = new JLabel("Base name: ");
    JTextField input2Fld = new JTextField(15);
    JLabel input2Lbl = new JLabel("Price: ");
    JButton rez2Btn = new JButton("Add composite");
    JTextField input3Fld = new JTextField(15);
    JLabel input3Lbl = new JLabel("Composite name: ");
    JButton mixBtn = new JButton("Add");


    JTable tabel1;
    MenuItem[][] data1;
    JTable tabel;
    String[][] data;


    JComboBox c1;
    MenuItem[] comboData1;
    JComboBox c2;
    MenuItem[] comboData2;


    public View_Admin(Model_Admin m) {
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
        displayTable1();
        displayTable();
        displayComboBoxes();
        this.setVisible(true);

    }

    public void displayBasic() {
        panel.setBackground(new Color(186,225,255));
        layout = new SpringLayout();
        panel.setLayout(layout);
        panel.add(input1Lbl);
        panel.add(input1Fld);
        panel.add(input2Lbl);
        panel.add(input2Fld);
        panel.add(input3Lbl);
        panel.add(input3Fld);

        panel.add(rez1Btn);
        panel.add(rez2Btn);
        panel.add(mixBtn);

        titleLabel.setText("Mod ADMIN");
        int xtitlu=150;
        int ytitlu=15;
        layout.putConstraint(SpringLayout.WEST, titleLabel,xtitlu, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, titleLabel,ytitlu, SpringLayout.NORTH, panel);
        panel.add(titleLabel);

        descriptionLabel.setText("Add any item to a composite:");
        int xdescriere=300;
        int ydescriere=240;
        layout.putConstraint(SpringLayout.WEST, descriptionLabel,xdescriere, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, descriptionLabel,ydescriere, SpringLayout.NORTH, panel);
        panel.add(descriptionLabel);



        int x1=400;
        int y1=50;
        layout.putConstraint(SpringLayout.EAST, input1Lbl,-5, SpringLayout.WEST, input1Fld);
        layout.putConstraint(SpringLayout.WEST, input1Fld,x1, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, input1Fld,y1, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, input1Lbl,y1, SpringLayout.NORTH, panel);
        int x2=400;
        int y2=70;
        layout.putConstraint(SpringLayout.EAST, input2Lbl,-5, SpringLayout.WEST, input1Fld);
        layout.putConstraint(SpringLayout.WEST, input2Fld,x2, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, input2Fld,y2, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, input2Lbl,y2, SpringLayout.NORTH, panel);
        int x4=400;
        int y4=150;
        layout.putConstraint(SpringLayout.EAST, input3Lbl,-5, SpringLayout.WEST, input1Fld);
        layout.putConstraint(SpringLayout.WEST, input3Fld,x4, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, input3Fld,y4, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, input3Lbl,y4, SpringLayout.NORTH, panel);


        int x3=400;
        int y3=100;
        layout.putConstraint(SpringLayout.WEST, rez1Btn,x3, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, rez1Btn,y3, SpringLayout.NORTH, panel);

        int x5=400;
        int y5=185;
        layout.putConstraint(SpringLayout.WEST, rez2Btn,x5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, rez2Btn,y5, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, rez2Btn,y5, SpringLayout.NORTH, panel);

        int x6=400;
        int y6=300;
        layout.putConstraint(SpringLayout.WEST, mixBtn,x6, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, mixBtn,y6, SpringLayout.NORTH, panel);


        this.add(panel);
        this.setVisible(true);
    }

    public void displayTable1 (){
        data1 =new MenuItem[100][1];
        String[] columnNames1 = { "Meniu"};

        //compute data to add
        int i=0;
        for(MenuItem e: model.restaurant.menu){
            data1[i][0]=model.restaurant.menu.get(i);
            i++;
        }
        tabel1 = new JTable(data1, columnNames1);
        JScrollPane sp1 = new JScrollPane(tabel1);
        panel.add(sp1);

        int xtabel1=10;
        int ytabel1=70;
        layout.putConstraint(SpringLayout.WEST, sp1,xtabel1, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sp1,ytabel1, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, sp1,-470, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, sp1,-100, SpringLayout.SOUTH, panel);
    }

    public void updateTable1() {
        for(int i=0;i<100;i++){
            data[i][0]=null;
        }
        int i=0;
        for(MenuItem e: model.restaurant.menu){
            data1[i][0]=model.restaurant.menu.get(i);
            i++;
        }
        tabel1.repaint();
    }



    public void displayTable(){
        data =new String[100][2];
        String[] columnNames = { "Ingredient", "Pret"};

        tabel = new JTable(data, columnNames);
        JScrollPane sp = new JScrollPane(tabel);
        panel.add(sp);

        int xtabel=120;
        int ytabel=70;
        layout.putConstraint(SpringLayout.WEST, sp,xtabel, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sp,ytabel, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, sp,-300, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, sp,-100, SpringLayout.SOUTH, panel);
    }

    public void updateTable(Object obj){
        //refresh table
        for(int x=0;x<100;x++)
            for(int y=0;y<2;y++)
                data[x][y]=null;

        if(obj instanceof CompositeProduct) {
            CompositeProduct comp = (CompositeProduct) obj;
            int i = 0;
            for (MenuItem e : comp.getComponents()) {
                data[i][0] = comp.getComponents().get(i).name;
                data[i][1] = String.valueOf(comp.getComponents().get(i).price);
                i++;
            }
        }
        else { //base product
            BaseProduct base = (BaseProduct) obj;

            System.out.println(base);
            System.out.println(base.getPrice());

            data[0][1]= String.valueOf(base.getPrice());
            data[0][0]= "Base prod.";
        }

        tabel.repaint();
    }



    public void displayComboBoxes(){
        comboData1 =new MenuItem[100];
        comboData2 =new MenuItem[100];

        for(int i=0;i<100;i++){
            comboData1[i]=null;
            comboData2[i]=null;
        }

        int i=0;
        for(MenuItem e:model.restaurant.menu){
            comboData1[i]=model.restaurant.menu.get(i);
            i++;
        }
        c1 = new JComboBox(comboData1);
        panel.add(c1);
        int xcombo1=300;
        int ycombo1=270;
        layout.putConstraint(SpringLayout.WEST, c1,xcombo1, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, c1,ycombo1, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, c1,-150, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, c1,-70, SpringLayout.SOUTH, panel);


        i=0;
        int j=0;
        for(MenuItem e: model.restaurant.menu){
            if(e instanceof CompositeProduct){
                comboData2[j]=model.restaurant.menu.get(i);
                j++;
            }
            i++;
        }

        c2 = new JComboBox(comboData2);
        panel.add(c2);
        int xcombo2=450;
        int ycombo2=270;
        layout.putConstraint(SpringLayout.WEST, c2,xcombo2, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, c2,ycombo2, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, c2,-10, SpringLayout.EAST, panel);
        layout.putConstraint(SpringLayout.SOUTH, c2,-70, SpringLayout.SOUTH, panel);

        panel.repaint();
    }


    //for fields
    public String getUserInput1() {
        return input1Fld.getText();
    }
    public String getUserInput2() {
        return input2Fld.getText();
    }
    public String getUserInput3() {
        return input3Fld.getText();
    }


    //for buttons
    public void addRez1Listener(ActionListener mal) {
        rez1Btn.addActionListener(mal);
    }
    public void addRez2Listener(ActionListener mal) {
        rez2Btn.addActionListener(mal);
    }
    public void addMixListener(ActionListener mal) {
        mixBtn.addActionListener(mal);
    }

    //for table
    public void addTabelListener(MouseAdapter mal) {
        tabel1.addMouseListener(mal);
    }
    //for combo box

    public void addComboListener1(ItemListener mal) {
        c1.addItemListener(mal);
    }
    public void addComboListener2(ItemListener mal) {
        c2.addItemListener(mal);
    }



}
