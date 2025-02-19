package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.ConsumerDaoImpl;
import model.Consumer;
import service.ConsumerService;
import util.Tool;

public class ConsumerServiceImpl implements ConsumerService {
	
	private static ConsumerDaoImpl consumerDaoImpl = new ConsumerDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addConsumer(Consumer consumer) {
		
		consumerDaoImpl.add(consumer);		
	}

	@Override
	public Consumer Login(String username, String password) {
		Consumer consumer = null;
		
		List<Consumer> consumerList = new ArrayList<>();
		consumerList = consumerDaoImpl.selectUsernameAndPassword(username, password);
		if(consumerList.size()>0)
		{
			consumer = consumerList.get(0);
		}
		
		return consumer;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		
		return !consumerDaoImpl.selectByUsername(username).isEmpty();
	}

	@Override
	public String AllConsumer() {
		List<Consumer> consumerList = consumerDaoImpl.selectAll();
		String show = "";
		
		for(Consumer e:consumerList)
		{
			show += String.format(
				    "id: %-5d ConsumerNo: %-6s Name: %-10s Username: %-10s Password: %-10s Phone: %-10s Address: %-10s 建立時間: %s 更新時間: %s",
				    e.getId(),
				    e.getConsumerNo(),
				    e.getName(),
				    e.getUsername(),
				    e.getPassword(),
				    e.getPhone(),
				    e.getAddress(),
				    Tool.formatTimestamp(e.getCreatedAt()),
				    Tool.formatTimestamp(e.getUpdatedAt())
				);
			show += "\n";
		}
		
		return show+"";
	}

	@Override
	public List<Consumer> findAllConsumer() {
		List<Consumer> consumerList = consumerDaoImpl.selectAll();
		return consumerList;
	}

	@Override
	public Consumer findById(int id) {
		List<Consumer> consumerList = consumerDaoImpl.selectById(id);
		
		return consumerList.size() > 0 ? consumerList.get(0):null;
	}

	@Override
	public List<Consumer> findByUsername(String username) {
		List<Consumer> consumerList = consumerDaoImpl.selectByUsername(username);
		return consumerList;
//		String show = "";
//		
//		for(Consumer e:consumerList)
//		{
//			show += String.format(
//				    "id: %-5d ConsumerNo: %-6s Name: %-10s Username: %-10s Password: %-10s Phone: %-10s Address: %-10s 建立時間: %s 更新時間: %s",
//				    e.getId(),
//				    e.getConsumerNo(),
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
	public void updateConsumer(Consumer consumer) {
		
		consumerDaoImpl.update(consumer);
	}

	@Override
	public void delteConsumer(int id) {
		
		consumerDaoImpl.delete(id);
	}

	@Override
	public boolean isConsumerNoBeenUse(String consumerNo) {
		
		return !consumerDaoImpl.selectByConsumerNo(consumerNo).isEmpty();
	}

}
