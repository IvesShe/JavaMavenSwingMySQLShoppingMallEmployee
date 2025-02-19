package service;

import java.util.List;

import model.Consumer;

public interface ConsumerService {
	// 新增員工
	void addConsumer(Consumer consumer);	
	
	// 員工登入
	Consumer Login(String username,String password);
	
	// 查詢名稱是否被使用
	boolean isUsernameBeenUse(String username);	

		
	// 查詢員工
	String AllConsumer();
	List<Consumer> findAllConsumer();
	Consumer findById(int id);
	List<Consumer> findByUsername(String username);
	
	// 修改員工
	void updateConsumer(Consumer consumer);
	
	// 刪除員工
	void delteConsumer(int id);
	
	// 查詢員工編號是否被使用
	boolean isConsumerNoBeenUse(String consumerNo);	
}
