package Presentation.Waiter;
import Business.MenuItem;
import Presentation.Admin.Controller_Admin;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

public class Controller_Waiter {
    Model_Waiter model;
    View_Waiter view;

    public Controller_Waiter(View_Waiter v, Model_Waiter m) {
        model = m;
        view = v;
        view.addTabelListener(new tabelListener());
        view.addOrderListener(new orderListener());
        view.addCheckListener(new checkboxListener());
    }

    class orderListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.createOrder();
            view.refreshOrderData();
        }
    }

    class checkboxListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
                model.okBill=true;
            } else {//checkbox has been deselected
                model.okBill=false;
            };
        }
    }

    class tabelListener extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            System.out.println("piu");
            JTable table = (JTable)e.getSource();
            int row = table.getSelectedRow();
            int column = table.getSelectedColumn();
            MenuItem o = (MenuItem)table.getValueAt(row, column);
            System.out.println(o);

            int i=0;
            for(MenuItem a:model.restaurant.menu){
                if(a.name.equals(o.name)) {
                    model.orderItems.add(model.restaurant.menu.get(i));
                    view.refreshOrderData();
                }
                i++;
            }
        }


    }

    // class ListListener implements ListSelectionListener {
//
//        }
//    }
}