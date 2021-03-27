package Business;

public abstract class MenuItem implements java.io.Serializable{
    public String name;
    public int price;

    public MenuItem() {
    }
    public MenuItem(String name) {
        this.name = name;
    }

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public abstract void showName();
    public abstract void removeFromRecipeByName(String name);

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString (){
        return name;
    }



}
