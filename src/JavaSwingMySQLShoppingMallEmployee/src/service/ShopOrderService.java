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
	String findByShopOrderNo(String shopOrderNo);
	
	// 改
	void updateShopOrder(ShopOrder shopOrder);
	
	// 刪
	void delteShopOrder(int id);
	
	// 查詢訂單編號是否被使用
	boolean isShopOrderNoBeenUse(String username);	
	
	// 產生唯一的 shopOrderNo
    String generateShopOrderNo();

}
