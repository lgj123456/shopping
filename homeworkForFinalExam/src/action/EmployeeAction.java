package action;

import java.util.List;

import service.IEmployeeService;

import com.opensymphony.xwork2.ActionSupport;

import entity.Employee;

public class EmployeeAction extends ActionSupport {
	private IEmployeeService employeeService;
	private Employee employee;
	private List<Employee> employees;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getFinish_Url() {
		return finish_Url;
	}

	public void setFinish_Url(String finish_Url) {
		this.finish_Url = finish_Url;
	}

	public String[] getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String[] employeeId) {
		this.employeeId = employeeId;
	}

	private String finish_Url;
	private String[] employeeId;

	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// 查找员工档案
	public String findEmployee() {
		employees = employeeService.findEmployee(employee);
		return "findEmployee";
	}

	// 新增员工档案
	public String saveEmployee() {
		employeeService.saveEmployee(employee);
		finish_Url = "employeeAction!findEmployee.action";
		employee = null;
		return "finish";

	}

	// 根据id查找员工档案
	public int findEmployeeByCode(String code) {
		employee = new Employee();
		employee.setCode(code);
		employees = employeeService.findEmployee(employee);
		return employees.size();
	}

	// 员工档案更新前查询
	public String preUpdateEmployee() {
		employee = employeeService.findEmployee(employee).get(0);
		return "updateEmployee";
	}

	// 更新员工档案
	public String updateEmployee() {
		employeeService.updateEmployee(employee);
		finish_Url = "employeeAction!findEmployee.action";
		employee = null;
		return "finish";
	}

	// 删除员工档案
	public String deleteEmployee() {
		employeeService.deleteEmployee(employeeId);
		finish_Url = "employeeAction!findEmployee.action";
		return "finish";
	}
}
