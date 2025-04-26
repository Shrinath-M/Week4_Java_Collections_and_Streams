import java.util.ArrayList;
import java.util.List;
abstract class ProductCategory {
    private String name;
    public ProductCategory(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class BookCategory extends ProductCategory {
    public BookCategory() {
        super("Books");
    }
}
class ClothingCategory extends ProductCategory {
    public ClothingCategory() {
        super("Clothing");
    }
}
class GadgetCategory extends ProductCategory {
    public GadgetCategory() {
        super("Gadgets");
    }
}
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public T getCategory() {
        return category;
    }
    public void applyDiscount(double percentage) {
        if (percentage > 0 && percentage <= 100) {
            price -= price * (percentage / 100);
        }
    }
    public String toString() {
        return name + " (" + category.getName() + ") - $" + price;
    }
}
class ProductCatalog {
    private List<Product<? extends ProductCategory>> products = new ArrayList<>();
    public void addProduct(Product<? extends ProductCategory> product) {
        products.add(product);
    }
    public List<Product<? extends ProductCategory>> getProducts() {
        return products;
    }
    public static <T extends Product<? extends ProductCategory>> void applyDiscount(T product, double percentage) {
        product.applyDiscount(percentage);
    }
}
public class OnlineMarketplace {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        Product<BookCategory> book = new Product<>("The Great Gatsby", 15.99, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 25.49, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 599.99, new GadgetCategory());
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);
        ProductCatalog.applyDiscount(book, 10);
        ProductCatalog.applyDiscount(shirt, 20);
        System.out.println("Product Catalog:");
        for (Product<? extends ProductCategory> product : catalog.getProducts()) {
            System.out.println(product);
        }
    }
}

