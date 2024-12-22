import java.util.Scanner;

public class StockControlSystem {
    public static void main(String[] args) {
        StockControl stockControl = new StockControl(); // Stok kontrol sistemi oluşturuluyor
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Menü
            System.out.println("\n1. Ürün Ekle");
            System.out.println("2. Ürün Güncelle");
            System.out.println("3. Ürün Sil");
            System.out.println("4. Stok Listele");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Ürün ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Buffer temizleme
                    System.out.print("Ürün Adı: ");
                    String name = scanner.nextLine();
                    System.out.print("Ürün Miktarı: ");
                    int quantity = scanner.nextInt();
                    stockControl.addProduct(new Product(id, name, quantity)); // Ürün ekleniyor
                    break;
                case 2:
                    System.out.print("Güncellenecek Ürün ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Yeni Miktar: ");
                    int newQuantity = scanner.nextInt();
                    stockControl.updateProductQuantity(updateId, newQuantity); // Ürün güncelleniyor
                    break;
                case 3:
                    System.out.print("Silinecek Ürün ID: ");
                    int removeId = scanner.nextInt();
                    stockControl.removeProduct(removeId); // Ürün siliniyor
                    break;
                case 4:
                    stockControl.listProducts(); // Stok listeleniyor
                    break;
                case 5:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        } while (choice != 5);

        scanner.close(); // Kaynakları kapat
    }
}
