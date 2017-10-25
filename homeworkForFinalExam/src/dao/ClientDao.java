package dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Client;

public class ClientDao extends HibernateDaoSupport implements IClientDao {

	/*
	 * 客户档案查询
	 */
	@Override
	public List<Client> findClient(Client client) {
		// 对象查找条件
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		if (client != null) {
			if (client.getId() != null
					&& String.valueOf(client.getId()).trim().length() > 0) {
				criteria.add(Restrictions.eq("id", client.getId()));
			}
			if (client.getCode() != null
					&& String.valueOf(client.getCode()).trim().length() > 0) {
				criteria.add(Restrictions.eq("code", client.getCode()));
			}
			if (client.getName() != null
					&& String.valueOf(client.getName()).trim().length() > 0) {
				criteria.add(Restrictions.like("name", client.getName(),
						MatchMode.ANYWHERE));
			}
		}
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	/*
	 * 新增客户档案
	 */
	@Override
	public void saveClient(Client client) {
		this.getHibernateTemplate().save(client);
	}

	/*
	 * 客户档案更新
	 */
	@Override
	public void updateClient(Client client) {
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		Integer cid = client.getId();
		Client perstClient = (Client) hibernateTemplate.load(Client.class, cid);
		perstClient.setName(client.getName());
		perstClient.setAddress(client.getAddress());
		perstClient.setTelephone(client.getTelephone());
		perstClient.setEmail(client.getEmail());
		hibernateTemplate.update(perstClient);

	}

	/*
	 * 删除客户档案
	 */
	@Override
	public void deleteClient(String[] clientId) {
		List<Client> entities = new ArrayList<Client>();
		HibernateTemplate hibernateTemplate = this.getHibernateTemplate();
		for (String cid : clientId) {
			entities.add((Client) hibernateTemplate.load(Client.class, Integer
					.valueOf(cid)));
		}
		hibernateTemplate.deleteAll(entities);
	}

}
