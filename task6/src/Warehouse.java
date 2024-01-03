import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Warehouse {
    private List<Product> products;

    public Warehouse() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeExpiredProducts(Date currentDate) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getExpirationDate().before(currentDate)) {
                iterator.remove();
                System.out.println("Expired product removed: " + product.getName());
            }
        }
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public boolean checkProductAvailability(String name, int quantity) {
        int count = 0;
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                count++;
            }
        }
        return count >= quantity;
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
