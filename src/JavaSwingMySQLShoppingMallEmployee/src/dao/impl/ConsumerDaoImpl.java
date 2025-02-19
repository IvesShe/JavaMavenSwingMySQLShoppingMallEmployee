package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConsumerDao;
import model.Consumer;
import util.Tool;

public class ConsumerDaoImpl implements ConsumerDao{

	private static Connection conn = util.DbConnection.getDB();
	
	public static void main(String[] args) {		

	}

	@Override
	public void add(Consumer consumer) {
		String sql = "insert into consumer (consumer_no,username,password,consumer_name,phone,address) values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, consumer.getConsumerNo());
			preparedStatement.setString(2, consumer.getUsername());
			preparedStatement.setString(3, consumer.getPassword());
			preparedStatement.setString(4, consumer.getName());
			preparedStatement.setString(5, consumer.getPhone());
			preparedStatement.setString(6, consumer.getAddress());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Consumer> selectAll() {
		String sql = "select * from consumer";
		List<Consumer> consumerList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Consumer consumer = new Consumer();
				consumer.setConsumerNo(resultSet.getString("consumer_no"));
				consumer.setUsername(resultSet.getString("username"));
				consumer.setPassword(resultSet.getString("password"));
				consumer.setName(resultSet.getString("consumer_name"));
				consumer.setPhone(resultSet.getString("phone"));
				consumer.setAddress(resultSet.getString("address"));
				consumer.setCreatedAt(resultSet.getTimestamp("created_at"));
				consumer.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				consumer.setId(resultSet.getInt("id"));
				consumerList.add(consumer);
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return consumerList;
	}

	@Override
	public List<Consumer> selectUsernameAndPassword(String username, String password) {
		String sql = "select * from consumer where username=? and password=?";
		List<Consumer> consumerList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Consumer consumer = new Consumer();
				consumer.setConsumerNo(resultSet.getString("consumer_no"));
				consumer.setUsername(resultSet.getString("username"));
				consumer.setPassword(resultSet.getString("password"));
				consumer.setName(resultSet.getString("consumer_name"));
				consumer.setPhone(resultSet.getString("phone"));
				consumer.setAddress(resultSet.getString("address"));
				consumer.setCreatedAt(resultSet.getTimestamp("created_at"));
				consumer.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				consumer.setId(resultSet.getInt("id"));
				consumerList.add(consumer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return consumerList;
	}

	@Override
	public List<Consumer> selectById(int id) {
		String sql = "select * from consumer where id=?";
		List<Consumer> consumerList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Consumer consumer = new Consumer();
				consumer.setConsumerNo(resultSet.getString("consumer_no"));
				consumer.setUsername(resultSet.getString("username"));
				consumer.setPassword(resultSet.getString("password"));
				consumer.setName(resultSet.getString("consumer_name"));
				consumer.setPhone(resultSet.getString("phone"));
				consumer.setAddress(resultSet.getString("address"));
				consumer.setCreatedAt(resultSet.getTimestamp("created_at"));
				consumer.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				consumer.setId(resultSet.getInt("id"));
				consumerList.add(consumer);
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return consumerList;
	}

	@Override
	public List<Consumer> selectByUsername(String username) {
		String sql = "select * from consumer where username=?";
		List<Consumer> consumerList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Consumer consumer = new Consumer();
				consumer.setConsumerNo(resultSet.getString("consumer_no"));
				consumer.setUsername(resultSet.getString("username"));
				consumer.setPassword(resultSet.getString("password"));
				consumer.setName(resultSet.getString("consumer_name"));
				consumer.setPhone(resultSet.getString("phone"));
				consumer.setAddress(resultSet.getString("address"));
				consumer.setCreatedAt(resultSet.getTimestamp("created_at"));
				consumer.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				consumer.setId(resultSet.getInt("id"));
				consumerList.add(consumer);
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return consumerList;
	}

	@Override
	public void update(Consumer consumer) {
		String sql = "update consumer set consumer_no=?,consumer_name=?,username=?,password=?,phone=?,address=? where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, consumer.getConsumerNo());
			preparedStatement.setString(2, consumer.getName());
			preparedStatement.setString(3, consumer.getUsername());
			preparedStatement.setString(4, consumer.getPassword());
			preparedStatement.setString(5, consumer.getPhone());
			preparedStatement.setString(6, consumer.getAddress());
			preparedStatement.setInt(7, consumer.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from consumer where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Consumer> selectByConsumerNo(String consumerNo) {
		String sql = "select * from consumer where consumer_no=? ";
		List<Consumer> consumerList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, consumerNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Consumer consumer = new Consumer();
				consumer.setConsumerNo(resultSet.getString("consumer_no"));
				consumer.setUsername(resultSet.getString("username"));
				consumer.setPassword(resultSet.getString("password"));
				consumer.setName(resultSet.getString("consumer_name"));
				consumer.setPhone(resultSet.getString("phone"));
				consumer.setAddress(resultSet.getString("address"));
				consumer.setCreatedAt(resultSet.getTimestamp("created_at"));
				consumer.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				consumer.setId(resultSet.getInt("id"));
				consumerList.add(consumer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return consumerList;
	}


}
