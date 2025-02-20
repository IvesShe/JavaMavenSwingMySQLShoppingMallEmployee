package dao;

import java.util.List;

import model.ShopOrder;

public interface ShopOrderDao {
	// 增
	void add(ShopOrder shopOrder);
	
	// 查
	List<ShopOrder> selectAll();
	ShopOrder selectById(int id);
	List<ShopOrder> selectByShopOrderNo(String shopOrderNo);
	String selectMaxShopOrderNo();
	List<ShopOrder> selectByEmployeeNo(String employeeNo);
	List<ShopOrder> selectByConsumerNo(String consumerNo);
//	String countSQL = "SELECT COUNT(*) FROM orders WHERE shopOrderNo LIKE ?";
	
	// 更新
	void update(ShopOrder porder);
	
	// 刪
	void delete(int id);
}
