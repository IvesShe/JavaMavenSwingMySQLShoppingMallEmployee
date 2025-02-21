package dao;

import java.util.List;

import org.jfree.data.category.DefaultCategoryDataset;

import model.Product;

public interface DefaultCategoryDatasetDao {
	// 查詢消售狀況
	DefaultCategoryDataset selectAll();
}
