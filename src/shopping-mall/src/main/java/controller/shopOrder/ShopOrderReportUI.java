package controller.shopOrder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.app.AppMainUI;
import model.Consumer;
import model.Employee;
import model.ViewShopOrderReport;
import service.impl.ViewShopOrderReportServiceImpl;
import util.FileUtils;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ShopOrderReportUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ViewShopOrderReportServiceImpl viewShopOrderReportServiceImpl = new ViewShopOrderReportServiceImpl();
	private Employee employee = (Employee)FileUtils.read("employee.txt");
	private Consumer consumer = (Consumer)FileUtils.read("consumer.txt");
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopOrderReportUI frame = new ShopOrderReportUI();
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
	public ShopOrderReportUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 10, 822, 60);
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("訂單詳細報表");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 30));
		lblNewLabel_4.setBounds(344, 10, 193, 40);
		panel.add(lblNewLabel_4);
		
		JButton btnBack = new JButton("回訂單管理");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new ShopOrderManagerUI().setVisible(true);
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
		
		JLabel lblNewLabel_3 = new JLabel("查詢訂單詳細報表");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_3.setBounds(25, 10, 174, 23);
		panel_1_1.add(lblNewLabel_3);
		
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
				
				List<ViewShopOrderReport> viewShopOrderReportList = new ArrayList<>();
				String noTemp = AppMainUI.getIsEmployee()? employee.getEmployeeNo():consumer.getConsumerNo();
//				if(!name.equals("admin")) 
//				{	// 一般帳號只能查到自己的資料
////					textAreaOutput.setText(shopOrderServiceImpl.findByUsername(shopOrder.getUsername()));
//					viewShopOrderReportList = shopOrderServiceImpl.findByShop(name);
//					
//				}
//				else
//				{	// admin帳號可以查到所有的資料
////					textAreaOutput.setText(shopOrderServiceImpl.AllShopOrder());
//					viewShopOrderReportList = shopOrderServiceImpl.findAllShopOrder();
//					
//				}
//				viewShopOrderReportList = shopOrderServiceImpl.findAllShopOrder();
				// 顧客只能查到自己的訂單
				if(!AppMainUI.getIsEmployee()) 
				{
//					if(AppMainUI.getIsEmployee())
//					{
//						viewShopOrderReportList = shopOrderServiceImpl.findByEmployeeNo(noTemp);
//					}
//					else
//					{
					viewShopOrderReportList = viewShopOrderReportServiceImpl.findByConsumerNo(noTemp);
//					}
				}
				else {
					// 員工可以查到所有的訂單
					viewShopOrderReportList = viewShopOrderReportServiceImpl.findAllViewShopOrderReport();
				}
//				viewShopOrderReportList = viewShopOrderReportServiceImpl.findAllViewShopOrderReport();
				System.out.println(viewShopOrderReportList);
				if(viewShopOrderReportList==null) {
					JOptionPane.showMessageDialog(null,  "查無資料", "完成",
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				loadTableData(viewShopOrderReportList);
//				List<ShopOrder> viewShopOrderReportList = shopOrderServiceImpl.findAllShopOrder();
	
				
				JOptionPane.showMessageDialog(null,  "查詢成功", "完成",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSelect.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnSelect.setBounds(220, 10, 165, 23);
		panel_1_1.add(btnSelect);
		
		
		// JTable輸出	
		// 表格標題
        String[] columnNames = {"訂單編號", "顧客編號", "顧客姓名","電話", "地址" ,"服務人員", "產品名稱" ,"數量","產品售價","銷售金額"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        
        // 設定欄位寬度
        table.getColumnModel().getColumn(0).setPreferredWidth(180);  // 
        table.getColumnModel().getColumn(1).setPreferredWidth(80);  // 
        table.getColumnModel().getColumn(2).setPreferredWidth(180); // 
        table.getColumnModel().getColumn(3).setPreferredWidth(120); // 
        table.getColumnModel().getColumn(4).setPreferredWidth(150); // 
        table.getColumnModel().getColumn(5).setPreferredWidth(120); // 
        table.getColumnModel().getColumn(6).setPreferredWidth(200); // 
        table.getColumnModel().getColumn(7).setPreferredWidth(60); 
        table.getColumnModel().getColumn(8).setPreferredWidth(100); 
        table.getColumnModel().getColumn(9).setPreferredWidth(100); 
        
        // 設定表格不可編輯
        table.setDefaultEditor(Object.class, null);               

        // 加入 JScrollPane（滾動條）
        JScrollPane scrollPaneTable = new JScrollPane(table);
        scrollPaneTable.setBounds(12, 45, 795, 200);
        panel_1_1.add(scrollPaneTable, BorderLayout.CENTER);
     
	}
	
    
	// 載入 List 到 JTable
    private void loadTableData(List<ViewShopOrderReport> viewShopOrderReport) {
        model.setRowCount(0); // 清空表格
        for (ViewShopOrderReport v : viewShopOrderReport) {
            model.addRow(new Object[]{
               
                v.getShopOrderNo(),
                v.getConsumerNo(),
                v.getConsumerName(),
                v.getPhone(),
                v.getAddress(),
                v.getEmployeeName(),
                v.getProductName(),
                v.getAmount(),
                v.getPrice(),
              
                v.getTotoal()
            });
        }
    }
}
