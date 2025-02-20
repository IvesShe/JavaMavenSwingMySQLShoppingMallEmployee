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
import model.ShopOrder;
import util.Tool;

public class ShopOrderDaoImpl implements ShopOrderDao {
	
	private static Connection conn = util.DbConnection.getDB();

	public static void main(String[] args) {
//		ShopOrder shopOrder = new ShopOrder("kk",115,9);
//		new ShopOrderDaoImpl().add(shopOrder);
		
//		List<ShopOrder> allShopOrder = new ShopOrderDaoImpl().selectAll();
//		for(ShopOrder shopOrder:allShopOrder)
//		{
//			System.out.println(String.format(
//				    "id: %-5d Name: %-10s ShopOrderNo: %-6s ProductNo: %-6s EmployeeNo: %-6s CustomerNo: %-6s Amount: %-6d 建立時間: %s 更新時間: %s",
//				    shopOrder.getId(),
//				    shopOrder.getShopOrderNo(),
//				    shopOrder.getProductNo(),
//				    shopOrder.getEmployeeNo(),
//				    shopOrder.getCustomerNo(),
//				    shopOrder.getAmount(),
//				    Tool.formatTimestamp(shopOrder.getCreatedAt()),
//				    Tool.formatTimestamp(shopOrder.getUpdatedAt())
//				));
//
//		}	
		System.out.println(new ShopOrderDaoImpl().selectMaxShopOrderNo());
	}

	@Override
	public void add(ShopOrder shopOrder) {
		String sql = "insert into shop_order(shop_order_no,product_no,employee_no,consumer_no,amount) values(?,?,?,?,?);";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, shopOrder.getShopOrderNo());
			preparedStatement.setString(2, shopOrder.getProductNo());
			preparedStatement.setString(3, shopOrder.getEmployeeNo());
			preparedStatement.setString(4, shopOrder.getCustomerNo());
			preparedStatement.setInt(5, shopOrder.getAmount());
			preparedStatement.executeLargeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<ShopOrder> selectAll() {
		String sql = "select * from shop_order;";
		List<ShopOrder> allShopOrder = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ShopOrder shopOrder = new ShopOrder();
				shopOrder.setId(resultSet.getInt("id"));
				shopOrder.setShopOrderNo(resultSet.getString("shop_order_no"));
				shopOrder.setProductNo(resultSet.getString("product_no"));
				shopOrder.setEmployeeNo(resultSet.getString("employee_no"));
				shopOrder.setCustomerNo(resultSet.getString("consumer_no"));
				shopOrder.setAmount(resultSet.getInt("amount"));
				shopOrder.setCreatedAt(resultSet.getTimestamp("created_at"));
				shopOrder.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				allShopOrder.add(shopOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allShopOrder;
	}

	@Override
	public ShopOrder selectById(int id) {
		String sql = "select * from shop_order where id=?";
		List<ShopOrder> allShopOrder = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ShopOrder shopOrder = new ShopOrder();
				shopOrder.setId(resultSet.getInt("id"));
				shopOrder.setShopOrderNo(resultSet.getString("shop_order_no"));
				shopOrder.setProductNo(resultSet.getString("product_no"));
				shopOrder.setEmployeeNo(resultSet.getString("employee_no"));
				shopOrder.setCustomerNo(resultSet.getString("consumer_no"));
				shopOrder.setAmount(resultSet.getInt("amount"));
				shopOrder.setCreatedAt(resultSet.getTimestamp("created_at"));
				shopOrder.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				allShopOrder.add(shopOrder);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allShopOrder.get(0);
	}

	@Override
	public void update(ShopOrder shopOrder) {
		String  sql = "update shop_order set shop_order_no=?,product_no=?,employee_no=?,consumer_no=?,amount=? where id=?;";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, shopOrder.getShopOrderNo());
			preparedStatement.setString(2, shopOrder.getProductNo());
			preparedStatement.setString(3, shopOrder.getEmployeeNo());
			preparedStatement.setString(4, shopOrder.getCustomerNo());
			preparedStatement.setInt(5, shopOrder.getAmount());
			preparedStatement.setInt(6, shopOrder.getId());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from shop_order where id=?;";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ShopOrder> selectByShopOrderNo(String shopOrderNo) {
		String sql = "select * from shop_order where shop_order_no=?";
		List<ShopOrder> allShopOrder = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,shopOrderNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ShopOrder shopOrder = new ShopOrder();
				shopOrder.setId(resultSet.getInt("id"));
				shopOrder.setShopOrderNo(resultSet.getString("shop_order_no"));
				shopOrder.setProductNo(resultSet.getString("product_no"));
				shopOrder.setEmployeeNo(resultSet.getString("employee_no"));
				shopOrder.setCustomerNo(resultSet.getString("consumer_no"));
				shopOrder.setAmount(resultSet.getInt("amount"));
				shopOrder.setCreatedAt(resultSet.getTimestamp("created_at"));
				shopOrder.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				allShopOrder.add(shopOrder);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allShopOrder;
	}

	@Override
	public String selectMaxShopOrderNo() {
		// 取得當前時間
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dateTime = now.format(formatter);
        
		String sql = "SELECT COUNT(*) FROM shop_order WHERE shop_order_no like ?";
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, "S" + dateTime + "%"); // 搜尋今天的訂單
			ResultSet resultSet = preparedStatement.executeQuery();
			
		 	int count = 1;
		    if (resultSet.next()) {
		    	count = resultSet.getInt(1) + 1; // 訂單數 +1
		    }
		    // 產生訂單編號（SHOPYYYYMMDDHHMMSSXXXX）
            return String.format("S%s%04d", dateTime, count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public List<ShopOrder> selectByEmployeeNo(String employeeNo) {
		String sql = "select * from shop_order where employe_no=?;";
		List<ShopOrder> allShopOrder = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, employeeNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ShopOrder shopOrder = new ShopOrder();
				shopOrder.setId(resultSet.getInt("id"));
				shopOrder.setShopOrderNo(resultSet.getString("shop_order_no"));
				shopOrder.setProductNo(resultSet.getString("product_no"));
				shopOrder.setEmployeeNo(resultSet.getString("employee_no"));
				shopOrder.setCustomerNo(resultSet.getString("consumer_no"));
				shopOrder.setAmount(resultSet.getInt("amount"));
				shopOrder.setCreatedAt(resultSet.getTimestamp("created_at"));
				shopOrder.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				allShopOrder.add(shopOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allShopOrder;
	}

	@Override
	public List<ShopOrder> selectByConsumerNo(String consumerNo) {
		String sql = "select * from shop_order where consumer_no=?;";
		List<ShopOrder> allShopOrder = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, consumerNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ShopOrder shopOrder = new ShopOrder();
				shopOrder.setId(resultSet.getInt("id"));
				shopOrder.setShopOrderNo(resultSet.getString("shop_order_no"));
				shopOrder.setProductNo(resultSet.getString("product_no"));
				shopOrder.setEmployeeNo(resultSet.getString("employee_no"));
				shopOrder.setCustomerNo(resultSet.getString("consumer_no"));
				shopOrder.setAmount(resultSet.getInt("amount"));
				shopOrder.setCreatedAt(resultSet.getTimestamp("created_at"));
				shopOrder.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				allShopOrder.add(shopOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allShopOrder;
	}

}
