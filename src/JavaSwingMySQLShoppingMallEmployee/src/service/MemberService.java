package service;

import model.Member;

public interface MemberService {
	
	// 增
	// 新增用戶
	void addMember(Member member);
	
	// 查
	// 登入
	Member Login(String username,String password);
	
	// 用戶名是否被使用
	boolean isUsernameBeenUse(String username);
	
	// 改
	
	
	// 刪
}
