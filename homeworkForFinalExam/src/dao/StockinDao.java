package dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Client;
import entity.Employee;
import entity.Merchandise;
import entity.Stockin;

public class StockinDao extends HibernateDaoSupport implements IStockinDao {

	/*
	 * ��������ѯ
	 */
	@Override
	public List<Stockin> findStockin(Stockin stockin) {
		// �����ѯ����
		DetachedCriteria criteria = DetachedCriteria.forClass(Stockin.class);
		if (stockin != null) {
			if (stockin.getId() != null
					&& String.valueOf(stockin.getId()).trim().length() > 0) {
				criteria.add(Restrictions.eq("id", stockin.getId()));
			}
			if (stockin.getCode() != null
					&& String.valueOf(stockin.getCode()).trim().length() > 0) {
				criteria.add(Restrictions.eq("code", stockin.getCode()));
			}
			if ((stockin.getMerchandise() != null && String.valueOf(
					stockin.getMerchandise()).trim().length() > 0)
					&& (stockin.getMerchandise().getId() != null && String
							.valueOf(stockin.getMerchandise().getId()).trim()
							.length() > 0)) {
				criteria.add(Restrictions.eq("merchandise.id", stockin
						.getMerchandise().getId()));
			}
			if ((stockin.getClient() != null && String.valueOf(
					stockin.getClient()).trim().length() > 0)
					&& (stockin.getClient().getId() != null && String.valueOf(
							stockin.getClient().getId()).trim().length() > 0)) {
				criteria.add(Restrictions.eq("client.id", stockin.getClient()
						.getId()));
			}
			if (stockin.getStockindate() != null
					&& String.valueOf(stockin.getStockindate()).trim().length() > 0) {
				criteria.add(Restrictions.eq("stockindate", stockin
						.getStockindate()));
			}
			if ((stockin.getEmployee() != null && String.valueOf(
					stockin.getEmployee()).trim().length() > 0)
					&& (stockin.getEmployee().getId() != null && String
							.valueOf(stockin.getEmployee().getId()).trim()
							.length() > 0)) {
				criteria.add(Restrictions.eq("employee.id", stockin
						.getEmployee().getId()));
			}
		}
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * ����������
	 */
	@Override
	public void saveStockin(Stockin stockin) {
		this.getHibernateTemplate().save(stockin);
	}

	/*
	 * ����������
	 */
	@Override
	public void updateStockin(Stockin stockin) {
		// �ͻ�������ѯ����
		Client client = new Client();
		client.setId(stockin.getClient().getId());
		// Ա��������ѯ����
		Employee employee = new Employee();
		employee.setId(stockin.getEmployee().getId());
		// ��Ʒ������ѯ����
		Merchandise merchandise = new Merchandise();
		merchandise.setId(stockin.getMerchandise().getId());

		Integer sid = stockin.getId();
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		// ����id����Stockin����
		Stockin prestStockin = (Stockin) hibernateTemplate.load(Stockin.class,
				sid);
		prestStockin.setAmount(stockin.getAmount());
		prestStockin.setMoney(stockin.getMoney());
		prestStockin.setPrice(stockin.getPrice());
		prestStockin.setStockindate(stockin.getStockindate());
		prestStockin.setClient(client);
		prestStockin.setEmployee(employee);
		prestStockin.setMerchandise(merchandise);
		// ����
		hibernateTemplate.update(prestStockin);
	}

	/*
	 * ������ɾ��
	 */
	@Override
	public void deleteStockin(String[] stockinId) {
		List<Stockin> entities = new ArrayList<Stockin>();
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		for (String sid : stockinId) {
			entities.add((Stockin) hibernateTemplate.load(Stockin.class,
					Integer.valueOf(sid)));
		}
		// ����ɾ��
		hibernateTemplate.deleteAll(entities);
	}
}
