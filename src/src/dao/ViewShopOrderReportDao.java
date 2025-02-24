package dao;

import java.util.List;

import model.ViewShopOrderReport;

public interface ViewShopOrderReportDao {	
	
	// 查詢
	List<ViewShopOrderReport> selectAll();
	List<ViewShopOrderReport> selectByConsumerNo(String consumerNo);

}
