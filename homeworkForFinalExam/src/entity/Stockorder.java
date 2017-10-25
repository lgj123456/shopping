package entity;

public class Stockorder {
	private Integer id;// 订货单ID
	private Merchandise merchandise;// 商号编号
	private Client client;// 客户编号
	private Employee employee;// 员工编号
	private String code;// 订货单编号
	private int merchandisenumber;// 订货数量
	private String orderdate;// 订货日期

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Merchandise getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getMerchandisenumber() {
		return merchandisenumber;
	}

	public void setMerchandisenumber(int merchandisenumber) {
		this.merchandisenumber = merchandisenumber;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		if (orderdate != null && orderdate.length() >= 10) {
			orderdate = orderdate.substring(0, 10);
		}
		this.orderdate = orderdate;
	}

}
