package action;

import java.util.List;

import entity.Client;
import entity.Employee;
import entity.Merchandise;
import entity.Stockin;

import service.IClientService;
import service.IEmployeeService;
import service.IMerchandiseService;
import service.IStockinService;



public class StockinAction {
	private IStockinService stockinService;// ������ҵ����ӿ�
	private IMerchandiseService merchandiseService;// ��Ʒ����ҵ����ӿ�
	private IClientService clientService;// �ͻ�����ҵ����ӿ�
	private IEmployeeService employeeService;// Ա������ҵ����ӿ�
	private Stockin stockin;// ��Ϊ�����Ķ���
	private List<Stockin> stockins;// ��������ѯ���
	private List<Merchandise> merchandises;// ��Ʒ��ѯ���
	private List<Client> clients;// �ͻ���ѯ���
	private List<Employee> employees;// Ա����ѯ���
	private String finish_Url;// ���������ת�ĵ�ַ
	private String[] stockinId;// Ҫɾ����������ID

	/**
	 * ��ѯ������ǰ��Ʒ���ͻ���Ա��������ѯ
	 * 
	 * @return
	 */
	public String preFindStockin() {
		// ��ѯȫ����Ʒ����
		merchandises = merchandiseService.findMerchandise(null);
		// ��ѯȫ���ͻ�����
		clients = clientService.findClient(null);
		// ��ѯȫ��Ա������
		employees = employeeService.findEmployee(null);
		return "preFindStockin";
	}

	/**
	 * ��������ѯ
	 * 
	 * @return
	 */
	public String findStockin() {
		stockins = stockinService.findStockin(stockin);
		return "findStockin";
	}

	/**
	 * ���������ǰ��Ʒ���ͻ���Ա��������ѯ
	 * 
	 * @return
	 */
	public String preSaveStockin() {
		// ��ѯȫ����Ʒ����
		merchandises = merchandiseService.findMerchandise(null);
		// ��ѯȫ���ͻ�����
		clients = clientService.findClient(null);
		// ��ѯȫ��Ա������
		employees = employeeService.findEmployee(null);
		return "preSaveStockin";
	}

	/**
	 * ���ݽ�������Ų�ѯ������
	 * 
	 * @param code
	 * @return
	 */
	public int findStockinByCode(String code) {
		stockin = new Stockin();
		stockin.setCode(code);
		stockins = stockinService.findStockin(stockin);
		return stockins.size();
	}

	/**
	 * ������Ʒid��ѯ��Ʒ�۸�
	 * 
	 * @param mid
	 * @return
	 */
	public float findMerchandisePriceById(int mid) {
		float price = 0;
		Merchandise merchandise = new Merchandise();
		merchandise.setId(new Integer(mid));
		price = merchandiseService.findMerchandise(merchandise).get(0)
				.getPrice();
		return price;
	}

	/**
	 * ����������
	 * 
	 * @return
	 */
	public String saveStockin() {
		stockinService.saveStockin(stockin);
		finish_Url = "stockinAction!findStockin.action";
		stockin = null;
		return "finish";
	}

	/**
	 * ����������ǰ��ѯ
	 * 
	 * @return
	 */
	public String preUpdateStockin() {
		// ��ѯȫ����Ʒ����
		merchandises = merchandiseService.findMerchandise(null);
		// ��ѯȫ���ͻ�����
		clients = clientService.findClient(null);
		// ��ѯȫ��Ա������
		employees = employeeService.findEmployee(null);
		stockin = stockinService.findStockin(stockin).get(0);
		return "updateStockin";
	}

	/**
	 * ����������
	 * 
	 * @return
	 */
	public String updateStockin() {
		stockinService.updateStockin(stockin);
		finish_Url = "stockinAction!findStockin.action";
		stockin = null;
		return "finish";
	}

	/**
	 * ������ɾ��
	 * 
	 * @return
	 */
	public String deleteStockin() {
		stockinService.deleteStockin(stockinId);
		finish_Url = "stockinAction!findStockin.action";
		return "finish";
	}

	public IStockinService getStockinService() {
		return stockinService;
	}

	public void setStockinService(IStockinService stockinService) {
		this.stockinService = stockinService;
	}

	public IMerchandiseService getMerchandiseService() {
		return merchandiseService;
	}

	public void setMerchandiseService(IMerchandiseService merchandiseService) {
		this.merchandiseService = merchandiseService;
	}

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public IEmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Stockin getStockin() {
		return stockin;
	}

	public void setStockin(Stockin stockin) {
		this.stockin = stockin;
	}

	public List<Stockin> getStockins() {
		return stockins;
	}

	public void setStockins(List<Stockin> stockins) {
		this.stockins = stockins;
	}

	public List<Merchandise> getMerchandises() {
		return merchandises;
	}

	public void setMerchandises(List<Merchandise> merchandises) {
		this.merchandises = merchandises;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String getFinish_Url() {
		return finish_Url;
	}

	public void setFinish_Url(String finish_Url) {
		this.finish_Url = finish_Url;
	}

	public String[] getStockinId() {
		return stockinId;
	}

	public void setStockinId(String[] stockinId) {
		this.stockinId = stockinId;
	}

}
