package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import model.Product;

public class ProductDaoImpl implements ProductDao{

	private static Connection conn = util.DbConnection.getDB();
	
	public static void main(String[] args) {		
		
	}

	@Override
	public void add(Product product) {
		String sql = "insert into product (product_no,product_name,price) values(?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, product.getProductNo());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getPrice());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> selectAll() {
		String sql = "select * from product";
		List<Product> productList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Product product = new Product();
				product.setProductNo(resultSet.getString("product_no"));
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getInt("price"));
				product.setCreatedAt(resultSet.getTimestamp("created_at"));
				product.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				product.setId(resultSet.getInt("id"));
				productList.add(product);
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return productList;
	}
	

	@Override
	public List<Product> selectById(int id) {
		String sql = "select * from product where id=?";
		List<Product> productList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Product product = new Product();
				product.setProductNo(resultSet.getString("product_no"));
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getInt("price"));
				product.setCreatedAt(resultSet.getTimestamp("created_at"));
				product.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				product.setId(resultSet.getInt("id"));
				productList.add(product);
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return productList;
	}

	@Override
	public List<Product> selectByName(String name) {
		String sql = "select * from product where product_name=?";
		List<Product> productList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Product product = new Product();
				product.setProductNo(resultSet.getString("product_no"));
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getInt("price"));
				product.setCreatedAt(resultSet.getTimestamp("created_at"));
				product.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				product.setId(resultSet.getInt("id"));
				productList.add(product);
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return productList;
	}

	@Override
	public void update(Product product) {
		String sql = "update product set product_no=?,product_name=?,price=? where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, product.getProductNo());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setInt(3, product.getPrice());
			preparedStatement.setInt(4, product.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from product where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Product> selectByProductNo(String productNo) {
		String sql = "select * from product where product_no=? ";
		List<Product> productList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, productNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Product product = new Product();
				product.setProductNo(resultSet.getString("product_no"));
				product.setName(resultSet.getString("product_name"));
				product.setPrice(resultSet.getInt("price"));
				product.setCreatedAt(resultSet.getTimestamp("created_at"));
				product.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				product.setId(resultSet.getInt("id"));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList;
	}


}
