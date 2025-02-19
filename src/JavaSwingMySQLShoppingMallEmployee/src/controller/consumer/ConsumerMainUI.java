package controller.consumer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.LoginUI;
import model.Consumer;
import util.FileUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;

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
		
		JLabel lblNewLabel_4 = new JLabel("管理主頁");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_4.setBounds(141, 10, 158, 40);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setBounds(10, 77, 416, 232);
		contentPane.add(panel_1);
		
		JButton btnManager = new JButton("管理");
		btnManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ConsumerManagerUI().setVisible(true);
				dispose();
			}
		});
		btnManager.setFont(new Font("新細明體", Font.PLAIN, 30));
		btnManager.setBounds(139, 79, 134, 41);
		panel_1.add(btnManager);
		
		JButton btnAdd = new JButton("新增");
		btnAdd.setBounds(139, 17, 134, 41);
		panel_1.add(btnAdd);
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ConsumerAddUI().setVisible(true);
				dispose();
			}
		});
		btnAdd.setFont(new Font("新細明體", Font.PLAIN, 30));
		
		JButton btnLogout = new JButton("登出");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ConsumerLoginUI().setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(139, 141, 134, 41);
		panel_1.add(btnLogout);
		btnLogout.setFont(new Font("新細明體", Font.PLAIN, 30));
		
		JLabel lblMemberName = new JLabel("用戶: <dynamic>");
		lblMemberName.setText("用戶: "+consumer.getName());
		lblMemberName.setFont(new Font("新細明體", Font.BOLD, 18));
		lblMemberName.setBounds(6, 199, 298, 23);
		panel_1.add(lblMemberName);
	}
}
