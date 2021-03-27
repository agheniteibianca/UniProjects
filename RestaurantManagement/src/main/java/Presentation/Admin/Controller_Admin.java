package Presentation.Admin;
import Business.CompositeProduct;
import Business.MenuItem;
import Presentation.Waiter.View_Waiter;
import javax.swing.*;
import java.awt.event.*;


public class Controller_Admin
{
    Model_Admin model;
    View_Admin view;
    View_Waiter viewW;

    MenuItem part;
    CompositeProduct whole;

    public Controller_Admin(View_Admin v, Model_Admin m, View_Waiter viewW)
    {
        model=m;
        view=v;
        this.viewW=viewW;

        view.addRez1Listener(new Rez1Listener());
        view.addRez2Listener(new Rez2Listener());
        view.addMixListener(new MixListener());

        view.addTabelListener(new tabelListener());
        view.addComboListener1(new comboListener1());
        view.addComboListener2(new comboListener2());
    }

    class comboListener1 implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            part= (MenuItem) e.getItem();
        }
    }
    class comboListener2 implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            whole= (CompositeProduct) e.getItem();
        }
    }

    class tabelListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            JTable table = (JTable) e.getSource();
            int row = table.getSelectedRow();
            int column = table.getSelectedColumn();
            MenuItem o = (MenuItem) table.getValueAt(row, column);
            view.updateTable(o);
        }
    }

    class Rez1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String input1=view.getUserInput1();
            int input2=Integer.parseInt(view.getUserInput2());
            model.createBaseProduct(input1, input2);

            view.updateTable1();
            viewW.updateTable();
            view.displayComboBoxes();

        }
    }
    class Rez2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String input3=view.getUserInput3();
            model.createCompositeProduct(input3);

            view.updateTable1();
            viewW.updateTable();
            view.displayComboBoxes();

        }
    }
    class MixListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.editProduct(part, whole);
            view.updateTable1();
            viewW.updateTable();
            view.displayComboBoxes();

        }
    }




}

