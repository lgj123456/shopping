package entity;

import java.util.HashSet;
import java.util.Set;

public class Client {
	private Integer id;
	private String code;
	private String name;
	private String address;
	private String telephone;
	private String email;
	private Set<Stockin> stockins = new HashSet<>();
	private Set<Stockorder> stockorders = new HashSet<>();

	public Set<Stockin> getStockins() {
		return stockins;
	}

	public void setStockins(Set<Stockin> stockins) {
		this.stockins = stockins;
	}

	public Set<Stockorder> getStockorders() {
		return stockorders;
	}

	public void setStockorders(Set<Stockorder> stockorders) {
		this.stockorders = stockorders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
