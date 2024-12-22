public interface StockManagement {
    void addProduct(Product product);
    void updateProductQuantity(int id, int quantity);
    void removeProduct(int id);
    void listProducts();
}
