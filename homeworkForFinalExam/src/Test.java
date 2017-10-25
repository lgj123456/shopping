import java.util.HashSet;
import java.util.Set;

import dao.EmployeeDao;

import entity.Employee;
import entity.Stockorder;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stockorder stockorder1 = new Stockorder();
		stockorder1.setCode("999");
		Stockorder stockorder2 = new Stockorder();
		stockorder2.setCode("000");
		Employee employee = new Employee();
		Set<Stockorder> stockorders = new HashSet<>();
		stockorders.add(stockorder1);
		stockorders.add(stockorder2);
		employee.setStockorders(stockorders);
		EmployeeDao dao = new EmployeeDao();
		dao.saveEmployee(employee);

	}

}
