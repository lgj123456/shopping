package action;

import java.util.List;

import entity.Client;

import service.IClientService;


public class ClientAction {
	private IClientService clientService;// �ͻ�����ҵ����ӿ�
	private Client client;// ��Ϊ�����Ķ���
	private List<Client> clients;// ��ѯ���
	private String finish_Url;// ���������ת�ĵ�ַ
	private String[] clientId;// Ҫɾ���ͻ���Id

	/**
	 * �ͻ�������ѯ
	 * 
	 * @return
	 */
	public String findClient() {
		clients = clientService.findClient(client);
		return "findClient";
	}

	/**
	 * ���ݱ�Ų�ѯ�ͻ�����
	 * @param code
	 * @return
	 */
	public int findClientByCode(String code) {
		client = new Client();
		client.setCode(code);
		clients = clientService.findClient(client);
		return clients.size();
	}

	/**
	 * �����ͻ�����
	 * 
	 * @return
	 */
	public String saveClient() {
		clientService.saveClient(client);
		finish_Url = "clientAction!findClient.action";
		client = null;
		return "finish";
	}

	/**
	 * �ͻ���������ǰ��ѯ
	 * 
	 * @return
	 */
	public String preUpdateClient() {
		client = clientService.findClient(client).get(0);
		return "updateClient";
	}

	/**
	 * �ͻ���������
	 * 
	 * @return
	 */
	public String updateClient() {
		clientService.updateClient(client);
		finish_Url = "clientAction!findClient.action";
		client = null;
		return "finish";
	}

	/**
	 * ɾ���ͻ�����
	 * 
	 * @return
	 */
	public String deleteClient() {
		clientService.deleteClient(clientId);
		finish_Url = "clientAction!findClient.action";
		return "finish";
	}

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public String getFinish_Url() {
		return finish_Url;
	}

	public void setFinish_Url(String finish_Url) {
		this.finish_Url = finish_Url;
	}

	public String[] getClientId() {
		return clientId;
	}

	public void setClientId(String[] clientId) {
		this.clientId = clientId;
	}

}
