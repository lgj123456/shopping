package service;

import java.util.List;

import dao.IStockorderDao;
import entity.Stockorder;



public class StockorderService implements IStockorderService {
	private IStockorderDao stockorderDao;

	// ��������ѯ
	public List<Stockorder> findStockorder(Stockorder stockorder) {
		return stockorderDao.findStockorder(stockorder);
	}

	// ����������
	public void saveStockorder(Stockorder stockorder) {
		stockorderDao.saveStockorder(stockorder);
	}

	// ����������
	public void updateStockorder(Stockorder stockorder) {
		stockorderDao.updateStockorder(stockorder);
	}

	// ������ɾ��
	public void deleteStockorder(String[] stockorderId) {
		stockorderDao.deleteStockorder(stockorderId);
	}

	public IStockorderDao getStockorderDao() {
		return stockorderDao;
	}

	public void setStockorderDao(IStockorderDao stockorderDao) {
		this.stockorderDao = stockorderDao;
	}

}
