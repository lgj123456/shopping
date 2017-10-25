package service;

import java.util.List;

import dao.IEmployeeDao;

import entity.Employee;

public class EmployeeService implements IEmployeeService{
	private IEmployeeDao employeeDao;

	@Override
	public List<Employee> findEmployee(Employee employee) {
		
		return employeeDao.findEmployee(employee);
	}

	public IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
		
	}

	@Override
	public void deleteEmployee(String[] employeeId) {
		employeeDao.deleteEmployee(employeeId);
		
	}

}
