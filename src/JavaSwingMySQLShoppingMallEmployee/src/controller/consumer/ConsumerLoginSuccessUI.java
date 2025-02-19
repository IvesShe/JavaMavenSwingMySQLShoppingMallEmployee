package controller.consumer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.shopOrder.ShopOrderMainUI;
import model.Consumer;
import model.Employee;
import util.FileUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ConsumerLoginSuccessUI extends JFrame {

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
					ConsumerLoginSuccessUI frame = new ConsumerLoginSuccessUI();
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
	public ConsumerLoginSuccessUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登入成功");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(160, 51, 110, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblShowMessage = new JLabel("");
		lblShowMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowMessage.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblShowMessage.setBounds(10, 89, 392, 69);
		contentPane.add(lblShowMessage);
		
		lblShowMessage.setText(consumer.getName()+" 歡迎您回來！");
		
		JButton btnGoPorder = new JButton("進入顧客管理");
		btnGoPorder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ConsumerMainUI().setVisible(true);
				dispose();
			}
		});
		btnGoPorder.setFont(new Font("新細明體", Font.PLAIN, 20));
		btnGoPorder.setBounds(123, 167, 170, 31);
		contentPane.add(btnGoPorder);
	}

}
