package Controller;

import Model.MVC_Model;
import Model.Polinom;
import View.MVC_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MVC_Controller
{
    MVC_Model model;
    MVC_View view;
    public MVC_Controller(MVC_View v, MVC_Model m)
    {
        model=m;
        view=v;
        view.addAddListener(new AddListener());
        view.addSubListener(new SubListener());
        view.addDerListener(new DerListener());
        view.addIntListener(new IntListener());
        view.addMulListener(new MulListener());
        view.addDivListener(new DivListener());

        view.addRez1Listener(new Rez1Listener());
        view.addRez2Listener(new Rez2Listener());
        view.addRez3Listener(new Rez3Listener());
        view.addRez4Listener(new Rez4Listener());
        view.addRez5Listener(new Rez5Listener());
        view.addRez6Listener(new Rez6Listener());

    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.DisplayAdd();
        }
    }
    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.DisplaySub();
        }
    }
    class DerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.DisplayDer();
        }
    }
    class IntListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.DisplayInt();
        }
    }
    class MulListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.DisplayMul();
        }
    }
    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.out.println("piu");
            view.DisplayDiv();
        }
    }

    class Rez1Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //culeg informatii din view
            String input1=view.getUserInput1();
            String input2=view.getUserInput2();

            //calculez rezultatul in model

            String rez= model.add(input1, input2);
            //afisez rezultatul in view
            view.setRez(rez);
        }
    }

    class Rez2Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //culeg informatii din view
            String input1=view.getUserInput1();
            String input2=view.getUserInput2();

            //calculez rezultatul in model

            String rez= model.sub(input1, input2);
            //afisez rezultatul in view
            view.setRez(rez);
        }
    }

    class Rez3Listener implements ActionListener { //derivare
        public void actionPerformed(ActionEvent e) {
            //culeg informatii din view
            String input1=view.getUserInput1();

            //calculez rezultatul in model

            String rez= model.der(input1);
            //afisez rezultatul in view
            view.setRez(rez);
        }
    }
    class Rez4Listener implements ActionListener { //integrare
        public void actionPerformed(ActionEvent e) {
            //culeg informatii din view
            String input1=view.getUserInput1();

            //calculez rezultatul in model

            String rez= model.inte(input1);
            //afisez rezultatul in view
            view.setRez(rez);
        }
    }
    class Rez5Listener implements ActionListener { //inmultire
        public void actionPerformed(ActionEvent e) {
            //culeg informatii din view
            String input1=view.getUserInput1();
            String input2=view.getUserInput2();

            //calculez rezultatul in model

            String rez= model.mul(input1, input2);
            //afisez rezultatul in view
            view.setRez(rez);
        }
    }


    class Rez6Listener implements ActionListener { //impartire
        public void actionPerformed(ActionEvent e) {
            //culeg informatii din view
            String input1=view.getUserInput1();
            String input2=view.getUserInput2();

            //calculez rezultatul in model

            MVC_Model.RezImp rez= model.div(input1, input2);

            //afisez rezultatul in view
            view.setRez(rez.cat);
            view.setRest(rez.rest);

        }
    }


}

