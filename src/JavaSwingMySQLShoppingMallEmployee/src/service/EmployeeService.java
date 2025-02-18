package service;

import java.util.List;

import model.Employee;
import model.ShopOrder;

public interface EmployeeService {
	// 新增員工
	void addEmployee(Employee employee);	
	
	// 員工登入
	Employee Login(String username,String password);
	
	// 查詢名稱是否被使用
	boolean isUsernameBeenUse(String username);	

		
	// 查詢員工
	String AllEmployee();
	List<Employee> findAllEmployee();
	Employee findById(int id);
	List<Employee> findByUsername(String username);
	
	// 修改員工
	void updateEmployee(Employee employee);
	
	// 刪除員工
	void delteEmployee(int id);
	
	// 查詢員工編號是否被使用
	boolean isEmployeeNoBeenUse(String employeeNo);	
}
