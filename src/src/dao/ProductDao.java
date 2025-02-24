package dao;

import java.util.List;

import model.Product;

public interface ProductDao {
	
	// 新增產品
	void add(Product product);
	
	// 查詢產品
	List<Product> selectAll();
	List<Product> selectById(int id);
	List<Product> selectByName(String name);
	List<Product> selectByProductNo(String productNo);
	
	// 更新產品
	void update(Product product);
	
	// 刪除產品
	void delete(int id);
}
