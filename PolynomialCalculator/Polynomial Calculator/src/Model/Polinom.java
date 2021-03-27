package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    List<Monom> listaMonom;
    private static int nr=0;

    public Polinom(List<Monom> lista) {
        this.listaMonom = lista;
        nr++;
    }

    public List<Monom> getMonom() {
        return listaMonom;
    }

    public void setMonom(List<Monom> monomSet) {
        this.listaMonom = monomSet;
    }


    public static Polinom creeazaPolinom(String input){
        List<Monom> myList=new ArrayList<Monom>();
        Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );
        Matcher m = p.matcher( input );
        while (m.find()) {
            float coef = Float.parseFloat(m.group(1));
            int degree= Integer.parseInt( m.group(2));

            Monom nou= new Monom  (degree,coef);
            myList.add(nou);

        }
        Polinom poli = new Polinom(myList);
        System.out.println(poli);
        return poli;
    }


    public void sortByGrad (Polinom src){

    }




    public String adunaPolinom(Polinom src) { //consturim solutia in this
        System.out.print("Rezultatul sumei: ");
        for (Monom i : this.listaMonom) {
            for(Monom j: src.listaMonom){
                if(i.getGrad()==j.getGrad())
                    i.setCoeficient(i.getCoeficient()+j.getCoeficient());

            }
        } //am construit solutia si trebuie sa verificam daca avem termeni in src care nu exista in solutie ca sa ii adaugam

        List<Monom> deAdaugat= new ArrayList<Monom>();
        int gasit;
        for (Monom i: src.listaMonom){
            gasit=0;
            for(Monom j: this.listaMonom){
                if(i.getGrad()==j.getGrad()){
                    gasit=1;
                }
            }
            if(gasit==0) {
                deAdaugat.add(i); //retinem intr-o lista toate elementele care mai trebuie adaugate
            }
        }
        for (Monom i: deAdaugat){
            this.listaMonom.add(i);
        }
        for(Monom i:this.listaMonom){
            System.out.println(i);
        }
        String rez="";
        for(Monom i:this.listaMonom){
            rez+=i;
        }
        return rez;
    }



    public String scadePolinom(Polinom src) { //consturim solutia in this
        //System.out.print("Rezultatul scaderii: ");
        for (Monom i : this.listaMonom) {
            for(Monom j: src.listaMonom){
                if(i.getGrad()==j.getGrad())
                    i.setCoeficient(i.getCoeficient()-j.getCoeficient());
            }
        } //am construit solutia si trebuie sa verificam daca avem termeni in src care nu exista in solutie ca sa ii adaugam
        List<Monom> deAdaugat= new ArrayList<Monom>();
        int gasit;
        for (Monom i: src.listaMonom){
            gasit=0;
            for(Monom j: this.listaMonom){
                if(i.getGrad()==j.getGrad()){
                    gasit=1;
                }
            }
            if(gasit==0) {
                i=i.schimbaSemn();
                deAdaugat.add(i); //retinem intr-o lista toate elementele care mai trebuie adaugate
            }
        }
        for (Monom i: deAdaugat){
            this.listaMonom.add(i);
        }
       /* for(Monom i:this.listaMonom){
            System.out.println(i);
        }*/
        String rez="";
        for(Monom i:this.listaMonom){
            rez+=i;
        }
        return rez;
    }


    public String deriveazaPolinom() {
        System.out.print("Rezultatul derivarii: ");
        List<Monom> deSters= new ArrayList<Monom>(); //va trebui sa stergem termenii de grad 0
        for (Monom i : this.listaMonom) {
            if(i.getGrad()==0){
                deSters.add(i);
            }
            else{
                 i.setCoeficient(i.getCoeficient()*i.getGrad());
                 i.setGrad(i.getGrad()-1);
            }
        }
        for (Monom i: deSters){
            this.listaMonom.remove(i);
        }
        String rez="";
        for(Monom i:this.listaMonom){
            rez+=i;
        }
        return rez;
    }


    public String integreazaPolinom() {
        System.out.print("Rezultatul integrarii: ");

        for (Monom i : this.listaMonom) {

            i.setGrad(i.getGrad()+1);
            i.setCoeficient(i.getCoeficient() / i.getGrad());
        }

        String rez="";
        for(Monom i:this.listaMonom){
            rez+=i;
        }
        return rez;
    }

    public String inmultestePolinom(Polinom src) {
        System.out.print("Rezultatul inmultirii: ");
        List<Monom> myList=new ArrayList<Monom>();
        Polinom nou=new Polinom(myList);
        for (Monom i : this.listaMonom) {
            for (Monom j : src.listaMonom) {
                float coef=i.getCoeficient()*j.getCoeficient();
                int grad=i.getGrad()+j.getGrad();
                Monom termen =new Monom(grad, coef);
                nou.listaMonom.add(termen);
            }
        }
        this.listaMonom=nou.listaMonom;

        String rez="";
        for(Monom i:this.listaMonom){
            rez+=i;
        }
        return rez;
    }

    public Polinom(Polinom another) {  //pentru creat copii
        this.listaMonom = another.listaMonom;
    }

    public Polinom  impartePolinom(Polinom src){ //returneaza restul
        List<Monom> myList=new ArrayList<Monom>();
        Polinom rest= new Polinom(myList);
        List<Monom> myList2=new ArrayList<Monom>();
        Polinom cat= new Polinom(myList);
        int grad_impartitor=src.find_biggest().getGrad();

       // System.out.println(grad_impartitor);

        Monom biggest_deimpartit;
        Monom biggest_impartitor;
        biggest_deimpartit = this.find_biggest();








       while( biggest_deimpartit.getGrad()>=grad_impartitor){



           //facem o copie a deimpartitului

           List<Monom> impartit = new ArrayList<>();
           for(Monom i:src.listaMonom){
               Monom a=new Monom(i);
               impartit.add(a);
           }
           Polinom impartitor_copy =new Polinom(impartit);
            biggest_impartitor = impartitor_copy.find_biggest();

           //System.out.println("Deimpartitul este: " +this);
           //System.out.println("Impartitorul este: "+ src);

            int val_grad = biggest_deimpartit.getGrad() - biggest_impartitor.getGrad(); //gradul noului monom din cat
            float val_coef = biggest_deimpartit.getCoeficient() / biggest_impartitor.getCoeficient(); //coeficientului noului monom din cat
            Monom nou = new Monom(val_grad, val_coef);
            cat.listaMonom.add(nou);

          // System.out.println("Catul curent este"+ cat);
           // D=D-I*monom_nou
            for (Monom i : impartitor_copy.listaMonom) {
                i.setCoeficient(i.getCoeficient() * nou.getCoeficient());
                i.setGrad(i.getGrad() + nou.getGrad());
            }
           //System.out.println("Scadem din deimpartit: "+ impartitor_copy);

            this.scadePolinom(impartitor_copy);

          // System.out.println("Acum deimpartitul este:" + this);
            biggest_deimpartit = this.find_biggest();
          // System.out.println("Cel mai mare termen al deimpartitului este "+ biggest_deimpartit);
          // System.out.println("\n\n\n\n\n");
        }

        System.out.println("Catul e" +cat);
        System.out.println("Restul e" +this);
        return cat; //ce a ramas din impartitor in this e restul

    }

    public Monom find_biggest(){
        Monom biggest=new Monom(0,0);
        for(Monom i: this.listaMonom)  {
            if(i.getGrad()>biggest.getGrad() && i.getCoeficient()!=0){
                biggest=i;
            }
        }
        return biggest;
    }


        @Override
    public String toString() {
        //AtomicReference<String> output= new AtomicReference<>("Polinomul este:");
        // monom.forEach((n)-> output.updateAndGet(v -> v + n));
        // return output.get();

        String output = "";
        for (Monom i : this.listaMonom) {
            output += i;
        }
        return output;
    }
}
