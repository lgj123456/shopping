package dao;

import java.util.List;

import entity.Merchandise;



public interface IMerchandiseDao {
	
	// ��Ʒ������ѯ
	public List<Merchandise> findMerchandise(Merchandise merchandise);

	// ������Ʒ����
	public void saveMerchandise(Merchandise merchandise);

	// ��Ʒ��������
	public void updateMerchandise(Merchandise merchandise);

	// ɾ����Ʒ����
	public void deleteMerchandise(String[] merchandiseId);

}
