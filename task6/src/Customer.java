public class Customer {
    private String name;
    private double money;

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public void buyProduct(Store store, Product product) {
        if (money >= product.getPrice()) {
            store.sellProduct(product);
            money -= product.getPrice();
            System.out.println(name + " bought " + product.getName());
        } else {
            System.out.println(name + " does not have enough money to buy " + product.getName());
        }
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
