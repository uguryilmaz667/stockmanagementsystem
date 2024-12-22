import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StockControlSystemGUI {
    private JFrame frame;
    private StockControl stockControl;
    private JTextArea displayArea;

    public StockControlSystemGUI() {
        stockControl = new StockControl();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Stok Kontrol Sistemi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel developerLabel = new JLabel("Developed by Uğur Yılmaz");
        developerLabel.setBounds(600, 520, 200, 20);
        panel.add(developerLabel);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(20, 20, 740, 200);
        panel.add(scrollPane);

        JLabel idLabel = new JLabel("Ürün ID:");
        idLabel.setBounds(20, 250, 100, 20);
        panel.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(120, 250, 150, 20);
        panel.add(idField);

        JLabel nameLabel = new JLabel("Ürün Adı:");
        nameLabel.setBounds(20, 280, 100, 20);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(120, 280, 150, 20);
        panel.add(nameField);

        JLabel quantityLabel = new JLabel("Ürün Miktarı:");
        quantityLabel.setBounds(20, 310, 100, 20);
        panel.add(quantityLabel);

        JTextField quantityField = new JTextField();
        quantityField.setBounds(120, 310, 150, 20);
        panel.add(quantityField);

        JButton addButton = new JButton("Ürün Ekle");
        addButton.setBounds(300, 250, 150, 30);
        addButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                stockControl.addProduct(new Product(id, name, quantity));
                updateDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Lütfen geçerli bir değer girin!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(addButton);

        JLabel removeLabel = new JLabel("Silinecek Ürün ID:");
        removeLabel.setBounds(20, 350, 150, 20);
        panel.add(removeLabel);

        JTextField removeField = new JTextField();
        removeField.setBounds(180, 350, 150, 20);
        panel.add(removeField);

        JButton removeButton = new JButton("Ürün Sil");
        removeButton.setBounds(350, 350, 150, 30);
        removeButton.addActionListener(e -> {
            try {
                int id = Integer.parseInt(removeField.getText());
                stockControl.removeProduct(id);
                updateDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Lütfen geçerli bir ID girin!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(removeButton);

        JButton listButton = new JButton("Stok Listele");
        listButton.setBounds(300, 400, 150, 30);
        listButton.addActionListener(e -> updateDisplay());
        panel.add(listButton);

        frame.setVisible(true);
        updateDisplay();
    }

    private void updateDisplay() {
        displayArea.setText("");
        stockControl.getProducts().forEach(product -> displayArea.append(product + "\n")); // Lambda ile listeleme
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StockControlSystemGUI::new);
    }
}
