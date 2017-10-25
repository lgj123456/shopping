package service;

import java.util.List;

import entity.Stockin;



public interface IStockinService {

	// 进货单查询
	public List<Stockin> findStockin(Stockin stockin);

	// 进货单保存
	public void saveStockin(Stockin stockin);

	// 进货单更新
	public void updateStockin(Stockin stockin);

	// 进货单删除
	public void deleteStockin(String[] stockinId);
}
