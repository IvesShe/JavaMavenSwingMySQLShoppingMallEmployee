package service;

import model.Employee;

public interface EmployeeService {
	// 新增員工
	void addEmployee(Employee employee);	
	
	// 員工登入
	Employee Login(String username,String password);
	
	// 名稱是否被使用
	boolean isUsernameBeenUse(String username);
}
