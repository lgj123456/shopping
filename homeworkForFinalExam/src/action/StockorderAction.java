package action;

import java.util.List;

import entity.Client;
import entity.Employee;
import entity.Merchandise;
import entity.Stockorder;

import service.IClientService;
import service.IEmployeeService;
import service.IMerchandiseService;
import service.IStockorderService;



public class StockorderAction {
	private IStockorderService stockorderService;// ������ҵ����ӿ�
	private IMerchandiseService merchandiseService;// ��Ʒ����ҵ����ӿ�
	private IClientService clientService;// �ͻ�����ҵ����ӿ�
	private IEmployeeService employeeService;// Ա������ҵ����ӿ�
	private Stockorder stockorder;// ��Ϊ�����Ķ���
	private List<Stockorder> stockorders;// ��������ѯ���
	private List<Merchandise> merchandises;// ��Ʒ��ѯ���
	private List<Client> clients;// �ͻ���ѯ���
	private List<Employee> employees;// Ա����ѯ���
	private String finish_Url;// ���������ת�ĵ�ַ
	private String[] stockorderId;// Ҫɾ����������ID

	/**
	 * ��ѯ������ǰ��Ʒ���ͻ���Ա��������ѯ(������)
	 * 
	 * @return
	 */
	public String preFindStockorder() {
		System.out.println("preFindStockorder");
		// ��ѯȫ����Ʒ����
		merchandises = merchandiseService.findMerchandise(null);
		// ��ѯȫ���ͻ�����
		clients = clientService.findClient(null);
		// ��ѯȫ��Ա������
		employees = employeeService.findEmployee(null);
		return "preFindStockorder";
	}

	/**
	 * ��������ѯ
	 * 
	 * @return
	 */
	public String findStockorder() {
		stockorders = stockorderService.findStockorder(stockorder);
		return "findStockorder";
	}

	/**
	 * ����������ǰ��Ʒ���ͻ���Ա��������ѯ(������)
	 * 
	 * @return
	 */
	public String preSaveStockorder() {
		// ��ѯȫ����Ʒ����
		merchandises = merchandiseService.findMerchandise(null);
		// ��ѯȫ���ͻ�����
		clients = clientService.findClient(null);
		// ��ѯȫ��Ա������
		employees = employeeService.findEmployee(null);
		return "preSaveStockorder";
	}

	/**
	 * ���ݶ�������Ų�ѯ������
	 * 
	 * @param code
	 * @return
	 */
	public int findStockorderByCode(String code) {
		stockorder = new Stockorder();
		stockorder.setCode(code);
		stockorders = stockorderService.findStockorder(stockorder);
		return stockorders.size();
	}

	/**
	 * ����������
	 * 
	 * @return
	 */
	public String saveStockorder() {
		stockorderService.saveStockorder(stockorder);
		finish_Url = "stockorderAction!findStockorder.action";
		stockorder = null;
		return "finish";
	}

	/**
	 * ����������ǰ��ѯ
	 * 
	 * @return
	 */
	public String preUpdateStockorder() {
		// ��ѯȫ����Ʒ����
		merchandises = merchandiseService.findMerchandise(null);
		// ��ѯȫ���ͻ�����
		clients = clientService.findClient(null);
		// ��ѯȫ��Ա������
		employees = employeeService.findEmployee(null);
		stockorder = stockorderService.findStockorder(stockorder).get(0);
		return "updateStockorder";
	}

	/**
	 * ����������
	 * 
	 * @return
	 */
	public String updateStockorder() {
		stockorderService.updateStockorder(stockorder);
		finish_Url = "stockorderAction!findStockorder.action";
		stockorder = null;
		return "finish";
	}

	/**
	 * ������ɾ��
	 * 
	 * @return
	 */
	public String deleteStockorder() {
		stockorderService.deleteStockorder(stockorderId);
		finish_Url = "stockorderAction!findStockorder.action";
		return "finish";
	}

	public IStockorderService getStockorderService() {
		return stockorderService;
	}

	public void setStockorderService(IStockorderService stockorderService) {
		this.stockorderService = stockorderService;
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

	public Stockorder getStockorder() {
		return stockorder;
	}

	public void setStockorder(Stockorder stockorder) {
		this.stockorder = stockorder;
	}

	public List<Stockorder> getStockorders() {
		return stockorders;
	}

	public void setStockorders(List<Stockorder> stockorders) {
		this.stockorders = stockorders;
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

	public String[] getStockorderId() {
		return stockorderId;
	}

	public void setStockorderId(String[] stockorderId) {
		this.stockorderId = stockorderId;
	}

}
