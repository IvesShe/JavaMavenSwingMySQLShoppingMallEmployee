package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	// 增
	void add(Member member);
	
	// 查
	List<Member> selectAll();//select * from member
	List<Member> selectUsernameAndPassword(String username,String password);//select * from member where username=? and password=?
	List<Member> selectById(int id);
	List<Member> selectByUsername(String username);
	
	// 改
	void update(Member member);
	
	// 刪
	void delete(int id);
}
