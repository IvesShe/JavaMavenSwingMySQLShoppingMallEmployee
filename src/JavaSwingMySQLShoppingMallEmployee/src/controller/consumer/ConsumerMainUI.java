package controller.consumer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.shopOrder.ShopOrderAddUI;
import controller.shopOrder.ShopOrderManagerUI;
import model.Consumer;
import util.FileUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ConsumerMainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Consumer consumer = (Consumer)FileUtils.read("consumer.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsumerMainUI frame = new ConsumerMainUI();
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
	public ConsumerMainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 358);
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
		
		JLabel lblNewLabel_4 = new JLabel("顧客管理主頁");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_4.setBounds(109, 10, 193, 40);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(10, 77, 416, 232);
		contentPane.add(panel_1);
		
		JButton btnManager = new JButton("修改顧客資料");
		btnManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ConsumerManagerUI().setVisible(true);
				dispose();
			}
		});
		btnManager.setFont(new Font("新細明體", Font.PLAIN, 14));
		btnManager.setBounds(139, 16, 134, 41);
		panel_1.add(btnManager);
		
		JButton btnAdd = new JButton("新增顧客");
		btnAdd.setBounds(285, 197, 134, 41);
		btnAdd.setVisible(false);
		panel_1.add(btnAdd);
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!consumer.getUsername().equals("admin")) 
				{	// admin帳號才有刪除的權限
					JOptionPane.showMessageDialog(null, "此帳號無權限新增，需管理員權限。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				new ConsumerAddUI().setVisible(true);
				dispose();
			}
		});
		btnAdd.setFont(new Font("新細明體", Font.PLAIN, 20));
		
		JButton btnLogout = new JButton("登出");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ConsumerLoginUI().setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(139, 145, 134, 41);
		panel_1.add(btnLogout);
		btnLogout.setFont(new Font("新細明體", Font.PLAIN, 20));
		
		JLabel lblMemberName = new JLabel("用戶: <dynamic>");
		lblMemberName.setText("用戶: "+consumer.getName());
		lblMemberName.setFont(new Font("新細明體", Font.BOLD, 18));
		lblMemberName.setBounds(6, 199, 298, 23);
		panel_1.add(lblMemberName);
		
		JButton btnAdd_1 = new JButton("新增訂單");
		btnAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ShopOrderAddUI().setVisible(true);
				dispose();
			}
		});
		btnAdd_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnAdd_1.setBounds(56, 81, 134, 41);
		
		panel_1.add(btnAdd_1);
		
		JButton btnManager_1 = new JButton("修改訂單");
		btnManager_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ShopOrderManagerUI().setVisible(true);
				dispose();
			}
		});
		btnManager_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnManager_1.setBounds(212, 81, 134, 41);
		panel_1.add(btnManager_1);
	}
}
