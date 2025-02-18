package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService {

	public static void main(String[] args) {
		
//		Member member = new Member("gg","ccb","655","台南","13939","2889");
//		new MemberServiceImpl().addMember(member);
		
//		System.out.println(new MemberServiceImpl().Login("bb", "555"));

		System.out.println(new MemberServiceImpl().isUsernameBeenUse("bb"));
		
		
	}

	private static MemberDaoImpl memberDaoImpl = new MemberDaoImpl();
	
	@Override
	public void addMember(Member member) {
		memberDaoImpl.add(member);
		
	}

	@Override
	public Member Login(String username, String password) {
		Member member = null;
		
		List<Member> allMember = new ArrayList<Member>(); 
		allMember = memberDaoImpl.selectUsernameAndPassword(username, password);
		if(allMember.size()>0)
		{
			member = allMember.get(0);
		}
		
		return member;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		
		return !memberDaoImpl.selectByUsername(username).isEmpty();
	}
	
	

}
