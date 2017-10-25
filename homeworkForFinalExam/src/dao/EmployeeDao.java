package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import entity.Employee;;

public class EmployeeDao extends HibernateDaoSupport implements IEmployeeDao{

	@Override
	public List<Employee> findEmployee(Employee employee) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		if (employee != null) {
			if (employee.getId() != null
					&& String.valueOf(employee.getId()).trim().length() > 0) {
				criteria.add(Restrictions.eq("id", employee.getId()));
			}
			if (employee.getCode() != null
					&& String.valueOf(employee.getCode()).trim().length() > 0) {
				criteria.add(Restrictions.eq("code", employee.getCode()));
			}
			if (employee.getName() != null
					&& String.valueOf(employee.getName()).trim().length() > 0) {
				criteria.add(Restrictions.like("name", employee.getName(),
						MatchMode.ANYWHERE));
			}
		}
		System.out.println("size = " + this.getHibernateTemplate().findByCriteria(criteria).size());
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.getHibernateTemplate().save(employee);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		Integer eid = employee.getId();
		Employee perstEmployee = (Employee) hibernateTemplate.load(
				Employee.class, eid);
		perstEmployee.setName(employee.getName());
		perstEmployee.setBirthday(employee.getBirthday());
		perstEmployee.setSex(employee.isSex());// ÐÔ±ð
		perstEmployee.setTelephone(employee.getTelephone());
		perstEmployee.setEmail(employee.getEmail());
		hibernateTemplate.update(perstEmployee);

		
	}

	@Override
	public void deleteEmployee(String[] employeeId) {
		List<Employee> employees = new ArrayList<>();
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		for(String eid : employeeId){
			employees.add((Employee)hibernateTemplate.load(Employee.class, Integer.valueOf(eid)));
		}
		
		hibernateTemplate.deleteAll(employees);
		
	}

}
