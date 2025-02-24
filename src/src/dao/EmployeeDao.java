package dao;

import java.util.List;

import model.Employee;

public interface EmployeeDao {
	
	// 新增員工
	void add(Employee employee);
	
	// 查詢員工
	List<Employee> selectAll();
	List<Employee> selectUsernameAndPassword(String username,String password);
	List<Employee> selectById(int id);
	List<Employee> selectByUsername(String username);
	List<Employee> selectByEmployeeNo(String employeeNo);
	
	// 更新員工
	void update(Employee employee);
	
	// 刪除員工
	void delete(int id);
}
