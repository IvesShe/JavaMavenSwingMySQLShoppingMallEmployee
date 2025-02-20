package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.EmployeeDaoImpl;
import model.Employee;
import service.EmployeeService;
import util.Tool;

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

	@Override
	public String AllEmployee() {
		List<Employee> employeeList = employeeDaoImpl.selectAll();
		String show = "";
		
		for(Employee e:employeeList)
		{
			show += String.format(
				    "id: %-5d EmployeeNo: %-6s Name: %-10s Username: %-10s Password: %-10s Phone: %-10s Address: %-10s 建立時間: %s 更新時間: %s",
				    e.getId(),
				    e.getEmployeeNo(),
				    e.getName(),
				    e.getUsername(),
				    e.getPassword(),
				    e.getPhone(),
				    e.getAddress(),
				    Tool.formatTimestamp(e.getCreatedAt()),
				    Tool.formatTimestamp(e.getUpdatedAt())
				);
			show += "\n";
		}
		
		return show+"";
	}

	@Override
	public List<Employee> findAllEmployee() {
		List<Employee> employeeList = employeeDaoImpl.selectAll();
		return employeeList;
	}

	@Override
	public Employee findById(int id) {
		List<Employee> employeeList = employeeDaoImpl.selectById(id);
		
		return employeeList.size() > 0 ? employeeList.get(0):null;
	}

	@Override
	public List<Employee> findByUsername(String username) {
		List<Employee> employeeList = employeeDaoImpl.selectByUsername(username);
		return employeeList;
//		String show = "";
//		
//		for(Employee e:employeeList)
//		{
//			show += String.format(
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
//			show += "\n";
//		}
//		
//		return show+"";
	}

	@Override
	public void updateEmployee(Employee employee) {
		
		employeeDaoImpl.update(employee);
	}

	@Override
	public void delteEmployee(int id) {
		
		employeeDaoImpl.delete(id);
	}

	@Override
	public boolean isEmployeeNoBeenUse(String employeeNo) {
		
		return !employeeDaoImpl.selectByEmployeeNo(employeeNo).isEmpty();
	}

}
