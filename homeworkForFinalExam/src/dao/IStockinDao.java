package dao;

import java.util.List;

import entity.Stockin;


public interface IStockinDao {

	// ��������ѯ
	public List<Stockin> findStockin(Stockin stockin);

	// ����������
	public void saveStockin(Stockin stockin);

	// ����������
	public void updateStockin(Stockin stockin);

	// ������ɾ��
	public void deleteStockin(String[] stockinId);

}
