package controller.product;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.app.AppMainUI;
import controller.consumer.ConsumerMainUI;
import controller.employee.EmployeeMainUI;
import model.Consumer;
import model.Employee;
import model.Product;
import service.impl.ProductServiceImpl;
import util.FileUtils;
import util.Tool;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProductManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTextField textFieldDeleteId;
	private static ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	private Employee employee = (Employee)FileUtils.read("employee.txt");
	private Consumer consumer = (Consumer)FileUtils.read("consumer.txt");
	private JTextField textFieldUpateId;
	private JTextField textFieldProductNo;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductManagerUI frame = new ProductManagerUI();
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
	public ProductManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(10, 345, 822, 144);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("修改資料");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(25, 10, 173, 23);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("產名");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(230, 51, 64, 23);
		panel_1.add(lblNewLabel_1);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldName.setColumns(10);
		textFieldName.setBounds(294, 51, 109, 22);
		panel_1.add(textFieldName);
		
		JLabel lblNewLabel_2 = new JLabel("售價");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(435, 51, 64, 23);
		panel_1.add(lblNewLabel_2);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(499, 51, 109, 23);
		panel_1.add(textFieldPrice);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 10, 822, 60);
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("產品管理");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_4.setBounds(344, 10, 193, 40);
		panel.add(lblNewLabel_4);
		
		JButton btnBack = new JButton("回管理主頁");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(AppMainUI.getIsEmployee())
				{
					new EmployeeMainUI().setVisible(true);
				}
				else
				{
					new ConsumerMainUI().setVisible(true);
				}
				dispose();
			}
		});
		btnBack.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnBack.setBounds(679, 17, 133, 33);
		panel.add(btnBack);
		
		JLabel lblMemberName = new JLabel("");
		String name = AppMainUI.getIsEmployee()? employee.getName():consumer.getName();
		lblMemberName.setText("用戶: "+name);
		lblMemberName.setFont(new Font("新細明體", Font.BOLD, 18));
		lblMemberName.setBounds(22, 15, 298, 23);
		panel.add(lblMemberName);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(10, 80, 822, 255);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(128, 128, 128));
		
		JLabel lblNewLabel_3 = new JLabel("查詢產品");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_3.setBounds(25, 10, 92, 23);
		panel_1_1.add(lblNewLabel_3);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(128, 128, 128));
		panel_1_2.setBounds(10, 510, 822, 86);
		contentPane.add(panel_1_2);
		
		JLabel lblNewLabel_5 = new JLabel("刪除產品");
		lblNewLabel_5.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_5.setBounds(25, 10, 173, 23);
		panel_1_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_2 = new JLabel("ID");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(25, 51, 64, 23);
		panel_1_2.add(lblNewLabel_1_2);
		
		textFieldDeleteId = new JTextField();
		textFieldDeleteId.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldDeleteId.setColumns(10);
		textFieldDeleteId.setBounds(89, 51, 109, 22);
		panel_1_2.add(textFieldDeleteId);
		
		JButton btnDelete = new JButton("刪除");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if (textFieldDeleteId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID不能為空，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Tool.isNumeric(textFieldDeleteId.getText())) {
					JOptionPane.showMessageDialog(null, "ID不能輸入非數字或小於0，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				int id = Integer.parseInt(textFieldDeleteId.getText());
				Product product = productServiceImpl.findById(id);
				if(product == null) {
					JOptionPane.showMessageDialog(null, "此ID產品不存在，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				productServiceImpl.delteProduct(id);
				
				
				JOptionPane.showMessageDialog(null,  "刪除成功", "完成",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDelete.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnDelete.setBounds(249, 51, 119, 23);
		panel_1_2.add(btnDelete);
		
//		JLabel lblAdmin = new JLabel("admin帳號才有刪除的權限");
//		lblAdmin.setForeground(new Color(255, 128, 0));
//		lblAdmin.setFont(new Font("新細明體", Font.BOLD, 16));
//		lblAdmin.setBackground(Color.WHITE);
//		lblAdmin.setBounds(133, 10, 644, 23);
//		panel_1_2.add(lblAdmin);
		
		JButton btnSelect = new JButton("查詢");
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				List<Product> productList = new ArrayList<>();
				
				productList = productServiceImpl.findAllProduct();
					
				
				loadTableData(productList);
//				List<Product> productList = productServiceImpl.findAllProduct();
	
				
				JOptionPane.showMessageDialog(null,  "查詢成功", "完成",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSelect.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnSelect.setBounds(119, 10, 119, 23);
		panel_1_1.add(btnSelect);
		
		
		
		JButton btnUpdate = new JButton("修改");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (textFieldUpateId.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "ID不能為空，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Tool.isNumeric(textFieldUpateId.getText())) {
					JOptionPane.showMessageDialog(null, "ID不能輸入非數字或小於0，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
//				if (textFieldName.getText().isEmpty() && textFieldPassword.getText().isEmpty()) {
//					JOptionPane.showMessageDialog(null, "1號餐與2號餐至少一者有值才需要修改，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
//					return;
//				}				
//				if (!Tool.isNumeric(textFieldName.getText())) {
//					JOptionPane.showMessageDialog(null, "1號餐不能輸入非數字或小於0，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
//					return;
//				}
//				if (!Tool.isNumeric(textFieldPassword.getText())) {
//					JOptionPane.showMessageDialog(null, "2號餐不能輸入非數字或小於0，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
//					return;
//				}
				
				int id = Integer.parseInt(textFieldUpateId.getText());
				Product product = productServiceImpl.findById(id);
				if(product == null) {
					JOptionPane.showMessageDialog(null, "此ID員工不存在，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String name = null;
				String productNo = null;
				Integer price = null;					

				// 不為空才取值
				if(!textFieldName.getText().isEmpty())
				{
					name = textFieldName.getText();
					product.setName(name);
				}
				if(!textFieldProductNo.getText().isEmpty())
				{
					productNo = textFieldProductNo.getText();
					String valMessage = Tool.validateProductNo(productNo);
					if(!valMessage.equals("true")) {
						JOptionPane.showMessageDialog(null, valMessage, "錯誤", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					if(new ProductServiceImpl().isProductNoBeenUse(productNo))
					{	// 員工編號已被使用
						JOptionPane.showMessageDialog(null, "顧客編號已存在，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
						return;
					}
					product.setProductNo(productNo);
				}				
				
				if(!textFieldPrice.getText().isEmpty())
				{	
					
					price = Integer.parseInt(textFieldPrice.getText());
					product.setPrice(price);
				}		
				
				productServiceImpl.updateProduct(product);
				
				
				JOptionPane.showMessageDialog(null,  "修改成功", "完成",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnUpdate.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnUpdate.setBounds(653, 51, 119, 23);
		panel_1.add(btnUpdate);
		
		JLabel lblNewLabel_1_3 = new JLabel("ID");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(25, 51, 64, 23);
		panel_1.add(lblNewLabel_1_3);
		
		textFieldUpateId = new JTextField();
		textFieldUpateId.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldUpateId.setColumns(10);
		textFieldUpateId.setBounds(89, 51, 109, 22);
		panel_1.add(textFieldUpateId);
				
		textFieldProductNo = new JTextField();
		textFieldProductNo.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldProductNo.setColumns(10);
		textFieldProductNo.setBounds(89, 89, 109, 22);
		panel_1.add(textFieldProductNo);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("編號");
		lblNewLabel_1_3_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(25, 89, 64, 23);
		panel_1.add(lblNewLabel_1_3_1);
		
		
		// JTable輸出		
		// 表格標題
        String[] columnNames = {"ID", "編號", "產名", "售價", "修改時間", "建立時間"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        
        // 設定欄位寬度
        table.getColumnModel().getColumn(0).setPreferredWidth(40);  // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(60);  // 編號
        table.getColumnModel().getColumn(2).setPreferredWidth(120); // 產名
        table.getColumnModel().getColumn(3).setPreferredWidth(120); // 售價
        table.getColumnModel().getColumn(4).setPreferredWidth(200); // 
        table.getColumnModel().getColumn(5).setPreferredWidth(200); // 
        
        // 設定表格不可編輯
        table.setDefaultEditor(Object.class, null);               

        // 加入 JScrollPane（滾動條）
        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setBounds(12, 45, 795, 200);
        panel_1_1.add(scrollPaneTable, BorderLayout.CENTER);               
     
	}
	
    
	// 載入 List 到 JTable
    private void loadTableData(List<Product> products) {
        model.setRowCount(0); // 清空表格
        for (Product e : products) {
            model.addRow(new Object[]{
                e.getId(),
                e.getProductNo(),
                e.getName(),
                e.getPrice(),
                Tool.formatTimestamp(e.getCreatedAt()),
                Tool.formatTimestamp(e.getUpdatedAt())
            });
        }
    }
}
