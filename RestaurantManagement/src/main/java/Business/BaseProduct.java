package Business;

public class BaseProduct extends MenuItem implements java.io.Serializable{
    private static final long serialVersionUID = 6529985098267757690L;
    String name;
    public int price;

    public BaseProduct(){
    }
    public BaseProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public void showName() {
        System.out.println(name);
    }
    @Override
    public String getName(){
       return name;
    }
    @Override
    public void removeFromRecipeByName(String nameToDelete) {
    }


}
