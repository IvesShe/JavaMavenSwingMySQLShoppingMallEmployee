package controller.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.product.ProductAddUI;
import controller.product.ProductManagerUI;
import controller.shopOrder.ShopOrderManagerUI;
import model.Employee;
import util.FileUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class EmployeeMainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Employee employee = (Employee)FileUtils.read("employee.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMainUI frame = new EmployeeMainUI();
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
	public EmployeeMainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 10, 416, 60);
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("員工管理主頁");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_4.setBounds(104, 10, 201, 40);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(10, 77, 416, 287);
		contentPane.add(panel_1);
		
		JButton btnManager = new JButton("管理員工");
		btnManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EmployeeManagerUI().setVisible(true);
				dispose();
			}
		});
		btnManager.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnManager.setBounds(217, 16, 134, 41);
		panel_1.add(btnManager);
		
		JButton btnAdd = new JButton("新增員工");
		btnAdd.setBounds(56, 16, 134, 41);
		panel_1.add(btnAdd);
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
				new EmployeeAddUI().setVisible(true);
				dispose();
			}
		});
		btnAdd.setFont(new Font("新細明體", Font.PLAIN, 20));
		
		JButton btnLogout = new JButton("登出");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new EmployeeLoginUI().setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(139, 199, 134, 41);
		panel_1.add(btnLogout);
		btnLogout.setFont(new Font("新細明體", Font.PLAIN, 20));
		
		JLabel lblMemberName = new JLabel("用戶: <dynamic>");
		lblMemberName.setText("用戶: "+employee.getName());
		lblMemberName.setFont(new Font("新細明體", Font.BOLD, 18));
		lblMemberName.setBounds(6, 254, 298, 23);
		panel_1.add(lblMemberName);
		
		JButton btnAdd_1 = new JButton("新增產品");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ProductAddUI().setVisible(true);
				dispose();
			}
		});
		btnAdd_1.setBounds(56, 77, 134, 41);
		panel_1.add(btnAdd_1);
		btnAdd_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		
		JButton btnManager_1 = new JButton("修改產品資料");
		btnManager_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ProductManagerUI().setVisible(true);
				dispose();
			}
		});
		btnManager_1.setBounds(217, 77, 134, 41);
		panel_1.add(btnManager_1);
		btnManager_1.setFont(new Font("新細明體", Font.PLAIN, 14));
		
		JButton btnManager_1_1 = new JButton("修改訂單");
		btnManager_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ShopOrderManagerUI().setVisible(true);
				dispose();
			}
		});
		btnManager_1_1.setBounds(139, 139, 134, 41);
		panel_1.add(btnManager_1_1);
		btnManager_1_1.setFont(new Font("新細明體", Font.PLAIN, 20));
	}
}
