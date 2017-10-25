package service;

import java.util.List;

import dao.IMerchandiseDao;
import entity.Merchandise;



public class MerchandiseService implements IMerchandiseService {
	private IMerchandiseDao merchandiseDao;

	/*
	 * ��Ʒ������ѯ
	 */
	@Override
	public List<Merchandise> findMerchandise(Merchandise merchandise) {
		return merchandiseDao.findMerchandise(merchandise);
	}

	/*
	 * ������Ʒ����
	 */
	@Override
	public void saveMerchandise(Merchandise merchandise) {
		merchandiseDao.saveMerchandise(merchandise);
	}

	/*
	 * ��Ʒ��������
	 */
	@Override
	public void updateMerchandise(Merchandise merchandise) {
		merchandiseDao.updateMerchandise(merchandise);
	}

	/*
	 * ɾ����Ʒ����
	 */
	@Override
	public void deleteMerchandise(String[] merchandiseId) {
		merchandiseDao.deleteMerchandise(merchandiseId);
	}

	public IMerchandiseDao getMerchandiseDao() {
		return merchandiseDao;
	}

	public void setMerchandiseDao(IMerchandiseDao merchandiseDao) {
		this.merchandiseDao = merchandiseDao;
	}

}
