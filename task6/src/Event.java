import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Event {
    private Queue<String> eventQueue;
    private Store store;
    private Warehouse warehouse;
    private Random random;

    public Event(Queue<String> eventQueue, Store store, Warehouse warehouse) {
        this.eventQueue = eventQueue;
        this.store = store;
        this.warehouse = warehouse;
        this.random = new Random();
    }

    public void generateRandomEvent() {
        int eventType = random.nextInt(3);
        String event = "";
        switch (eventType) {
            case 0:
                event = "Arrival of new products";
                handleArrivalOfNewProducts();
                break;
            case 1:
                event = "Setting up discounts";
                handleSettingUpDiscounts();
                break;
        }
        eventQueue.add(event);
        System.out.println("Generated event: " + event);
    }

    private void handleArrivalOfNewProducts() {
        warehouse.addProduct(new Product("New Product", 2.0, new Date()));
        store.transferProductsFromWarehouse(warehouse, 1);
        System.out.println("New products arrived and transferred to the store.");
    }

    private void handleSettingUpDiscounts() {
        List<Product> productsInStore = store.getAllProducts();
        if (!productsInStore.isEmpty()) {
            Product product = productsInStore.get(0);
            store.applyDiscount(product, 0.2);
            System.out.println("Discount set up for a product.");
        } else {
            System.out.println("No products available in the store.");
        }
    }
}