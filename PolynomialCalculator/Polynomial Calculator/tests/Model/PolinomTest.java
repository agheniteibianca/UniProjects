package Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolinomTest {

    @Test
    public void adunaPolinom() {
        String input1 = "10x^5+2x^2";
        String input2 = "3x^4+7x^1";
        Polinom poli1= Polinom.creeazaPolinom(input1);
        Polinom poli2= Polinom.creeazaPolinom(input2);
        String rez=poli1.adunaPolinom(poli2);
        String sol="+10.0x^5+2.0x^2+3.0x^4+7.0x^1";
        assertTrue(rez.equals(sol));

        input1="6x^5+10x^0";
        input2="4x^5-3x^0";
        poli1= Polinom.creeazaPolinom(input1);
        poli2= Polinom.creeazaPolinom(input2);
        rez=poli1.adunaPolinom(poli2);
        sol="+10.0x^5+7.0x^0";
        assertTrue(rez.equals(sol));
    }

    @Test
    public void scadePolinom() {
        String input1 = "10x^5+2x^2";
        String input2 = "3x^4+7x^1";
        Polinom poli1= Polinom.creeazaPolinom(input1);
        Polinom poli2= Polinom.creeazaPolinom(input2);
        String rez=poli1.scadePolinom(poli2);
        String sol="+10.0x^5+2.0x^2-3.0x^4-7.0x^1";
        assertTrue(rez.equals(sol));

        input1="6x^5+10x^0";
        input2="4x^5-3x^0";
        poli1= Polinom.creeazaPolinom(input1);
        poli2= Polinom.creeazaPolinom(input2);
        rez=poli1.scadePolinom(poli2);
        sol="+2.0x^5+13.0x^0";
        assertTrue(rez.equals(sol));
    }

    @Test
    public void deriveazaPolinom() {
        String input1 = "2x^5+2x^2";
        Polinom poli1= Polinom.creeazaPolinom(input1);
        String rez=poli1.deriveazaPolinom();
        String sol="+10.0x^4+4.0x^1";
        assertTrue(rez.equals(sol));

        input1="6x^5+10x^0";
        poli1= Polinom.creeazaPolinom(input1);
        rez=poli1.deriveazaPolinom();
        sol="+30.0x^4";
        assertTrue(rez.equals(sol));
    }

    @Test
    public void integreazaPolinom() {
        String input1 = "2x^4+2x^3";
        Polinom poli1= Polinom.creeazaPolinom(input1);
        String rez=poli1.integreazaPolinom();
        String sol="+0.4x^5+0.5x^4";
        assertTrue(rez.equals(sol));

        input1="6x^5+10x^0";
        poli1= Polinom.creeazaPolinom(input1);
        rez=poli1.integreazaPolinom();
        sol="+1.0x^6+10.0x^1";
        assertTrue(rez.equals(sol));

    }
`
    @Test
    public void inmultestePolinom() {
        String input1 = "10x^5+2x^2";
        String input2 = "3x^4";
        Polinom poli1= Polinom.creeazaPolinom(input1);
        Polinom poli2= Polinom.creeazaPolinom(input2);
        String rez=poli1.inmultestePolinom(poli2);
        String sol="+30.0x^9+6.0x^6";
        assertTrue(rez.equals(sol));

    }

    @Test
    public void impartePolinom() {
        String input1 = "9x^5+2x^2";
        String input2 = "3x^4";
        Polinom poli1= Polinom.creeazaPolinom(input1);
        Polinom poli2= Polinom.creeazaPolinom(input2);
        String cat=poli1.impartePolinom(poli2).toString();
        String sol_cat="+3.0x^1";
        String sol_rest=" +2.0x^2";
        assertTrue(cat.equals(sol_cat) || poli1.equals(sol_rest));

    }
}