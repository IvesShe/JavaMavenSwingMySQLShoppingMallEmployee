package model;


import java.sql.Timestamp;

public class ShopOrder {
	private Integer id;	

	private String shopOrderNo;
	private String productNo;
	private String employeeNo;
	private String customerNo;	
	private Integer amount;	
	
	private Timestamp createdAt;  // 使用 Timestamp 類型
	private Timestamp updatedAt;  // 使用 Timestamp 類型
	
	

	public ShopOrder() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ShopOrder(String shopOrderNo, String productNo, String employeeNo, String customerNo,
			Integer amount) {
		super();
		this.shopOrderNo = shopOrderNo;
		this.productNo = productNo;
		this.employeeNo = employeeNo;
		this.customerNo = customerNo;
		this.amount = amount;
	}

	


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getShopOrderNo() {
		return shopOrderNo;
	}



	public void setShopOrderNo(String shopOrderNo) {
		this.shopOrderNo = shopOrderNo;
	}



	public String getProductNo() {
		return productNo;
	}



	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}



	public String getEmployeeNo() {
		return employeeNo;
	}



	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}



	public String getCustomerNo() {
		return customerNo;
	}



	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}



	public Integer getAmount() {
		return amount;
	}



	public void setAmount(Integer amount) {
		this.amount = amount;
	}



	public Timestamp getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}



	public Timestamp getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}



	public String showOrder(Boolean vipMember) {
		
	    
	    
	    return "";
	}
	
}
