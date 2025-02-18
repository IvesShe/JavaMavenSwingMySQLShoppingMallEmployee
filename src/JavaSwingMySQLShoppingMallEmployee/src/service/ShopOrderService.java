package service;

import java.util.List;

import model.ShopOrder;

public interface ShopOrderService {
	// 增
	// 新增訂單
	void addShopOrder(ShopOrder shopOrder);
	
	// 查
	String AllShopOrder();
	List<ShopOrder> findAllShopOrder();
	ShopOrder findById(int id);
	String findByUsername(String Username);
	
	// 改
	void updateShopOrder(ShopOrder shopOrder);
	void updateShopOrder(Integer meal1,Integer meal2,int id);
	void updateShopOrder(String name,int id);
	
	// 刪
	void delteShopOrder(int id);

}
