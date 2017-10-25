package service;

import java.util.List;

import entity.Stockorder;



public interface IStockorderService {
	
	// ��������ѯ
	public List<Stockorder> findStockorder(Stockorder stockorder);

	// ����������
	public void saveStockorder(Stockorder stockorder);

	// ����������
	public void updateStockorder(Stockorder stockorder);

	// ������ɾ��
	public void deleteStockorder(String[] stockorderId);
	
}
