package controller.shopOrder;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JListTest extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> productList;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JListTest frame = new JListTest();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JListTest() {
        setTitle("產品列表");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        
        // **🔹 建立主面板**
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // **🔹 產品列表**
        String[] products = {"鍵盤", "滑鼠", "搖桿"};
        productList = new JList<>(products);
        productList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productList.setBounds(20, 20, 100, 80);

        // **🔹 加入滾動面板**
        JScrollPane scrollPane = new JScrollPane(productList);
        scrollPane.setBounds(20, 20, 120, 80);
        contentPane.add(scrollPane);

        // **🔹 設定選擇事件**
        productList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // 雙擊選項
                    String selectedProduct = productList.getSelectedValue();
                    if (selectedProduct != null) {
                        JOptionPane.showMessageDialog(JListTest.this, 
                            "你選擇了：" + selectedProduct, 
                            "產品資訊", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }
}
