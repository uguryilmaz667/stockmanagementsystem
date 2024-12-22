import java.io.*;
import java.util.*;

public class StockControl implements StockManagement {
    private Map<Integer, Product> stock = new HashMap<>();
    private static final String FILE_NAME = "stock_data.txt";

    public StockControl() {
        loadFromFile();
    }

    @Override
    public void addProduct(Product product) {
        stock.put(product.getId(), product);
        saveToFile();
    }

    @Override
    public void updateProductQuantity(int id, int quantity) {
        if (stock.containsKey(id)) {
            stock.get(id).setQuantity(quantity);
            saveToFile();
        }
    }

    @Override
    public void removeProduct(int id) {
        stock.remove(id);
        saveToFile();
    }

    @Override
    public void listProducts() {
        stock.values().forEach(System.out::println); // Lambda kullanımı
    }

    public List<Product> getProducts() {
        return new ArrayList<>(stock.values());
    }

    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(stock);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            stock = (Map<Integer, Product>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı, yeni bir stok oluşturuluyor.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
