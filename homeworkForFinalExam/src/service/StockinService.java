package service;

import java.util.List;

import dao.IStockinDao;
import entity.Stockin;



public class StockinService implements IStockinService {
	private IStockinDao stockinDao;

	/*
	 * 进货单查询
	 */
	@Override
	public List<Stockin> findStockin(Stockin stockin) {
		return stockinDao.findStockin(stockin);
	}

	/*
	 * 进货单保存
	 */
	@Override
	public void saveStockin(Stockin stockin) {
		stockinDao.saveStockin(stockin);
	}

	/*
	 * 进货单更新
	 */
	@Override
	public void updateStockin(Stockin stockin) {
		stockinDao.updateStockin(stockin);
	}

	/*
	 * 进货单删除
	 */
	@Override
	public void deleteStockin(String[] stockinId) {
		stockinDao.deleteStockin(stockinId);
	}

	public IStockinDao getStockinDao() {
		return stockinDao;
	}

	public void setStockinDao(IStockinDao stockinDao) {
		this.stockinDao = stockinDao;
	}

}
