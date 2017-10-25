package dao;

import java.util.List;

import entity.Stockorder;



public interface IStockorderDao {

	// 订货单查询
	public List<Stockorder> findStockorder(Stockorder stockorder);

	// 订货单保存
	public void saveStockorder(Stockorder stockorder);

	// 订货单更新
	public void updateStockorder(Stockorder stockorder);

	// 订货单删除
	public void deleteStockorder(String[] stockorderId);

}
