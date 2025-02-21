package service;

import java.util.List;

import model.ViewShopOrderReport;

public interface ViewShopOrderReportService {
	
	
	// 查詢

	List<ViewShopOrderReport> findAllViewShopOrderReport();
	List<ViewShopOrderReport> findByConsumerNo(String consumerNo);
	
 

}
