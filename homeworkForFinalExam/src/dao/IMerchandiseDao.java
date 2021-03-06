package dao;

import java.util.List;

import entity.Merchandise;



public interface IMerchandiseDao {
	
	// 商品档案查询
	public List<Merchandise> findMerchandise(Merchandise merchandise);

	// 新增商品档案
	public void saveMerchandise(Merchandise merchandise);

	// 商品档案更新
	public void updateMerchandise(Merchandise merchandise);

	// 删除商品档案
	public void deleteMerchandise(String[] merchandiseId);

}
