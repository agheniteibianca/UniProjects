package Controller;

 import Model.MVC_Model;
import Model.Polinom;
import View.MVC_View;

public class MainClass {
   /* public static void main(String[] args) {

        String input1 = "10x^5+2x^2";
        String input2 = "3x^4+7x^1";

       // String input2 = "2x^3-3x^-2+4x^2+3x^1";


        Polinom poli1= Polinom.creeazaPolinom(input1);
        Polinom poli2= Polinom.creeazaPolinom(input2);
        //poli1.deriveazaPolinom();
        poli1.impartePolinom(poli2);

    }*/


        public static void main (String args[])
        {
            MVC_Model m = new MVC_Model();
            MVC_View v = new MVC_View(m);
            new MVC_Controller(v, m);

        }

    }

