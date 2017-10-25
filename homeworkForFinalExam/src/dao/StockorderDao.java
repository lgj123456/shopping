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
import entity.Stockorder;

public class StockorderDao extends HibernateDaoSupport implements
		IStockorderDao {

	/*
	 * ��������ѯ
	 */
	@Override
	public List<Stockorder> findStockorder(Stockorder stockorder) {
		// �����ѯ����
		DetachedCriteria criteria = DetachedCriteria.forClass(Stockorder.class);
		if (stockorder != null) {
			if (stockorder.getId() != null
					&& String.valueOf(stockorder.getId()).trim().length() > 0) {
				criteria.add(Restrictions.eq("id", stockorder.getId()));
			}
			if (stockorder.getCode() != null
					&& String.valueOf(stockorder.getCode()).trim().length() > 0) {
				criteria.add(Restrictions.eq("code", stockorder.getCode()));
			}
			if ((stockorder.getMerchandise() != null && String.valueOf(
					stockorder.getMerchandise()).trim().length() > 0)
					&& (stockorder.getMerchandise().getId() != null && String
							.valueOf(stockorder.getMerchandise().getId())
							.trim().length() > 0)) {
				criteria.add(Restrictions.eq("merchandise.id", stockorder
						.getMerchandise().getId()));
			}
			if ((stockorder.getClient() != null && String.valueOf(
					stockorder.getClient()).trim().length() > 0)
					&& (stockorder.getClient().getId() != null && String
							.valueOf(stockorder.getClient().getId()).trim()
							.length() > 0)) {
				criteria.add(Restrictions.eq("client.id", stockorder
						.getClient().getId()));
			}
			if (stockorder.getOrderdate() != null
					&& String.valueOf(stockorder.getOrderdate()).trim()
							.length() > 0) {
				criteria.add(Restrictions.eq("orderdate", stockorder
						.getOrderdate()));
			}
			if ((stockorder.getEmployee() != null && String.valueOf(
					stockorder.getEmployee()).trim().length() > 0)
					&& (stockorder.getEmployee().getId() != null && String
							.valueOf(stockorder.getEmployee().getId()).trim()
							.length() > 0)) {
				criteria.add(Restrictions.eq("employee.id", stockorder
						.getEmployee().getId()));
			}
		}
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * ����������
	 */
	@Override
	public void saveStockorder(Stockorder stockorder) {
		this.getHibernateTemplate().save(stockorder);
	}

	/*
	 * ����������
	 */
	@Override
	public void updateStockorder(Stockorder stockorder) {
		// �ͻ�������ѯ����
		Client client = new Client();
		client.setId(stockorder.getClient().getId());
		// Ա��������ѯ����
		Employee employee = new Employee();
		employee.setId(stockorder.getEmployee().getId());
		// ��Ʒ������ѯ����
		Merchandise merchandise = new Merchandise();
		merchandise.setId(stockorder.getMerchandise().getId());

		Integer sid = stockorder.getId();
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		// ����id����Stockorder����
		Stockorder prestStockorder = (Stockorder) hibernateTemplate.load(
				Stockorder.class, sid);
		prestStockorder.setMerchandisenumber(stockorder.getMerchandisenumber());
		prestStockorder.setOrderdate(stockorder.getOrderdate());
		prestStockorder.setClient(client);
		prestStockorder.setEmployee(employee);
		prestStockorder.setMerchandise(merchandise);
		// ����
		hibernateTemplate.update(prestStockorder);
	}

	/*
	 * ������ɾ��
	 */
	@Override
	public void deleteStockorder(String[] stockorderId) {
		List<Stockorder> entities = new ArrayList<Stockorder>();
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		for (String sid : stockorderId) {
			entities.add((Stockorder) hibernateTemplate.load(Stockorder.class,
					Integer.valueOf(sid)));
		}
		// ����ɾ��
		hibernateTemplate.deleteAll(entities);
	}
}
