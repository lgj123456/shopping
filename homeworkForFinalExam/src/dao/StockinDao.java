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
	 * 进货单查询
	 */
	@Override
	public List<Stockin> findStockin(Stockin stockin) {
		// 对象查询条件
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
	 * 进货单保存
	 */
	@Override
	public void saveStockin(Stockin stockin) {
		this.getHibernateTemplate().save(stockin);
	}

	/*
	 * 进货单更新
	 */
	@Override
	public void updateStockin(Stockin stockin) {
		// 客户档案查询条件
		Client client = new Client();
		client.setId(stockin.getClient().getId());
		// 员工档案查询条件
		Employee employee = new Employee();
		employee.setId(stockin.getEmployee().getId());
		// 商品档案查询条件
		Merchandise merchandise = new Merchandise();
		merchandise.setId(stockin.getMerchandise().getId());

		Integer sid = stockin.getId();
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		// 根据id加载Stockin对象
		Stockin prestStockin = (Stockin) hibernateTemplate.load(Stockin.class,
				sid);
		prestStockin.setAmount(stockin.getAmount());
		prestStockin.setMoney(stockin.getMoney());
		prestStockin.setPrice(stockin.getPrice());
		prestStockin.setStockindate(stockin.getStockindate());
		prestStockin.setClient(client);
		prestStockin.setEmployee(employee);
		prestStockin.setMerchandise(merchandise);
		// 更新
		hibernateTemplate.update(prestStockin);
	}

	/*
	 * 进货单删除
	 */
	@Override
	public void deleteStockin(String[] stockinId) {
		List<Stockin> entities = new ArrayList<Stockin>();
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		for (String sid : stockinId) {
			entities.add((Stockin) hibernateTemplate.load(Stockin.class,
					Integer.valueOf(sid)));
		}
		// 批量删除
		hibernateTemplate.deleteAll(entities);
	}
}
