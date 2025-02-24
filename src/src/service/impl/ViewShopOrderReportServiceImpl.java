package service.impl;

import java.util.List;

import dao.impl.ViewShopOrderReportDaoImpl;
import model.ViewShopOrderReport;
import service.ViewShopOrderReportService;

public class ViewShopOrderReportServiceImpl implements ViewShopOrderReportService{
	
	private static ViewShopOrderReportDaoImpl viewShopOrderReportDaoImpl = new ViewShopOrderReportDaoImpl();


	public static void main(String[] args) {
		
//		ShopOrder shopOrder = new ShopOrder("tim",71,8);
//		new ShopOrderServiceImpl().addShopOrder(shopOrder);
		
//		System.out.println(new ViewShopOrderReportServiceImpl().AllShopOrder());
		
		System.out.println(new ViewShopOrderReportServiceImpl().findAllViewShopOrderReport());
		
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
	public List<ViewShopOrderReport> findAllViewShopOrderReport() {
		
		return viewShopOrderReportDaoImpl.selectAll();
	}


	@Override
	public List<ViewShopOrderReport> findByConsumerNo(String consumerNo) {
		
		return viewShopOrderReportDaoImpl.selectByConsumerNo(consumerNo);
	}

	

}
