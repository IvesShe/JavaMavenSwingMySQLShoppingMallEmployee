package service.impl;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import dao.impl.ShopOrderDaoImpl;
import model.ShopOrder;
import service.ShopOrderService;
import util.Tool;

public class ShopOrderServiceImpl implements ShopOrderService{
	
	private static ShopOrderDaoImpl shopOrderDaoImpl = new ShopOrderDaoImpl();


	public static void main(String[] args) {
		
//		ShopOrder shopOrder = new ShopOrder("tim",71,8);
//		new ShopOrderServiceImpl().addShopOrder(shopOrder);
		
		System.out.println(new ShopOrderServiceImpl().AllShopOrder());
		
//		System.out.println(new ShopOrderServiceImpl().findAllShopOrder());
		
//		ShopOrder shopOrder = new ShopOrderServiceImpl().findById(7);
//		System.out.println(
//				"id: "+shopOrder.getId()
//				+"\tName: "+shopOrder.getName()
//				+"\tMealNo1: "+shopOrder.getMealNo1()
//				+"\tMealNo2: "+shopOrder.getMealNo2()
//				+"\t建立時間: "+Tool.formatTimestamp(shopOrder.getCreatedAt())
//				+"\t更新時間: "+Tool.formatTimestamp(shopOrder.getUpdatedAt())
//				);
		
//		ShopOrder shopOrder = new ShopOrderServiceImpl().findById(7);
//		shopOrder.setMealNo1(1);
//		shopOrder.setMealNo2(1);
//		new ShopOrderServiceImpl().updateShopOrder(shopOrder);
		
//		new ShopOrderServiceImpl().updateShopOrder("kk", 6);
		
//		new ShopOrderServiceImpl().delteShopOrder(7);
		
		
		
	}

	@Override
	public void addShopOrder(ShopOrder shopOrder) {
		
		shopOrderDaoImpl.add(shopOrder);
	}
	

	@Override
	public String AllShopOrder() {
		
		List<ShopOrder> allShopOrder = shopOrderDaoImpl.selectAll();
		String show="";
		for(ShopOrder shopOrder:allShopOrder)
		{
			int sum = 0;//shopOrder.getMealNo1() * ShopOrder.getMealNo1Price() +
			          //shopOrder.getMealNo2() * ShopOrder.getMealNo2Price();

			NumberFormat currencyFormat = NumberFormat.getNumberInstance(Locale.TAIWAN); // 使用千分位格式
			String formattedSum = currencyFormat.format(sum); // 轉換總價

			show += String.format(
				    "id: %-5d Name: %-10s ShopOrderNo: %-6s ProductNo: %-6s EmployeeNo: %-6s CustomerNo: %-6s Amount: %-6d 建立時間: %s 更新時間: %s",
				    shopOrder.getId(),
				    shopOrder.getShopOrderNo(),
				    shopOrder.getProductNo(),
				    shopOrder.getEmployeeNo(),
				    shopOrder.getCustomerNo(),
				    shopOrder.getAmount(),
				    Tool.formatTimestamp(shopOrder.getCreatedAt()),
				    Tool.formatTimestamp(shopOrder.getUpdatedAt())
				);								
		}
		return show;
	}

	@Override
	public List<ShopOrder> findAllShopOrder() {
		
		return shopOrderDaoImpl.selectAll();
	}

	@Override
	public ShopOrder findById(int id) {		
		
		return shopOrderDaoImpl.selectById(id);
	}

	@Override
	public void updateShopOrder(ShopOrder shopOrder) {		
		shopOrderDaoImpl.update(shopOrder);
	}


	@Override
	public void delteShopOrder(int id) {
		shopOrderDaoImpl.delete(id);		
		
	}

	@Override
	public String findByShopOrderNo(String shopOrderNo) {
		List<ShopOrder> allShopOrder = shopOrderDaoImpl.selectByShopOrderNo(shopOrderNo);
		String show="";
		for(ShopOrder shopOrder:allShopOrder)
		{
			int sum = 0;//shopOrder.getMealNo1() * ShopOrder.getMealNo1Price() +
			          //shopOrder.getMealNo2() * ShopOrder.getMealNo2Price();

			NumberFormat currencyFormat = NumberFormat.getNumberInstance(Locale.TAIWAN); // 使用千分位格式
			String formattedSum = currencyFormat.format(sum); // 轉換總價

			show += String.format(
				    "id: %-5d Name: %-10s ShopOrderNo: %-6s ProductNo: %-6s EmployeeNo: %-6s CustomerNo: %-6s Amount: %-6d 建立時間: %s 更新時間: %s",
				    shopOrder.getId(),
				    shopOrder.getShopOrderNo(),
				    shopOrder.getProductNo(),
				    shopOrder.getEmployeeNo(),
				    shopOrder.getCustomerNo(),
				    shopOrder.getAmount(),
				    Tool.formatTimestamp(shopOrder.getCreatedAt()),
				    Tool.formatTimestamp(shopOrder.getUpdatedAt())
				);								
		}
		return show;
	}
	
	@Override
	public boolean isShopOrderNoBeenUse(String shopOrderNo) {
		
		return !shopOrderDaoImpl.selectByShopOrderNo(shopOrderNo).isEmpty();
	}

}
