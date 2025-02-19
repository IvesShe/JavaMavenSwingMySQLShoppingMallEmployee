package service.impl;

import java.util.List;

import dao.impl.ProductDaoImpl;
import model.Product;
import service.ProductService;
import util.Tool;

public class ProductServiceImpl implements ProductService {
	
	private static ProductDaoImpl productDaoImpl = new ProductDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addProduct(Product product) {
		
		productDaoImpl.add(product);		
	}


	@Override
	public boolean isNameBeenUse(String name) {
		
		return !productDaoImpl.selectByName(name).isEmpty();
	}

	@Override
	public String AllProduct() {
		List<Product> productList = productDaoImpl.selectAll();
		String show = "";
		
		for(Product e:productList)
		{
			show += String.format(
				    "id: %-5d ProductNo: %-6s Name: %-10s Price: %-10d 建立時間: %s 更新時間: %s",
				    e.getId(),
				    e.getProductNo(),
				    e.getName(),
				    e.getPrice(),
				    Tool.formatTimestamp(e.getCreatedAt()),
				    Tool.formatTimestamp(e.getUpdatedAt())
				);
			show += "\n";
		}
		
		return show+"";
	}

	@Override
	public List<Product> findAllProduct() {
		List<Product> productList = productDaoImpl.selectAll();
		return productList;
	}

	@Override
	public Product findById(int id) {
		List<Product> productList = productDaoImpl.selectById(id);
		
		return productList.size() > 0 ? productList.get(0):null;
	}

	@Override
	public List<Product> findByName(String name) {
		List<Product> productList = productDaoImpl.selectByName(name);
		return productList;
//		String show = "";
//		
//		for(Product e:productList)
//		{
//			show += String.format(
//				    "id: %-5d ProductNo: %-6s Name: %-10s Username: %-10s Password: %-10s Phone: %-10s Address: %-10s 建立時間: %s 更新時間: %s",
//				    e.getId(),
//				    e.getProductNo(),
//				    e.getName(),
//				    e.getUsername(),
//				    e.getPassword(),
//				    e.getPhone(),
//				    e.getAddress(),
//				    Tool.formatTimestamp(e.getCreatedAt()),
//				    Tool.formatTimestamp(e.getUpdatedAt())
//				);
//			show += "\n";
//		}
//		
//		return show+"";
	}

	@Override
	public void updateProduct(Product product) {
		
		productDaoImpl.update(product);
	}

	@Override
	public void delteProduct(int id) {
		
		productDaoImpl.delete(id);
	}

	@Override
	public boolean isProductNoBeenUse(String productNo) {
		
		return !productDaoImpl.selectByProductNo(productNo).isEmpty();
	}

}
