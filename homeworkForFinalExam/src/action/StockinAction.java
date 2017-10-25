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
	private IStockinService stockinService;// 进货单业务处理接口
	private IMerchandiseService merchandiseService;// 商品档案业务处理接口
	private IClientService clientService;// 客户档案业务处理接口
	private IEmployeeService employeeService;// 员工档案业务处理接口
	private Stockin stockin;// 作为条件的对象
	private List<Stockin> stockins;// 进货单查询结果
	private List<Merchandise> merchandises;// 商品查询结果
	private List<Client> clients;// 客户查询结果
	private List<Employee> employees;// 员工查询结果
	private String finish_Url;// 操作完成跳转的地址
	private String[] stockinId;// 要删除进货单的ID

	/**
	 * 查询进货单前商品、客户、员工档案查询
	 * 
	 * @return
	 */
	public String preFindStockin() {
		// 查询全部商品档案
		merchandises = merchandiseService.findMerchandise(null);
		// 查询全部客户档案
		clients = clientService.findClient(null);
		// 查询全部员工档案
		employees = employeeService.findEmployee(null);
		return "preFindStockin";
	}

	/**
	 * 进货单查询
	 * 
	 * @return
	 */
	public String findStockin() {
		stockins = stockinService.findStockin(stockin);
		return "findStockin";
	}

	/**
	 * 保存进货单前商品、客户、员工档案查询
	 * 
	 * @return
	 */
	public String preSaveStockin() {
		// 查询全部商品档案
		merchandises = merchandiseService.findMerchandise(null);
		// 查询全部客户档案
		clients = clientService.findClient(null);
		// 查询全部员工档案
		employees = employeeService.findEmployee(null);
		return "preSaveStockin";
	}

	/**
	 * 根据进货单编号查询进货单
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
	 * 根据商品id查询商品价格
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
	 * 进货单保存
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
	 * 进货单更新前查询
	 * 
	 * @return
	 */
	public String preUpdateStockin() {
		// 查询全部商品档案
		merchandises = merchandiseService.findMerchandise(null);
		// 查询全部客户档案
		clients = clientService.findClient(null);
		// 查询全部员工档案
		employees = employeeService.findEmployee(null);
		stockin = stockinService.findStockin(stockin).get(0);
		return "updateStockin";
	}

	/**
	 * 进货单更新
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
	 * 进货单删除
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
