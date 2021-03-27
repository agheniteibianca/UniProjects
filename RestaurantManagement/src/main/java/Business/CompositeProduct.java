package Business;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem implements java.io.Serializable{
    private static final long serialVersionUID = 6529685098255757690L;

    public String name;
    public int price;
    List<MenuItem> components =new ArrayList();

    public CompositeProduct(String name) {
        super(name);
    }
    public CompositeProduct() {
    }

    public void addComponent (MenuItem newComponent){
        components.add(newComponent);
    }
    public void addMenuItemtoComposite(MenuItem newIngredient, CompositeProduct recipe) {
        recipe.addComponent(newIngredient);
    }
    @Override
    public void showName(){
        System.out.println(name);
        for(MenuItem c:components){
            c.showName();
        }
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void removeFromRecipeByName(String nameToDelete) {

        //verific daca am in lista ingredintul asta si il sterg
        MenuItem toBeDeleted=null;
        for(MenuItem a: components){
            if(a.getName().equals(nameToDelete)){
                toBeDeleted=a;
            }
        }
        components.remove(toBeDeleted);

        //verific daca unul dintre ingrediente contine ingredientul de sters. cautarea se opreste cand se ajunge la o frunza,
        //fiindca codul de frunza nu face nimic
        for(MenuItem a: components){
            a.removeFromRecipeByName(nameToDelete);
        }
    }
    public List<MenuItem> getComponents() {
        return components;
    }
}
