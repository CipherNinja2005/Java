import java.util.*;

// 🔹 Product Interface
interface Product {
    void displayDetails();
}

// 🔹 Legacy Class (Old System)
class LegacyItem {
    private int itemId;
    private String description;

    public LegacyItem(int itemId, String description) {
        this.itemId = itemId;
        this.description = description;
    }

    public void print() {
        System.out.println("Legacy Item -> ID: " + itemId + ", Description: " + description);
    }
}

// 🔹 Adapter Class
class ProductAdapter implements Product {
    private LegacyItem legacyItem;

    public ProductAdapter(LegacyItem legacyItem) {
        this.legacyItem = legacyItem;
    }

    @Override
    public void displayDetails() {
        legacyItem.print(); // adapting old method
    }
}

// 🔹 New Product Class
class NewProduct implements Product {
    private String name;

    public NewProduct(String name) {
        this.name = name;
    }

    @Override
    public void displayDetails() {
        System.out.println("New Product -> Name: " + name);
    }
}

// 🔹 Singleton Inventory Manager
class InventoryManager {

    private static InventoryManager instance;
    private List<Product> products;

    // Private constructor (Singleton)
    private InventoryManager() {
        products = new ArrayList<>();
    }

    // Get single instance
    public static InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    // Add product
    public void addProduct(Product p) {
        products.add(p);
    }

    // Return iterator
    public Iterator<Product> returnInventory() {
        return products.iterator();
    }
}

// 🔹 Main Class
public class Main1 {
    public static void main(String[] args) {

        // Get Singleton instance
        InventoryManager manager = InventoryManager.getInstance();

        // Add New Products
        manager.addProduct(new NewProduct("Laptop"));
        manager.addProduct(new NewProduct("Phone"));

        // Add Legacy Items using Adapter
        LegacyItem old1 = new LegacyItem(101, "Old Keyboard");
        LegacyItem old2 = new LegacyItem(102, "Old Mouse");

        manager.addProduct(new ProductAdapter(old1));
        manager.addProduct(new ProductAdapter(old2));

        // Iterate using Iterator
        Iterator<Product> it = manager.returnInventory();

        System.out.println("\n--- Inventory List ---");

        while (it.hasNext()) {
            Product p = it.next();
            p.displayDetails();
        }
    }
}