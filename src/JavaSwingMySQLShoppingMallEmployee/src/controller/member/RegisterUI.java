package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

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

public class RegisterUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private static String appTitle = "肯德德購物";
	private JTextField textVerificationCode;
	private String verificationCode;
	private JTextField textFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldPhone;
	private JTextField textFieldMobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterUI frame = new RegisterUI();
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
	public RegisterUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 748);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle(appTitle + " 註冊");

		setContentPane(contentPane);//
		contentPane.setLayout(null);
	

		// 產生驗證碼
		verificationCode = Tool.generateRandomCode();

		JLabel lblNewLabel = new JLabel("帳號：");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel.setBounds(230, 157, 77, 68);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("密碼：");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(230, 229, 77, 68);
		contentPane.add(lblNewLabel_1);

		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Dialog", Font.PLAIN, 20));
		textFieldUsername.setBounds(310, 172, 208, 44);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		textFieldPassword = new JTextField();
		textFieldPassword.setFont(new Font("Dialog", Font.PLAIN, 20));
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(310, 245, 205, 46);
		contentPane.add(textFieldPassword);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 1, 854, 89);
		contentPane.add(panel);

		JLabel lblNewLabel_2 = new JLabel("肯德德購物 註冊畫面");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_2.setBounds(236, 12, 399, 64);
		panel.add(lblNewLabel_2);
		
		JLabel lblTimer = new JLabel("");
		lblTimer.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimer.setForeground(Color.WHITE);
		lblTimer.setFont(new Font("新細明體", Font.BOLD, 20));
		lblTimer.setBounds(537, 22, 425, 38);
		panel.add(lblTimer);

		JButton btnNewButton = new JButton("註冊");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String username = textFieldUsername.getText();
				String password = textFieldPassword.getText();
				String inputVerificationCode = textVerificationCode.getText();

				// 輸入不能為空
				if (username.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "輸入值不能為空，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// 檢查驗證碼(忽略大小寫)
				if (!inputVerificationCode.equalsIgnoreCase(verificationCode)) {
					// 驗證碼錯誤
					JOptionPane.showMessageDialog(null, inputVerificationCode+" 驗證碼錯誤，請重新輸入。 "+verificationCode, "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				// 使用正則檢查帳號是否符合規則
				String valMessage = Tool.validateUsername(username);
				if(!valMessage.equals("true")) {
					JOptionPane.showMessageDialog(null, valMessage, "錯誤", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
//				username = textFieldUsername.getText();
				
				if(new MemberServiceImpl().isUsernameBeenUse(username))
				{	// 帳號已被使用
					AddMemberErrorUI addMemberErrorUI = new AddMemberErrorUI();
					addMemberErrorUI.setVisible(true);
					dispose();
				}
				else
				{
					String name = textFieldName.getText();
					String address = textFieldAddress.getText();
					String phone = textFieldPhone.getText();
					String mobile = textFieldMobile.getText();
					
					Member member = new Member(name,username,password,address,phone,mobile);
					new MemberServiceImpl().addMember(member);
					
//					
					JOptionPane.showMessageDialog(null, username + "註冊成功，將前往登入畫面。", "完成",
							JOptionPane.INFORMATION_MESSAGE);
					new LoginUI().setVisible(true);
					dispose(); 
//					AddMemberSuccessUI addMemberSuccessUI = new AddMemberSuccessUI();
//					addMemberSuccessUI.setVisible(true);
//					dispose();
					
				}

				//try {
//				Member member = new MemberServiceImpl().Login(username, password);
//				if (member!=null) {
////						JOptionPane.showMessageDialog(null, "帳號已存在，請重新輸入。", "錯誤", JOptionPane.ERROR_MESSAGE);
//					
//					new AddMemberErrorUI().setVisible(true);
//					return;
//				} else {
//					JOptionPane.showMessageDialog(null, username + "註冊成功，將前往登入畫面。", "完成",
//							JOptionPane.INFORMATION_MESSAGE);
//					new AddMemberSuccessUI().setVisible(true);
//					dispose(); // 關閉登入視窗
//				}
				//} 
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 40));
		btnNewButton.setBounds(116, 604, 214, 68);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("清除");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldUsername.setText("");
				textFieldPassword.setText("");
				textFieldName.setText("");
				textFieldAddress.setText("");
				textFieldPhone.setText("");
				textFieldMobile.setText("");
				textVerificationCode.setText("");
			
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 40));
		btnNewButton_1.setBounds(387, 604, 214, 68);
		contentPane.add(btnNewButton_1);

		JButton btnLogin = new JButton("前往登入");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginUI().setVisible(true);
				dispose(); // 關閉登入視窗
			}
		});
		btnLogin.setFont(new Font("新細明體", Font.BOLD, 30));
		btnLogin.setBounds(630, 605, 177, 50);
		contentPane.add(btnLogin);

		JLabel lblNewLabel_1_1 = new JLabel("驗證碼：");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(218, 526, 90, 68);
		contentPane.add(lblNewLabel_1_1);

		textVerificationCode = new JTextField();
		textVerificationCode.setFont(new Font("新細明體", Font.BOLD, 20));
		textVerificationCode.setColumns(10);
		textVerificationCode.setBounds(308, 535, 208, 44);
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
		lblVerificationCode.setBounds(552, 526, 201, 68);
		contentPane.add(lblVerificationCode);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("點擊驗證碼可產生新的驗證碼，不分大小寫");
		lblNewLabel_1_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(248, 665, 414, 50);
		contentPane.add(lblNewLabel_1_1_1);
		
		// 啟動clock
		Clock.startAutoUpdateClock(lblTimer);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("帳號首字母需英文，長度最少5個字、最長12個字，只能包含英文字母和數字");
		lblNewLabel_1_1_1_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1_1_1_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(145, 128, 726, 50);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("地址：");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(230, 301, 77, 68);
		contentPane.add(lblNewLabel_1_3);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Dialog", Font.PLAIN, 20));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(310, 317, 205, 46);
		contentPane.add(textFieldAddress);
		
		JLabel lblNewLabel_1_4 = new JLabel("電話：");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(230, 373, 77, 68);
		contentPane.add(lblNewLabel_1_4);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Dialog", Font.PLAIN, 20));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(310, 389, 205, 46);
		contentPane.add(textFieldPhone);
		
		JLabel lblNewLabel_1_5 = new JLabel("手機：");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(230, 448, 77, 68);
		contentPane.add(lblNewLabel_1_5);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setFont(new Font("Dialog", Font.PLAIN, 20));
		textFieldMobile.setColumns(10);
		textFieldMobile.setBounds(310, 464, 205, 46);
		contentPane.add(textFieldMobile);
		
		JLabel lblNewLabel_1_2 = new JLabel("姓名：");
		lblNewLabel_1_2.setBounds(232, 70, 77, 68);
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		textFieldName = new JTextField();
		textFieldName.setBounds(310, 86, 205, 46);
		contentPane.add(textFieldName);
		textFieldName.setFont(new Font("Dialog", Font.PLAIN, 20));
		textFieldName.setColumns(10);

	}
}
