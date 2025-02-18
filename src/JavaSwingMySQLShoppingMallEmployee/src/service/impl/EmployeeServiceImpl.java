package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.EmployeeDaoImpl;
import model.Employee;
import service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	private static EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEmployee(Employee employee) {
		
		employeeDaoImpl.add(employee);		
	}

	@Override
	public Employee Login(String username, String password) {
		Employee employee = null;
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList = employeeDaoImpl.selectUsernameAndPassword(username, password);
		if(employeeList.size()>0)
		{
			employee = employeeList.get(0);
		}
		
		return employee;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		
		return !employeeDaoImpl.selectByUsername(username).isEmpty();
	}

}
