package service;

import java.util.List;

import model.Product;
import model.ShopOrder;

public interface ProductService {
	// 新增產品
	void addProduct(Product product);	
	
	
	// 查詢名稱是否被使用
	boolean isNameBeenUse(String name);	

		
	// 查詢產品
	String AllProduct();
	List<Product> findAllProduct();
	Product findById(int id);
	List<Product> findByName(String name);
	
	// 修改產品
	void updateProduct(Product product);
	
	// 刪除產品
	void delteProduct(int id);
	
	// 查詢產品編號是否被使用
	boolean isProductNoBeenUse(String productNo);	
}
