package service;

import java.util.List;

import dao.IStockorderDao;
import entity.Stockorder;



public class StockorderService implements IStockorderService {
	private IStockorderDao stockorderDao;

	// 订货单查询
	public List<Stockorder> findStockorder(Stockorder stockorder) {
		return stockorderDao.findStockorder(stockorder);
	}

	// 订货单保存
	public void saveStockorder(Stockorder stockorder) {
		stockorderDao.saveStockorder(stockorder);
	}

	// 订货单更新
	public void updateStockorder(Stockorder stockorder) {
		stockorderDao.updateStockorder(stockorder);
	}

	// 订货单删除
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
