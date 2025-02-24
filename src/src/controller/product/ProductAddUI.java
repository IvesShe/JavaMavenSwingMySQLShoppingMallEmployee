package controller.product;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.app.AppMainUI;
import controller.consumer.ConsumerMainUI;
import controller.employee.EmployeeMainUI;
import model.Consumer;
import model.Employee;
import model.Product;
import service.impl.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import util.*;

public class ProductAddUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textVerificationCode;
	private String verificationCode;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JTextField textFieldProductNo;
	private Employee employee = (Employee)FileUtils.read("employee.txt");
	private Consumer consumer = (Consumer)FileUtils.read("consumer.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductAddUI frame = new ProductAddUI();
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
	public ProductAddUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);//
		contentPane.setLayout(null);
	

		// 產生驗證碼
		verificationCode = Tool.generateRandomCode();

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(0, 1, 854, 89);
		contentPane.add(panel);

		JLabel lblNewLabel_2 = new JLabel("新增產品");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_2.setBounds(314, 12, 142, 64);
		panel.add(lblNewLabel_2);
		
		JLabel lblTimer = new JLabel("");
		lblTimer.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimer.setForeground(Color.WHITE);
		lblTimer.setFont(new Font("新細明體", Font.BOLD, 20));
		lblTimer.setBounds(537, 22, 425, 38);
		panel.add(lblTimer);

		JButton btnAdd = new JButton("新增");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String inputVerificationCode = textVerificationCode.getText();
				String productNo = textFieldProductNo.getText();
				String name = textFieldName.getText();

				
				// 檢查驗證碼(忽略大小寫)
				if (!inputVerificationCode.equalsIgnoreCase(verificationCode)) {
					// 驗證碼錯誤
					JOptionPane.showMessageDialog(null, inputVerificationCode+" 驗證碼錯誤，請重新輸入。 "+verificationCode, "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// 使用正則檢查帳號是否符合規則
				String valMessage =null;
				
				valMessage = Tool.validateProductNo(productNo);
				if(!valMessage.equals("true")) {
					JOptionPane.showMessageDialog(null, valMessage, "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				if(new ProductServiceImpl().isProductNoBeenUse(productNo))
				{	// 產品編號已被使用
					JOptionPane.showMessageDialog(null, "產品編號已存在，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else if(new ProductServiceImpl().isNameBeenUse(name))
				{	// 帳號已被使用
					JOptionPane.showMessageDialog(null, "品名已存在，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}				
				else
				{					
					Integer price = Integer.parseInt(textFieldPrice.getText());
					
					Product product = new Product(productNo,name,price);
					new ProductServiceImpl().addProduct(product);					
	
					JOptionPane.showMessageDialog(null,name + "新增成功。", "完成",
							JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnAdd.setFont(new Font("新細明體", Font.BOLD, 40));
		btnAdd.setBounds(116, 377, 214, 68);
		contentPane.add(btnAdd);

		JButton btnClear = new JButton("清除");
		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldName.setText("");
				textFieldPrice.setText("");
				textVerificationCode.setText("");
				textFieldProductNo.setText("");
			
			}
		});
		btnClear.setFont(new Font("新細明體", Font.BOLD, 40));
		btnClear.setBounds(387, 377, 214, 68);
		contentPane.add(btnClear);

		

		JLabel lblNewLabel_1_1 = new JLabel("驗證碼：");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(218, 288, 90, 68);
		contentPane.add(lblNewLabel_1_1);

		textVerificationCode = new JTextField();
		textVerificationCode.setFont(new Font("新細明體", Font.BOLD, 20));
		textVerificationCode.setColumns(10);
		textVerificationCode.setBounds(308, 297, 208, 44);
		contentPane.add(textVerificationCode);

		// 驗證碼
		JLabel lblVerificationCode = new JLabel(verificationCode);
		lblVerificationCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 產生新的驗證碼
				verificationCode = Tool.generateRandomCode();
				lblVerificationCode.setText(verificationCode);
			}
		});
		lblVerificationCode.setForeground(new Color(255, 128, 0));
		lblVerificationCode.setFont(new Font("新細明體", Font.BOLD, 40));
		lblVerificationCode.setBounds(552, 284, 201, 68);
		contentPane.add(lblVerificationCode);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("點擊驗證碼可產生新的驗證碼，不分大小寫");
		lblNewLabel_1_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(242, 460, 414, 50);
		contentPane.add(lblNewLabel_1_1_1);
		
		// 啟動clock
		Clock.startAutoUpdateClock(lblTimer);
		
		JLabel lblMemberName = new JLabel("用戶: <dynamic>");
		lblMemberName.setForeground(new Color(255, 255, 255));
		lblMemberName.setBounds(14, 30, 298, 23);
		panel.add(lblMemberName);
		String name = AppMainUI.getIsEmployee()? employee.getName():consumer.getName();
		lblMemberName.setText("用戶: "+name);
		lblMemberName.setFont(new Font("新細明體", Font.BOLD, 18));
		
		JLabel lblNewLabel_1_4 = new JLabel("售價：");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(230, 217, 77, 68);
		contentPane.add(lblNewLabel_1_4);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Dialog", Font.PLAIN, 20));
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(310, 224, 205, 46);
		contentPane.add(textFieldPrice);
		
		JLabel lblNewLabel_1_2 = new JLabel("品名：");
		lblNewLabel_1_2.setBounds(232, 138, 77, 68);
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		textFieldName = new JTextField();
		textFieldName.setBounds(310, 154, 208, 46);
		contentPane.add(textFieldName);
		textFieldName.setFont(new Font("Dialog", Font.PLAIN, 20));
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("編號：");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(232, 71, 77, 68);
		contentPane.add(lblNewLabel_1_2_1);
		
		textFieldProductNo = new JTextField();
		textFieldProductNo.setFont(new Font("Dialog", Font.PLAIN, 20));
		textFieldProductNo.setColumns(10);
		textFieldProductNo.setBounds(310, 87, 208, 46);
		contentPane.add(textFieldProductNo);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("格式：p005~p999");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1_1_1_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(534, 85, 193, 50);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JButton btnGoto = new JButton("前往管理主頁");
		btnGoto.addMouseListener(new MouseAdapter() {
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
		btnGoto.setFont(new Font("新細明體", Font.BOLD, 20));
		btnGoto.setBounds(634, 377, 177, 50);
		contentPane.add(btnGoto);

	}
}
