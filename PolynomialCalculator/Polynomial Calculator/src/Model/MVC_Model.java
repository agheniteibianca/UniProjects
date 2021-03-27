package Model;



public class MVC_Model
{
    //implement the logic of the program
    public String add(String input1,String input2)
    {
        Polinom poli1= Polinom.creeazaPolinom(input1);
        Polinom poli2= Polinom.creeazaPolinom(input2);
        String rez= poli1.adunaPolinom(poli2);
        System.out.println(rez);
        return (rez);
    }
    public String sub(String input1,String input2)
    {
        Polinom poli1= Polinom.creeazaPolinom(input1);
        Polinom poli2= Polinom.creeazaPolinom(input2);
        String rez= poli1.scadePolinom(poli2);
        System.out.println(rez);
        return (rez);
    }
    public String der(String input1)
    {
        Polinom poli1= Polinom.creeazaPolinom(input1);
        String rez= poli1.deriveazaPolinom();
        System.out.println(rez);
        return (rez);
    }
    public String inte(String input1)
    {
        Polinom poli1= Polinom.creeazaPolinom(input1);
        String rez= poli1.integreazaPolinom();
        System.out.println(rez);
        return (rez);
    }
    public String mul(String input1, String input2)
    {
        Polinom poli1= Polinom.creeazaPolinom(input1);
        Polinom poli2= Polinom.creeazaPolinom(input2);
        String rez= poli1.inmultestePolinom(poli2);
        System.out.println(rez);
        return (rez);
    }

    public  class RezImp{
    public String rest;
   public String cat;
}


    public RezImp div(String input1, String input2)
    {
        Polinom poli1= Polinom.creeazaPolinom(input1);
        Polinom poli2= Polinom.creeazaPolinom(input2);
        poli2= poli1.impartePolinom(poli2);

        RezImp rezultat=new RezImp();

        rezultat.rest=poli1.toString();
        rezultat.cat=poli2.toString();

        return rezultat;
    }

}