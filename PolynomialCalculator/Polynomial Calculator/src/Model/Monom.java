package Model;

public class Monom {
    private int grad;
    private float coeficient;

    public Monom(int grad, float coeficient) {
        this.grad = grad;
        this.coeficient = coeficient;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public float getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(float coeficient) {
        this.coeficient = coeficient;
    }

    public Monom(Monom another) {
        this.grad = another.grad; // you can access
        this.coeficient=another.coeficient;
    }

    public Monom schimbaSemn(){
        this.coeficient=-this.coeficient;
        return this;
    }
    public void add(Monom src){ //aduna monomane cu acelais grad
        if(src.grad!=this.grad){
            System.out.println("Incerci sa aduni monoame care nu aua celasi grad!");
        }
        else{
            this.coeficient+=src.coeficient;
        }
    }
    @Override
    public String toString(){
        if(coeficient<0)
         return coeficient+"x^"+grad;
        else if(coeficient>0)
            return "+" +coeficient+"x^"+grad;
        else
            return " ";
    }
}
