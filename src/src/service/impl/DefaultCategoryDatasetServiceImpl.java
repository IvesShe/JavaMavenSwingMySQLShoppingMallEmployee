package service.impl;

import org.jfree.data.category.DefaultCategoryDataset;

import dao.impl.DefaultCategoryDatasetDaoImpl;
import service.DefaultCategoryDatasetService;

public class DefaultCategoryDatasetServiceImpl implements DefaultCategoryDatasetService {
	
	private static DefaultCategoryDatasetDaoImpl defaultCategoryDatasetDaoImpl = new DefaultCategoryDatasetDaoImpl();

	public static void main(String[] args) {
		
		System.out.println(new DefaultCategoryDatasetServiceImpl().findAllDefaultCategoryDataset());
		
	}

	@Override
	public DefaultCategoryDataset findAllDefaultCategoryDataset() {
		
		return defaultCategoryDatasetDaoImpl.selectAll();
	}

	

}
