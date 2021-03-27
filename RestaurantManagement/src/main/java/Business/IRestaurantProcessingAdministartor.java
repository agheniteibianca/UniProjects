package Business;

public interface IRestaurantProcessingAdministartor {

    void createBaseProduct (String newProduct, int price);
    void createCompositeProduct (String newProduct);
    void deleteMenuItem (String menuItem);
    void editProduct(MenuItem part, CompositeProduct whole);
}
