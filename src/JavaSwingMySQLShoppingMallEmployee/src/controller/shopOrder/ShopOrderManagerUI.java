package controller.shopOrder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.app.AppMainUI;
import model.Consumer;
import model.Employee;
import model.Member;
import service.impl.ShopOrderServiceImpl;
import util.FileUtils;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class ShopOrderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMeal1;
	private JTextField textFieldMeal2;
	private JTextField textFieldDeleteId;
	private static ShopOrderServiceImpl shopOrderServiceImpl = new ShopOrderServiceImpl();
	private Employee employee = (Employee)FileUtils.read("employee.txt");
	private Consumer consumer = (Consumer)FileUtils.read("consumer.txt");
	private JTextField textFieldUpateId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopOrderManagerUI frame = new ShopOrderManagerUI();
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
	public ShopOrderManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(10, 345, 822, 86);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("修改訂單");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(25, 10, 173, 23);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("1號餐");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(230, 51, 64, 23);
		panel_1.add(lblNewLabel_1);
		
		textFieldMeal1 = new JTextField();
		textFieldMeal1.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldMeal1.setColumns(10);
		textFieldMeal1.setBounds(294, 51, 109, 22);
		panel_1.add(textFieldMeal1);
		
		JLabel lblNewLabel_2 = new JLabel("2號餐");
		lblNewLabel_2.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(435, 51, 64, 23);
		panel_1.add(lblNewLabel_2);
		
		textFieldMeal2 = new JTextField();
		textFieldMeal2.setFont(new Font("新細明體", Font.PLAIN, 18));
		textFieldMeal2.setColumns(10);
		textFieldMeal2.setBounds(499, 51, 109, 23);
		panel_1.add(textFieldMeal2);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 10, 822, 60);
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("管理訂單");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_4.setBounds(344, 10, 193, 40);
		panel.add(lblNewLabel_4);
		
		JButton btnBack = new JButton("回訂單主頁");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ShopOrderMainUI porderMainUI = new ShopOrderMainUI();
				porderMainUI.setVisible(true);
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
		
		JLabel lblNewLabel_3 = new JLabel("查詢訂單");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_3.setBounds(25, 10, 92, 23);
		panel_1_1.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 46, 772, 199);
		panel_1_1.add(scrollPane);
		
		
		JTextArea textAreaOutput = new JTextArea();
		scrollPane.setViewportView(textAreaOutput);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBackground(new Color(128, 128, 128));
		panel_1_2.setBounds(10, 453, 822, 86);
		contentPane.add(panel_1_2);
		
		JLabel lblNewLabel_5 = new JLabel("刪除訂單");
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
		
		JButton btnDelete = new JButton("刪除訂單");
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
				shopOrderServiceImpl.delteShopOrder(id);
				
				JOptionPane.showMessageDialog(null,  "訂單刪除成功", "完成",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDelete.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnDelete.setBounds(249, 51, 119, 23);
		panel_1_2.add(btnDelete);
		
		JButton btnSelect = new JButton("查詢");
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				textAreaOutput.setText(porderServiceImpl.AllPorder());
				
				String name = AppMainUI.getIsEmployee()? employee.getName():consumer.getName();
				if(!name.equals("admin")) 
				{	// 一般帳號只能查到自己的訂單
					textAreaOutput.setText(shopOrderServiceImpl.findByUsername(name));
				}
				else
				{	// admin帳號可以查到所有的訂單
					textAreaOutput.setText(shopOrderServiceImpl.AllShopOrder());
				}
//				
				
				JOptionPane.showMessageDialog(null,  "訂單查詢成功", "完成",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSelect.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnSelect.setBounds(119, 10, 119, 23);
		panel_1_1.add(btnSelect);
		
		JButton btnUpdate = new JButton("修改訂單");
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
				if (textFieldMeal1.getText().isEmpty() && textFieldMeal2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "1號餐與2號餐至少一者有值才需要修改，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}				
				if (!Tool.isNumeric(textFieldMeal1.getText())) {
					JOptionPane.showMessageDialog(null, "1號餐不能輸入非數字或小於0，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (!Tool.isNumeric(textFieldMeal2.getText())) {
					JOptionPane.showMessageDialog(null, "2號餐不能輸入非數字或小於0，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				int id = Integer.parseInt(textFieldUpateId.getText());
				
				
				Integer meal1 = null;
				Integer meal2 = null;
				// meal不為空才取值
				if(!textFieldMeal1.getText().isEmpty())
				{
					meal1 = Integer.parseInt(textFieldMeal1.getText());
				}
				if(!textFieldMeal2.getText().isEmpty())
				{
					meal2 = Integer.parseInt(textFieldMeal2.getText());
				}				
				
				shopOrderServiceImpl.updateShopOrder(meal1, meal2,  id);
				JOptionPane.showMessageDialog(null,  "訂單修改成功", "完成",
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
		
		JLabel lblAdminadmin = new JLabel("一般帳號只能查到自己的訂單, admin帳號可以查到所有的訂單(帳號admin,密碼123)");
		lblAdminadmin.setForeground(new Color(255, 128, 0));
		lblAdminadmin.setBackground(new Color(255, 255, 255));
		lblAdminadmin.setFont(new Font("新細明體", Font.BOLD, 16));
		lblAdminadmin.setBounds(122, 9, 644, 23);
		panel_1.add(lblAdminadmin);
		
	}
}
