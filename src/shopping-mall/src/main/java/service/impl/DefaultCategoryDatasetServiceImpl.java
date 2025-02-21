package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jfree.data.category.DefaultCategoryDataset;

import dao.impl.ConsumerDaoImpl;
import dao.impl.DefaultCategoryDatasetDaoImpl;
import model.Consumer;
import service.ConsumerService;
import service.DefaultCategoryDatasetService;
import util.Tool;

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
