package controller.shopOrder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.app.AppMainUI;
import controller.consumer.ConsumerLoginUI;
import controller.consumer.ConsumerMainUI;
import controller.employee.EmployeeLoginUI;
import controller.employee.EmployeeMainUI;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

import util.*;
import model.*;
import service.impl.EmployeeServiceImpl;
import service.impl.ProductServiceImpl;
import service.impl.ShopOrderServiceImpl;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ShopOrderAddUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textFieldMeal1;
	private JTextField textReceivedAmount;
	private String outputText;
	private Employee employee = (Employee)FileUtils.read("employee.txt");
	private Consumer consumer = (Consumer)FileUtils.read("consumer.txt");
	private static ShopOrderServiceImpl shopOrderServiceImpl = new ShopOrderServiceImpl();
	private static EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
	private static ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	private List<String> productMenuList = new ArrayList<>();
	private List<String> employeeMenuList = new ArrayList<>();
	private JList<String> jListProductList;
	private JList<String> jListEmployeeList;
	private static String selectedProduct=null;
	private static String selectedEmployee=null;
	Map<String, Integer> allProductMap = new HashMap<>();
	Map<String, String> allProductNoMap = new HashMap<>();
	Map<String, String> allEmployeeMap = new HashMap<>();
	Map<String, String> allEmployeeNoMap = new HashMap<>();
	
	ShopOrder o = null;
	public ShopOrderAddUI self = this;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopOrderAddUI frame = new ShopOrderAddUI();
					frame.setVisible(true);								
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 處理確認訂單
	 */
	private void handlerOK(JTextArea output,JCheckBox vipMember){		
		String Name = textName.getText();
		String mealNo1Price = textFieldMeal1.getText();
		output.setText("");

		if (Name.isEmpty()) {
			output.setText("名字不能為空，請重新輸入。");
			JOptionPane.showMessageDialog(null, "名字不能為空，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// 空值自動補0
		if (mealNo1Price.isEmpty()) {
			mealNo1Price = "0";
			textFieldMeal1.setText("0");
		}

//		o = new ShopOrder(Name, Integer.parseInt(mealNo1Price),
//				Integer.parseInt(mealNo2Price));
		String showOrder = o.showOrder(vipMember.isSelected());
		outputText = showOrder;
		output.setText(showOrder);	
	}
		

	// 從數據庫 獲取產品資料
	private void getProductData()
	{
		List<Product> allProduct = productServiceImpl.findAllProduct();		
		
		for(Product p:allProduct)
		{
			productMenuList.add(p.getName());
			allProductMap.put(p.getName(), p.getPrice());
			allProductNoMap.put(p.getName(), p.getProductNo());
		}
		jListProductList.setListData(productMenuList.toArray(new String[0]));
		
		for(String p:productMenuList)
		{
			System.out.println("productName:"+p+"\n");
		}
	}
	
	// 從數據庫 獲取服務人員 員工資料
	private void getEmployeeData()
	{
		List<Employee> allEmployee = employeeServiceImpl.findAllEmployee();
		for(Employee e:allEmployee)
		{
			employeeMenuList.add(e.getUsername());
			allEmployeeMap.put(e.getUsername(), e.getName());
			allEmployeeNoMap.put(e.getUsername(), e.getEmployeeNo());
		}
		jListEmployeeList.setListData(employeeMenuList.toArray(new String[0]));
		
		for(String e:employeeMenuList)
		{
			System.out.println("employeeName:"+e+"\n");
		}
	}
	
	
	
	
	/**
	 * Create the frame.
	 */
	public ShopOrderAddUI() {
		// panel載入時事件
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// 從數據庫 獲取JList資料
				self.getProductData();
				self.getEmployeeData();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1218, 604);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_Top = new JPanel();
		panel_Top.setBackground(new Color(128, 128, 128));
		panel_Top.setBounds(20, -25, 1192, 117);
		contentPane.add(panel_Top);
		panel_Top.setLayout(null);

		JLabel lblNewLabel = new JLabel("購物畫面");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 32));
		lblNewLabel.setBounds(436, 38, 179, 64);
		panel_Top.add(lblNewLabel);

		JPanel panel_Left = new JPanel();
		panel_Left.setLayout(null);
		panel_Left.setBackground(new Color(128, 128, 128));
		panel_Left.setBounds(43, 87, 661, 455);
		contentPane.add(panel_Left);

		JLabel lblNewLabel_1 = new JLabel("姓名：");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_1.setBounds(30, 13, 105, 38);
		panel_Left.add(lblNewLabel_1);

		textName = new JTextField();
		String name = AppMainUI.getIsEmployee()? employee.getName():consumer.getName();
		textName.setText(name);
		textName.setEnabled(false);
		textName.setHorizontalAlignment(SwingConstants.CENTER);
		textName.setFont(new Font("新細明體", Font.BOLD, 20));
		textName.setBounds(149, 10, 254, 42);
		panel_Left.add(textName);
		textName.setColumns(10);

		textFieldMeal1 = new JTextField();
		textFieldMeal1.setText("1");
		textFieldMeal1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMeal1.setFont(new Font("新細明體", Font.BOLD, 24));
		textFieldMeal1.setColumns(10);
		textFieldMeal1.setBounds(104, 379, 106, 52);
		panel_Left.add(textFieldMeal1);

		JPanel panel_Right = new JPanel();
		panel_Right.setLayout(null);
		panel_Right.setBackground(new Color(128, 128, 128));
		panel_Right.setBounds(703, 66, 488, 373);
		contentPane.add(panel_Right);

//		JLabel lblMealNo1Price = new JLabel(ShopOrder.getMealNo1Price() + "/份");
//		lblMealNo1Price.setForeground(new Color(0, 0, 255));
//		lblMealNo1Price.setFont(new Font("新細明體", Font.BOLD, 20));
//		lblMealNo1Price.setBounds(32, 155, 105, 38);
//		panel_1.add(lblMealNo1Price);
//
//		JLabel lblMealNo2Price = new JLabel(ShopOrder.getMealNo2Price() + "/份");
//		lblMealNo2Price.setForeground(new Color(0, 0, 255));
//		lblMealNo2Price.setFont(new Font("新細明體", Font.BOLD, 20));
//		lblMealNo2Price.setBounds(30, 264, 105, 38);
//		panel_1.add(lblMealNo2Price);
		
		JTextArea textAreaOutput = new JTextArea();
		textAreaOutput.setBounds(23, 24, 295, 340);
		panel_Right.add(textAreaOutput);
		
		// 是否為VIP會員 按鍵
		JCheckBox vipMember = new JCheckBox("是否為VIP會員");
		vipMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 若訂單已成立，數據有變動，作即時更新
				if(!textAreaOutput.getText().isEmpty()) {
					handlerOK(textAreaOutput,vipMember);	
				}
			}
		});
		vipMember.setBackground(new Color(128, 128, 128));
		vipMember.setForeground(new Color(255, 0, 0));
		vipMember.setFont(new Font("新細明體", Font.BOLD, 30));
		vipMember.setBounds(323, 394, 272, 53);
		panel_Left.add(vipMember);

		textReceivedAmount = new JTextField();
		textReceivedAmount.setHorizontalAlignment(SwingConstants.CENTER);
		textReceivedAmount.setFont(new Font("新細明體", Font.BOLD, 30));
		textReceivedAmount.setColumns(10);
		textReceivedAmount.setBounds(726, 487, 286, 60);
		contentPane.add(textReceivedAmount);

		JLabel lblNewLabel_1_2_2 = new JLabel("請輸入收款金額：");
		lblNewLabel_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_1_2_2.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_2_2.setBounds(727, 444, 290, 38);
		contentPane.add(lblNewLabel_1_2_2);

		// 產品+ 按鍵
		JButton btnMeal1Plus = new JButton("+");
		btnMeal1Plus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mealNo1Price = textFieldMeal1.getText();
				// 空值自動補0、非數字或小於0也補0
				if (mealNo1Price.isEmpty() || !Tool.isNumeric(mealNo1Price)) {
					mealNo1Price = "0";
					textFieldMeal1.setText("0");
				}
				textFieldMeal1.setText(Integer.parseInt(mealNo1Price) + 1 + "");
				
				// 若訂單已成立，數據有變動，作即時更新
				if(!textAreaOutput.getText().isEmpty()) {
					handlerOK(textAreaOutput,vipMember);	
				}
			}
		});
		btnMeal1Plus.setFont(new Font("新細明體", Font.BOLD, 20));
		btnMeal1Plus.setBounds(226, 379, 56, 52);
		panel_Left.add(btnMeal1Plus);

		// 產品- 按鍵
		JButton btnMeal1Sub = new JButton("-");
		btnMeal1Sub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String mealNo1Price = textFieldMeal1.getText();
				// 空值自動補0、非數字或小於0也補0
				if (mealNo1Price.isEmpty() || !Tool.isNumeric(mealNo1Price)) {
					mealNo1Price = "0";
					textFieldMeal1.setText("0");
				}
				Integer count = Integer.parseInt(mealNo1Price) - 1;
				count = count < 0 ? 0 : count;
				textFieldMeal1.setText(count + "");
				
				// 若訂單已成立，數據有變動，作即時更新
				if(!textAreaOutput.getText().isEmpty()) {
					handlerOK(textAreaOutput,vipMember);	
				}
			}
		});
		btnMeal1Sub.setFont(new Font("新細明體", Font.BOLD, 20));
		btnMeal1Sub.setBounds(33, 378, 56, 52);
		panel_Left.add(btnMeal1Sub);
		
		
		
		
		

		// 確定 按鍵
		JButton btnOK = new JButton("確定");
		btnOK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				handlerOK(textAreaOutput,vipMember);			
			}
		});
		btnOK.setFont(new Font("新細明體", Font.BOLD, 20));
		btnOK.setBounds(343, 36, 118, 52);
		panel_Right.add(btnOK);

		// 清除 按鍵
		JButton btnReset = new JButton("清除");
		btnReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//textName.setText("");
				textFieldMeal1.setText("");
				textReceivedAmount.setText("");
				textAreaOutput.setText("");
			}
		});
		btnReset.setFont(new Font("新細明體", Font.BOLD, 20));
		btnReset.setBounds(343, 106, 118, 52);
		panel_Right.add(btnReset);

		// 列印 按鍵
		JButton btnPrint = new JButton("列印");
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					textAreaOutput.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setFont(new Font("新細明體", Font.BOLD, 20));
		btnPrint.setBounds(343, 174, 118, 52);
		panel_Right.add(btnPrint);

		// 離開 按鍵
		JButton btnExit = new JButton("離開");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("新細明體", Font.BOLD, 20));
		btnExit.setBounds(343, 241, 118, 52);
		panel_Right.add(btnExit);		
		
		// 找零 按鍵
		JButton btnChange = new JButton("找零");
		btnChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String receivedAmount = textReceivedAmount.getText();
				int sum = 0;//vipMember.isSelected()? (int)(o.getSum() * 0.9):o.getSum();
				
				if (receivedAmount.isEmpty()) {
					JOptionPane.showMessageDialog(null, "收款金額不能為空，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (textAreaOutput.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "訂單尚未成立，請先建立訂單。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Tool.isNumeric(receivedAmount)) {
					JOptionPane.showMessageDialog(null, "不能輸入非數字或小於0，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Integer.parseInt(receivedAmount) < sum) {
					JOptionPane.showMessageDialog(null, "收款金額小於訂單金額，請收足款項。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				String changeNumber = Tool.changeCalculator(Integer.parseInt(receivedAmount),sum);
				textAreaOutput.setText("");
				textAreaOutput.setText(outputText+"\n"+changeNumber);
			}
		});
		btnChange.setFont(new Font("新細明體", Font.BOLD, 20));
		btnChange.setBounds(1042, 493, 118, 52);
		contentPane.add(btnChange);
		
		// 登出 按鍵
		JButton btnCommit = new JButton("提交訂單");
		btnCommit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 若訂單為空
				if(textAreaOutput.getText().isEmpty()) {
//					handlerOK(textAreaOutput,vipMember);
					JOptionPane.showMessageDialog(null, "請先完成訂單內容。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String name = AppMainUI.getIsEmployee()? employee.getName():consumer.getName();
				
				
				int meal1 = Integer.parseInt(textFieldMeal1.getText());
				
				
				ShopOrder shopOrder = null;//new ShopOrder(name,meal1,meal2);
				
				shopOrderServiceImpl.addShopOrder(shopOrder);
				JOptionPane.showMessageDialog(null,  "提交訂單成功", "完成",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnCommit.setFont(new Font("新細明體", Font.BOLD, 20));
		btnCommit.setBounds(343, 307, 118, 52);
		panel_Right.add(btnCommit);
		
		JButton btnLogout = new JButton("登出");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(AppMainUI.getIsEmployee())
				{
					new EmployeeLoginUI().setVisible(true);
				}
				else
				{
					new ConsumerLoginUI().setVisible(true);
				}
				dispose();
			}
		});
		btnLogout.setFont(new Font("新細明體", Font.BOLD, 20));
		btnLogout.setBounds(1024, 60, 118, 30);
		panel_Top.add(btnLogout);
		
				
		JLabel lblTimer = new JLabel("");
		lblTimer.setBounds(647, 53, 236, 38);
		panel_Top.add(lblTimer);
		lblTimer.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimer.setForeground(new Color(255, 255, 255));
		lblTimer.setFont(new Font("新細明體", Font.BOLD, 20));
		
		// 啟動clock
		Clock.startAutoUpdateClock(lblTimer);
		
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
		btnBack.setFont(new Font("新細明體", Font.BOLD, 20));
		btnBack.setBounds(844, 60, 157, 30);
		panel_Top.add(btnBack);
		
		JLabel lblProductPrice = new JLabel("");
		lblProductPrice.setForeground(Color.WHITE);
		lblProductPrice.setFont(new Font("新細明體", Font.BOLD, 20));
		lblProductPrice.setBounds(104, 327, 175, 38);
		panel_Left.add(lblProductPrice);
		
	
		// 產品列表
//        String[] products = {"鍵盤", "滑鼠", "搖桿", "滑鼠2", "搖桿2", "滑鼠3", "搖桿3"};		
		JScrollPane scrollPane_ProductList = new JScrollPane();
		scrollPane_ProductList.setBounds(31, 113, 254, 201);
		panel_Left.add(scrollPane_ProductList);
		jListProductList = new JList<>(this.productMenuList.toArray(new String[0]));
		jListProductList.setFont(new Font("新細明體", Font.PLAIN, 20));
		scrollPane_ProductList.setViewportView(jListProductList);
		jListProductList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedProduct = jListProductList.getSelectedValue();
                if (selectedProduct != null) {
                    JOptionPane.showMessageDialog(null, 
                        "你選擇了：" + selectedProduct + "\n售價："+allProductMap.get(selectedProduct)+"\n產品編號："+allProductNoMap.get(selectedProduct), 
                        "產品資訊", JOptionPane.INFORMATION_MESSAGE);
//                    lblProductPrice
                    lblProductPrice.setText(allProductMap.get(selectedProduct)+"");
                }
			}
		});
		jListProductList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblNewLabel_1_1 = new JLabel("產品：");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(30, 67, 163, 38);
		panel_Left.add(lblNewLabel_1_1);
		
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("服務人員：");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(334, 68, 163, 38);
		panel_Left.add(lblNewLabel_1_1_1);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(328, 113, 254, 201);
//		panel_1.add(scrollPane);
		
		// 服務人員 員工列表
		JScrollPane scrollPane_EmployeeList = new JScrollPane();
		scrollPane_EmployeeList.setBounds(328, 113, 254, 201);
//		scrollPane_1_1.setViewportView(scrollPane_1_1);
		panel_Left.add(scrollPane_EmployeeList);
		jListEmployeeList = new JList<>(this.employeeMenuList.toArray(new String[0]));
		jListEmployeeList.setFont(new Font("新細明體", Font.PLAIN, 20));
		scrollPane_EmployeeList.setViewportView(jListEmployeeList);
		jListEmployeeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedEmployee = jListEmployeeList.getSelectedValue();
                if (selectedEmployee != null) {
                    JOptionPane.showMessageDialog(null, 
                        "你選擇了：" + selectedEmployee +"\n員工姓名："+allEmployeeMap.get(selectedEmployee)+"\n員工編號："+allEmployeeNoMap.get(selectedEmployee), 
                        "員工資訊", JOptionPane.INFORMATION_MESSAGE);
                }
			}
		});
		jListEmployeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("售價：");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(30, 327, 69, 38);
		panel_Left.add(lblNewLabel_1_1_2);
		
		
	}
}
