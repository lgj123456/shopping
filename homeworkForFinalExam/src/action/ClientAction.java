package action;

import java.util.List;

import entity.Client;

import service.IClientService;


public class ClientAction {
	private IClientService clientService;// 客户档案业务处理接口
	private Client client;// 作为条件的对象
	private List<Client> clients;// 查询结果
	private String finish_Url;// 操作完成跳转的地址
	private String[] clientId;// 要删除客户的Id

	/**
	 * 客户档案查询
	 * 
	 * @return
	 */
	public String findClient() {
		clients = clientService.findClient(client);
		return "findClient";
	}

	/**
	 * 根据编号查询客户档案
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
	 * 新增客户档案
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
	 * 客户档案更新前查询
	 * 
	 * @return
	 */
	public String preUpdateClient() {
		client = clientService.findClient(client).get(0);
		return "updateClient";
	}

	/**
	 * 客户档案更新
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
	 * 删除客户档案
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
