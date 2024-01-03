import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Store store = new Store();
        Customer customer = new Customer("John", 100.0);
        Event eventManager = new Event(store.getEventQueue(), store, warehouse);

        Date expirationDate = new Date();
        warehouse.addProduct(new Product("Apple", 1.8, expirationDate));
        warehouse.addProduct(new Product("Potato", 1.8, new Date(2024, 1, 31)));
        warehouse.addProduct(new Product("Banana", 0.8, new Date(2024, 11, 31)));

        store.transferProductsFromWarehouse(warehouse, 2);

        Product productToSell = store.getAllProducts().get(0);
        store.applyDiscount(productToSell, 0.1);
        customer.buyProduct(store, productToSell);


        for (int i = 0; i < 2; i++) {
            eventManager.generateRandomEvent();
        }
    }
}
