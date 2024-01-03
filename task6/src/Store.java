import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Store {
    private List<Product> productsInStore;
    private double cash;
    private Queue<String> eventQueue;

    public Store() {
        this.productsInStore = new ArrayList<>();
        this.cash = 0.0;
        this.eventQueue = new LinkedList<>();
    }

    public void transferProductsFromWarehouse(Warehouse warehouse, int quantity) {
        List<Product> warehouseProducts = warehouse.getAllProducts();
        int count = 0;

        Iterator<Product> iterator = warehouseProducts.iterator();
        while (iterator.hasNext() && count < quantity) {
            Product product = iterator.next();
            if (product.getExpirationDate() != null && product.getExpirationDate().before(new Date())) {
                System.out.println("Product " + product.getName() + " has expired and cannot be transferred.");
                iterator.remove();
            } else {
                productsInStore.add(product);
                count++;
                iterator.remove();
            }
        }

        System.out.println("Transferred " + count + " products from warehouse to store.");
    }

    public void sellProduct(Product product) {
        if (product.getExpirationDate() != null && product.getExpirationDate().before(new Date())) {
            System.out.println("Product " + product.getName() + " has expired and cannot be sold.");
            return;
        }

        productsInStore.remove(product);
        cash += product.getPrice();
        System.out.println("Sold product: " + product.getName());
    }

    public void applyDiscount(Product product, double discount) {
        double discountedPrice = product.getPrice() * (1 - discount);
        product.setPrice(discountedPrice);
        System.out.println("Applied " + (discount * 100) + "% discount on " + product.getName());
    }

    public List<Product> getAllProducts() {
        return productsInStore;
    }

    public Queue<String> getEventQueue() {
        return eventQueue;
    }
}
