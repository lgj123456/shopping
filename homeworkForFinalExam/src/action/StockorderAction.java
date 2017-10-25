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
	private IStockorderService stockorderService;// 订货单业务处理接口
	private IMerchandiseService merchandiseService;// 商品档案业务处理接口
	private IClientService clientService;// 客户档案业务处理接口
	private IEmployeeService employeeService;// 员工档案业务处理接口
	private Stockorder stockorder;// 作为条件的对象
	private List<Stockorder> stockorders;// 订货单查询结果
	private List<Merchandise> merchandises;// 商品查询结果
	private List<Client> clients;// 客户查询结果
	private List<Employee> employees;// 员工查询结果
	private String finish_Url;// 操作完成跳转的地址
	private String[] stockorderId;// 要删除订货单的ID

	/**
	 * 查询订货单前商品、客户、员工档案查询(下拉框)
	 * 
	 * @return
	 */
	public String preFindStockorder() {
		System.out.println("preFindStockorder");
		// 查询全部商品档案
		merchandises = merchandiseService.findMerchandise(null);
		// 查询全部客户档案
		clients = clientService.findClient(null);
		// 查询全部员工档案
		employees = employeeService.findEmployee(null);
		return "preFindStockorder";
	}

	/**
	 * 订货单查询
	 * 
	 * @return
	 */
	public String findStockorder() {
		stockorders = stockorderService.findStockorder(stockorder);
		return "findStockorder";
	}

	/**
	 * 新增订货单前商品、客户、员工档案查询(下拉框)
	 * 
	 * @return
	 */
	public String preSaveStockorder() {
		// 查询全部商品档案
		merchandises = merchandiseService.findMerchandise(null);
		// 查询全部客户档案
		clients = clientService.findClient(null);
		// 查询全部员工档案
		employees = employeeService.findEmployee(null);
		return "preSaveStockorder";
	}

	/**
	 * 根据订货单编号查询订货单
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
	 * 订货单新增
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
	 * 订货单更新前查询
	 * 
	 * @return
	 */
	public String preUpdateStockorder() {
		// 查询全部商品档案
		merchandises = merchandiseService.findMerchandise(null);
		// 查询全部客户档案
		clients = clientService.findClient(null);
		// 查询全部员工档案
		employees = employeeService.findEmployee(null);
		stockorder = stockorderService.findStockorder(stockorder).get(0);
		return "updateStockorder";
	}

	/**
	 * 订货单更新
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
	 * 订货单删除
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
