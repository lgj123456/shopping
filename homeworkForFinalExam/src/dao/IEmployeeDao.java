package dao;

import java.util.List;

import entity.Employee;



public interface IEmployeeDao {

	// 员工档案查询
	public List<Employee> findEmployee(Employee employee);

	// 新增员工档案
	public void saveEmployee(Employee employee);

	// 员工档案更新
	public void updateEmployee(Employee employee);

	// 删除员工档案
	public void deleteEmployee(String[] employeeId);

}
