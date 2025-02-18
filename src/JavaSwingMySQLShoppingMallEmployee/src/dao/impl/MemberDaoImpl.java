package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;


public class MemberDaoImpl implements MemberDao{
	
	private static Connection conn = util.DbConnection.getDB();

	public static void main(String[] args) {
//		Member m = new Member("jay","jay02","12344566","新北3市","3332239","2243349");
//		new MemberDaoImpl().add(m);
		
//		List<Member> l = new MemberDaoImpl().selectAll();
//		for(Member m:l)
//		{
//			System.out.println(m.getId()+"\t"+m.getName()+"\t"+m.getUsername()+"\t"+m.getPassword());
//		}
		
//		System.out.println(new MemberDaoImpl().selectUsernameAndPassword("tim0211","123"));
		
//		System.out.println(new MemberDaoImpl().selectById(11));
//		
//		System.out.println(new MemberDaoImpl().selectByUsername("tim021"));
		
//		List<Member> allMember=new ArrayList<Member>();
//		allMember = new MemberDaoImpl().selectById(1);
//		Member m = allMember.get(0);
//		m.setName("778");
//		new MemberDaoImpl().update(m);
		
		
		new MemberDaoImpl().delete(1);
		
		
		

	}

	@Override
	public void add(Member member) {
		String sql = "insert into shop_member(name,username,password,address,phone,mobile) values(?,?,?,?,?,?);";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, member.getName());
			preparedStatement.setString(2, member.getUsername());
			preparedStatement.setString(3, member.getPassword());
			preparedStatement.setString(4, member.getAddress());
			preparedStatement.setString(5, member.getPhone());
			preparedStatement.setString(6, member.getMobile());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Member> selectAll() {
		String sql = "select * from shop_member;";
		List<Member> allMember = new ArrayList<Member>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery(sql);
			while(resultSet.next())
			{
				Member m = new Member();
				m.setId(resultSet.getInt("id"));
				m.setName(resultSet.getString("name"));
				m.setUsername(resultSet.getString("username"));
				m.setPassword(resultSet.getString("password"));
				m.setPhone(resultSet.getString("phone"));
				m.setMobile(resultSet.getString("mobile"));
				allMember.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allMember;
	}

	@Override
	public List<Member> selectUsernameAndPassword(String username, String password) {
		String sql = "select * from shop_member where username=? and password=? ;";
		List<Member> allMember = new ArrayList<Member>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				Member m = new Member();
				m.setId(resultSet.getInt("id"));
				m.setName(resultSet.getString("name"));		
				m.setUsername(resultSet.getString("username"));						
				m.setPassword(resultSet.getString("password"));
				m.setPhone(resultSet.getString("phone"));
				m.setMobile(resultSet.getString("mobile"));
				allMember.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return allMember;
	}

	@Override
	public List<Member> selectById(int id) {
		String sql = "select * from shop_member where id=?";
		List<Member> allMember = new ArrayList<Member>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Member m = new Member();
				m.setId(resultSet.getInt("id"));				
				m.setName(resultSet.getString("name"));
				m.setUsername(resultSet.getString("username"));
				m.setAddress(resultSet.getString("address"));
				m.setPhone(resultSet.getString("phone"));
				m.setMobile(resultSet.getString("mobile"));
				allMember.add(m);
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		
		return allMember;
	}

	@Override
	public List<Member> selectByUsername(String username) {
		String sql = "select * from shop_member where username=?;";
		List<Member> allMember = new ArrayList<Member>();
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Member m = new Member();
				m.setId(resultSet.getInt("id"));
				m.setName(resultSet.getString("name"));
				m.setUsername(resultSet.getString("username"));
				m.setAddress(resultSet.getString("address"));
				m.setPhone(resultSet.getString("phone"));
				m.setMobile(resultSet.getString("mobile"));
				allMember.add(m);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allMember;
	}

	@Override
	public void update(Member member) {
		String sql = "update shop_member set name=?,password=?,address=?,phone=?,mobile=? where id=?;";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, member.getName());
			preparedStatement.setString(2, member.getPassword());
			preparedStatement.setString(3, member.getAddress());
			preparedStatement.setString(4, member.getPhone());
			preparedStatement.setString(5, member.getMobile());
			preparedStatement.setInt(6, member.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public void delete(int id) {
		String sql = "delete from shop_member where id=?;";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
