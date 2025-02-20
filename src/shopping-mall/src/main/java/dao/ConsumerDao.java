package dao;

import java.util.List;

import model.Consumer;

public interface ConsumerDao {
	
	// 新增顧客
	void add(Consumer consumer);
	
	// 查詢顧客
	List<Consumer> selectAll();
	List<Consumer> selectUsernameAndPassword(String username,String password);
	List<Consumer> selectById(int id);
	List<Consumer> selectByUsername(String username);
	List<Consumer> selectByConsumerNo(String consumerNo);
	
	// 更新顧客
	void update(Consumer consumer);
	
	// 刪除顧客
	void delete(int id);
}
