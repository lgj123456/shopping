package dao;

import java.util.List;

import entity.Client;



public interface IClientDao {

	// �ͻ�������ѯ
	public List<Client> findClient(Client client);

	// �����ͻ�����
	public void saveClient(Client client);

	// �ͻ���������
	public void updateClient(Client client);

	// ɾ���ͻ�����
	public void deleteClient(String[] clientId);

}
