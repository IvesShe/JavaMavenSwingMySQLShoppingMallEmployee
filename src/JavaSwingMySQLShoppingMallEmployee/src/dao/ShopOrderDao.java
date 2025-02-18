package dao;

import java.util.List;

import model.ShopOrder;

public interface ShopOrderDao {
	// 增
	void add(ShopOrder shopOrder);
	
	// 查
	List<ShopOrder> selectAll();
	ShopOrder selectById(int id);
	List<ShopOrder> selectByUsername(String username);
	
	// 更新
	void update(ShopOrder porder);
	
	// 刪
	void delete(int id);
}
