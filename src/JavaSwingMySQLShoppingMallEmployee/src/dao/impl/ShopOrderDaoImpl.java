package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		List<ShopOrder> allShopOrder = new ShopOrderDaoImpl().selectAll();
		for(ShopOrder shopOrder:allShopOrder)
		{
			System.out.println(String.format(
				    "id: %-5d Name: %-10s MealNo1: %-3d MealNo2: %-3d 建立時間: %s 更新時間: %s",
				    shopOrder.getId(),
				    shopOrder.getName(),
				    shopOrder.getMealNo1(),
				    shopOrder.getMealNo2(),
				    Tool.formatTimestamp(shopOrder.getCreatedAt()),
				    Tool.formatTimestamp(shopOrder.getUpdatedAt())
				));

		}	
	}

	@Override
	public void add(ShopOrder shopOrder) {
		String sql = "insert into shop_order(name,meal1,meal2) values(?,?,?);";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, shopOrder.getName());
			preparedStatement.setInt(2, shopOrder.getMealNo1());
			preparedStatement.setInt(3, shopOrder.getMealNo2());
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
				shopOrder.setName(resultSet.getString("name"));
				shopOrder.setMealNo1(resultSet.getInt("meal1"));
				shopOrder.setMealNo2(resultSet.getInt("meal2"));
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
				shopOrder.setName(resultSet.getString("name"));
				shopOrder.setMealNo1(resultSet.getInt("meal1"));
				shopOrder.setMealNo2(resultSet.getInt("meal2"));
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
		String  sql = "update shop_order set name=?,meal1=?,meal2=? where id=?;";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, shopOrder.getName());
			preparedStatement.setInt(2, shopOrder.getMealNo1());
			preparedStatement.setInt(3, shopOrder.getMealNo2());
			preparedStatement.setInt(4, shopOrder.getId());
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
	public List<ShopOrder> selectByUsername(String username) {
		String sql = "select * from shop_order where name=?";
		List<ShopOrder> allShopOrder = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1,username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				ShopOrder shopOrder = new ShopOrder();
				shopOrder.setId(resultSet.getInt("id"));
				shopOrder.setName(resultSet.getString("name"));
				shopOrder.setMealNo1(resultSet.getInt("meal1"));
				shopOrder.setMealNo2(resultSet.getInt("meal2"));
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
