package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



import dao.ShopOrderDao;
import dao.ViewShopOrderReportDao;
import model.ShopOrder;
import model.ViewShopOrderReport;
import util.Tool;

public class ViewShopOrderReportDaoImpl implements ViewShopOrderReportDao {
	
	private static Connection conn = util.DbConnection.getDB();

	public static void main(String[] args) {

		List<ViewShopOrderReport> allSViewShopOrderReport = new ViewShopOrderReportDaoImpl().selectAll();
		for(ViewShopOrderReport viewShopOrderReport:allSViewShopOrderReport)
		{
			System.out.println(String.format(
				    "ShopOrderNo: %-6s ConsumerNo: %-6s ConsumerName: %-6s Phone: %-6s Address: %-6s EmployeeName: %-6s ProductName: %-6s price: %-5d Amount: %-5d",
				   
				    viewShopOrderReport.getShopOrderNo(),
				    viewShopOrderReport.getConsumerNo(),
				    viewShopOrderReport.getConsumerName(),
				    viewShopOrderReport.getPhone(),
				    viewShopOrderReport.getAddress(),
				    viewShopOrderReport.getEmployeeName(),
				    viewShopOrderReport.getProductName(),
				    viewShopOrderReport.getPrice(),
				    viewShopOrderReport.getAmount()
				));

		}	
		
//		System.out.println(new ViewShopOrderReportDaoImpl().selectMaxShopOrderNo());
	}

	@Override
	public List<ViewShopOrderReport> selectAll() {
		String sql = "select * from view_shop_order_report;";
		List<ViewShopOrderReport> allSViewShopOrderReport = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ViewShopOrderReport viewShopOrderReport = new ViewShopOrderReport();
				viewShopOrderReport.setShopOrderNo(resultSet.getString("shop_order_no"));
				viewShopOrderReport.setConsumerNo(resultSet.getString("consumer_no"));
				viewShopOrderReport.setConsumerName(resultSet.getString("consumer_name"));
				viewShopOrderReport.setPhone(resultSet.getString("phone"));
				viewShopOrderReport.setAddress(resultSet.getString("address"));
				viewShopOrderReport.setEmployeeName(resultSet.getString("employee_name"));
				viewShopOrderReport.setProductName(resultSet.getString("product_name"));
				viewShopOrderReport.setPrice(resultSet.getInt("price"));
				viewShopOrderReport.setAmount(resultSet.getInt("amount"));
				allSViewShopOrderReport.add(viewShopOrderReport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allSViewShopOrderReport;
	}

	@Override
	public List<ViewShopOrderReport> selectByConsumerNo(String consumerNo) {
		String sql = "select * from view_shop_order_report where consumer_no=?;";
		List<ViewShopOrderReport> allSViewShopOrderReport = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, consumerNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ViewShopOrderReport viewShopOrderReport = new ViewShopOrderReport();
				viewShopOrderReport.setShopOrderNo(resultSet.getString("shop_order_no"));
				viewShopOrderReport.setConsumerNo(resultSet.getString("consumer_no"));
				viewShopOrderReport.setConsumerName(resultSet.getString("consumer_name"));
				viewShopOrderReport.setPhone(resultSet.getString("phone"));
				viewShopOrderReport.setAddress(resultSet.getString("address"));
				viewShopOrderReport.setEmployeeName(resultSet.getString("employee_name"));
				viewShopOrderReport.setProductName(resultSet.getString("product_name"));
				viewShopOrderReport.setPrice(resultSet.getInt("price"));
				viewShopOrderReport.setAmount(resultSet.getInt("amount"));
				allSViewShopOrderReport.add(viewShopOrderReport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allSViewShopOrderReport;
	}

	
	

}
