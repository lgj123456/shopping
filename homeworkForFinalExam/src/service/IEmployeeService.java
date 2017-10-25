package service;

import java.util.List;

import entity.Employee;



public interface IEmployeeService {

	// Ա��������ѯ
	public List<Employee> findEmployee(Employee employee);

	// ����Ա������
	public void saveEmployee(Employee employee);

	// Ա����������
	public void updateEmployee(Employee employee);

	// ɾ��Ա������
	public void deleteEmployee(String[] employeeId);
}