package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDao;
import model.Employee;
import util.Tool;

public class EmployeeDaoImpl implements EmployeeDao{

	private static Connection conn = util.DbConnection.getDB();
	
	public static void main(String[] args) {
		
//		Employee employee = new Employee("e001","tom123","123","tom","389","台中");
//		new EmployeeDaoImpl().add(employee);
		
//		List<Employee> employeeList = new EmployeeDaoImpl().selectAll();
//		for(Employee e:employeeList)
//		{
//			String show =String.format(
//				    "id: %-5d EmployeeNo: %-6s Name: %-10s Username: %-10s Password: %-10s Phone: %-10s Address: %-10s 建立時間: %s 更新時間: %s",
//				    e.getId(),
//				    e.getEmployeeNo(),
//				    e.getName(),
//				    e.getUsername(),
//				    e.getPassword(),
//				    e.getPhone(),
//				    e.getAddress(),
//				    Tool.formatTimestamp(e.getCreatedAt()),
//				    Tool.formatTimestamp(e.getUpdatedAt())
//				);
//			System.out.println(show);
//		}
		
//		List<Employee> employeeList = new EmployeeDaoImpl().selectUsernameAndPassword("andy123","1234");
//		for(Employee e:employeeList)
//		{
//			String show =String.format(
//				    "id: %-5d EmployeeNo: %-6s Name: %-10s Username: %-10s Password: %-10s Phone: %-10s Address: %-10s 建立時間: %s 更新時間: %s",
//				    e.getId(),
//				    e.getEmployeeNo(),
//				    e.getName(),
//				    e.getUsername(),
//				    e.getPassword(),
//				    e.getPhone(),
//				    e.getAddress(),
//				    Tool.formatTimestamp(e.getCreatedAt()),
//				    Tool.formatTimestamp(e.getUpdatedAt())
//				);
//			System.out.println(show);
//		}
		
//		List<Employee> employeeList = new EmployeeDaoImpl().selectById(1);
//		for(Employee e:employeeList)
//		{
//			String show =String.format(
//				    "id: %-5d EmployeeNo: %-6s Name: %-10s Username: %-10s Password: %-10s Phone: %-10s Address: %-10s 建立時間: %s 更新時間: %s",
//				    e.getId(),
//				    e.getEmployeeNo(),
//				    e.getName(),
//				    e.getUsername(),
//				    e.getPassword(),
//				    e.getPhone(),
//				    e.getAddress(),
//				    Tool.formatTimestamp(e.getCreatedAt()),
//				    Tool.formatTimestamp(e.getUpdatedAt())
//				);
//			System.out.println(show);
//		}
		
//		List<Employee> employeeList = new EmployeeDaoImpl().selectByUsername("tom123");
//		for(Employee e:employeeList)
//		{
//			String show =String.format(
//				    "id: %-5d EmployeeNo: %-6s Name: %-10s Username: %-10s Password: %-10s Phone: %-10s Address: %-10s 建立時間: %s 更新時間: %s",
//				    e.getId(),
//				    e.getEmployeeNo(),
//				    e.getName(),
//				    e.getUsername(),
//				    e.getPassword(),
//				    e.getPhone(),
//				    e.getAddress(),
//				    Tool.formatTimestamp(e.getCreatedAt()),
//				    Tool.formatTimestamp(e.getUpdatedAt())
//				);
//			System.out.println(show);
//		}
		
//		Employee employee = new EmployeeDaoImpl().selectById(1).get(0);
//		employee.setName("Tom123");
//		new EmployeeDaoImpl().update(employee);
		
//		new EmployeeDaoImpl().delete(1);
		
//		List<Employee> employeeList = new EmployeeDaoImpl().selectByEmployeeNo("e003");
//		for(Employee e:employeeList)
//		{
//			String show =String.format(
//				    "id: %-5d EmployeeNo: %-6s Name: %-10s Username: %-10s Password: %-10s Phone: %-10s Address: %-10s 建立時間: %s 更新時間: %s",
//				    e.getId(),
//				    e.getEmployeeNo(),
//				    e.getName(),
//				    e.getUsername(),
//				    e.getPassword(),
//				    e.getPhone(),
//				    e.getAddress(),
//				    Tool.formatTimestamp(e.getCreatedAt()),
//				    Tool.formatTimestamp(e.getUpdatedAt())
//				);
//			System.out.println(show);
//		}

	}

	@Override
	public void add(Employee employee) {
		String sql = "insert into employee (employee_no,username,password,name,phone,address) values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, employee.getEmployeeNo());
			preparedStatement.setString(2, employee.getUsername());
			preparedStatement.setString(3, employee.getPassword());
			preparedStatement.setString(4, employee.getName());
			preparedStatement.setString(5, employee.getPhone());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> selectAll() {
		String sql = "select * from employee";
		List<Employee> employeeList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Employee employee = new Employee();
				employee.setEmployeeNo(resultSet.getString("employee_no"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setName(resultSet.getString("name"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setAddress(resultSet.getString("address"));
				employee.setCreatedAt(resultSet.getTimestamp("created_at"));
				employee.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				employee.setId(resultSet.getInt("id"));
				employeeList.add(employee);
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return employeeList;
	}

	@Override
	public List<Employee> selectUsernameAndPassword(String username, String password) {
		String sql = "select * from employee where username=? and password=?";
		List<Employee> employeeList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Employee employee = new Employee();
				employee.setEmployeeNo(resultSet.getString("employee_no"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setName(resultSet.getString("name"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setAddress(resultSet.getString("address"));
				employee.setCreatedAt(resultSet.getTimestamp("created_at"));
				employee.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				employee.setId(resultSet.getInt("id"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}

	@Override
	public List<Employee> selectById(int id) {
		String sql = "select * from employee where id=?";
		List<Employee> employeeList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Employee employee = new Employee();
				employee.setEmployeeNo(resultSet.getString("employee_no"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setName(resultSet.getString("name"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setAddress(resultSet.getString("address"));
				employee.setCreatedAt(resultSet.getTimestamp("created_at"));
				employee.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				employee.setId(resultSet.getInt("id"));
				employeeList.add(employee);
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return employeeList;
	}

	@Override
	public List<Employee> selectByUsername(String username) {
		String sql = "select * from employee where username=?";
		List<Employee> employeeList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Employee employee = new Employee();
				employee.setEmployeeNo(resultSet.getString("employee_no"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setName(resultSet.getString("name"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setAddress(resultSet.getString("address"));
				employee.setCreatedAt(resultSet.getTimestamp("created_at"));
				employee.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				employee.setId(resultSet.getInt("id"));
				employeeList.add(employee);
			}				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		

		return employeeList;
	}

	@Override
	public void update(Employee employee) {
		String sql = "update employee set employee_no=?,name=?,username=?,password=?,phone=?,address=? where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, employee.getEmployeeNo());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getUsername());
			preparedStatement.setString(4, employee.getPassword());
			preparedStatement.setString(5, employee.getPhone());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setInt(7, employee.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from employee where id=?";
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> selectByEmployeeNo(String employeeNo) {
		String sql = "select * from employee where employee_no=? ";
		List<Employee> employeeList = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, employeeNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Employee employee = new Employee();
				employee.setEmployeeNo(resultSet.getString("employee_no"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setName(resultSet.getString("name"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setAddress(resultSet.getString("address"));
				employee.setCreatedAt(resultSet.getTimestamp("created_at"));
				employee.setUpdatedAt(resultSet.getTimestamp("updated_at"));
				employee.setId(resultSet.getInt("id"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
	}

}
