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
		
	    
	    
//	    String outputMessage = String.format(
//	            "---------------------------------------------------------\n" +
//	            "訂單時間: %s\n" +  
//	            "您的名字是：%s\n" +
//	            "1號餐份數：%d\n" +
//	            "2號餐份數：%d\n\n" +
//	            "成交金額：\n" +
//	            "1號餐 %d 元 x %d 份 + 2號餐 %d 元 x %d 份 = %d 元",
//	            currentTime,  // 顯示當前時間
//	            this.getName(),
//	            this.getMealNo1(),
//	            this.getMealNo2(),
//	            ShopOrder.getMealNo1Price(),
//	            this.getMealNo1(),
//	            ShopOrder.getMealNo2Price(),
//	            this.getMealNo2(),
//	            this.getSum()
//	    );
//
//	    if (vipMember) {
//	        outputMessage += String.format(
//	                "\n您是VIP會員，享有九折優惠\n" +
//	                "折扣金額：%d 元\n" +
//	                "實付金額：%d 元",
//	                (this.getSum() - (int)(this.getSum() * 0.9)),
//	                (int)(this.getSum() * 0.9)
//	        );
//	    } else {
//	        outputMessage += "\n您是一般會員，無任何優惠";
//	    }

//	    outputMessage += "\n---------------------------------------------------------";
	    return "";//outputMessage;
	}
	
}
