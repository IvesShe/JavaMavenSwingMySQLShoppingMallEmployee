package model;

import java.io.Serializable;

public class ViewShopOrderReport implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String shopOrderNo;
	private String consumerNo;
	private String consumerName;
	private String phone;
	private String address;
	private String employeeName;
	private String productName;
	private Integer price;
	private Integer amount;
	public ViewShopOrderReport() {
		super();
		
	}
	
	public String getShopOrderNo() {
		return shopOrderNo;
	}
	public void setShopOrderNo(String shopOrderNo) {
		this.shopOrderNo = shopOrderNo;
	}
	public String getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(String consumerNo) {
		this.consumerNo = consumerNo;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Integer getTotoal()
	{
		return this.getAmount()*this.getPrice();
	}
	
	
}
