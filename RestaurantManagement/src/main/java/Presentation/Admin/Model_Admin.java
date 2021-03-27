package Presentation.Admin;


import Business.*;


public class Model_Admin implements IRestaurantProcessingAdministartor
{
    Restaurant restaurant;
    public Model_Admin(Restaurant restaurant) {
        this.restaurant = restaurant;
    }



    @Override
    public void createBaseProduct(String newProduct, int price) {
        BaseProduct a= new BaseProduct(newProduct, price);
        restaurant.addToMenu(a);
    }
    @Override
    public void createCompositeProduct(String newProduct) {
        CompositeProduct a= new CompositeProduct(newProduct);
        restaurant.addToMenu(a);
    }

    @Override
    public void deleteMenuItem(String menuItem) {
        restaurant.removeFromMenuByName(menuItem);
    }

    @Override
    public void editProduct(MenuItem part, CompositeProduct whole) {
        whole.addComponent(part);
    }


}