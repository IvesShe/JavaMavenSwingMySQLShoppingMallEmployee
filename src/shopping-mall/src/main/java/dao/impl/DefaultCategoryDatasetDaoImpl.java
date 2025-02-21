package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jfree.data.category.DefaultCategoryDataset;

import dao.DefaultCategoryDatasetDao;

public class DefaultCategoryDatasetDaoImpl implements DefaultCategoryDatasetDao{
	
	private static Connection conn = util.DbConnection.getDB();

	public static void main(String[] args) {

		System.out.println(new DefaultCategoryDatasetDaoImpl().selectAll());
		
	}

	@Override
	public DefaultCategoryDataset selectAll() {
		String sql = "SELECT \r\n"
				+ "    so.product_no, \r\n"
				+ "    p.product_name, \r\n"
				+ "    SUM(so.amount) as total\r\n"
				+ "FROM shopping.shop_order AS so\r\n"
				+ "INNER JOIN shopping.product AS p \r\n"
				+ "    ON so.product_no = p.product_no\r\n"
				+ "GROUP BY so.product_no, p.product_name\r\n"
				+ "ORDER BY SUM(so.amount) DESC;";
		
		DefaultCategoryDataset defaultCategoryDatasetList = new DefaultCategoryDataset();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				String productName = resultSet.getString("product_name");
                int totalSold = resultSet.getInt(3);
                defaultCategoryDatasetList.addValue(totalSold, "銷售數量", productName);
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return defaultCategoryDatasetList;
	}

}
