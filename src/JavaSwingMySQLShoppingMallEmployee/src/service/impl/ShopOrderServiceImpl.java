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
		StringBuilder show = new StringBuilder();
		
		allShopOrder
		.stream()
		.forEach((shopOrder)->{
			int sum = shopOrder.getMealNo1() * ShopOrder.getMealNo1Price() +
			          shopOrder.getMealNo2() * ShopOrder.getMealNo2Price();

			NumberFormat currencyFormat = NumberFormat.getNumberInstance(Locale.TAIWAN); // 使用千分位格式
			String formattedSum = currencyFormat.format(sum); // 轉換總價

			show.append(String.format(
			    "訂單編號：%-5d 客戶帳號：%-14s  1號餐：%3d 份  2號餐：%3d 份  總價：%10s 元  更新時間：%s  建立時間：%s%n",
			    shopOrder.getId(),
			    shopOrder.getName(),
			    shopOrder.getMealNo1(),
			    shopOrder.getMealNo2(),
			    formattedSum,  // 加入逗號格式的總價			    
			    Tool.formatTimestamp(shopOrder.getUpdatedAt()),
			    Tool.formatTimestamp(shopOrder.getCreatedAt())
			));
		});
		return show+"";
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
	public void updateShopOrder(Integer meal1, Integer meal2, int id) {
		ShopOrder shopOrder = shopOrderDaoImpl.selectById(id);
		if(meal1!=null) 
		{
			shopOrder.setMealNo1(meal1);
		}
		if(meal2!=null) 
		{
			shopOrder.setMealNo2(meal2);
		}
		shopOrderDaoImpl.update(shopOrder);		
	}

	@Override
	public void updateShopOrder(String name, int id) {
		ShopOrder shopOrder = shopOrderDaoImpl.selectById(id);
		shopOrder.setName(name);
		shopOrderDaoImpl.update(shopOrder);		
	}

	@Override
	public void delteShopOrder(int id) {
		shopOrderDaoImpl.delete(id);		
		
	}

	@Override
	public String findByUsername(String Username) {
		System.out.println(Username);
		List<ShopOrder> allShopOrder = shopOrderDaoImpl.selectByUsername(Username);
		String show="";
		for(ShopOrder shopOrder:allShopOrder)
		{
//			import java.text.NumberFormat;
//			import java.util.Locale;
			int sum = shopOrder.getMealNo1() * ShopOrder.getMealNo1Price() +
			          shopOrder.getMealNo2() * ShopOrder.getMealNo2Price();

			NumberFormat currencyFormat = NumberFormat.getNumberInstance(Locale.TAIWAN); // 使用千分位格式
			String formattedSum = currencyFormat.format(sum); // 轉換總價

			show += String.format(
			    "訂單編號：%-5d 客戶帳號：%-14s  1號餐：%3d 份  2號餐：%3d 份  總價：%10s 元  更新時間：%s  建立時間：%s%n",
			    shopOrder.getId(),
			    shopOrder.getName(),
			    shopOrder.getMealNo1(),
			    shopOrder.getMealNo2(),
			    formattedSum,  // 加入逗號格式的總價			    
			    Tool.formatTimestamp(shopOrder.getUpdatedAt()),
			    Tool.formatTimestamp(shopOrder.getCreatedAt())
			);
		}
		return show;
	}

}
