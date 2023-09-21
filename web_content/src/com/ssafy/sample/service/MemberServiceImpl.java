package com.ssafy.sample.service;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.dao.MemberDaoImpl;
public class MemberServiceImpl implements MemberService{
	
	
	private static MemberServiceImpl manager = new MemberServiceImpl();
	private MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	public static MemberServiceImpl getInstance() {
		return manager;
	}
	
	
	@Override
	public boolean registerUser(Member member) {
		// TODO Auto-generated method stub
		if(MemberDaoImpl.getInstance().getUser(member) == null) {
			return MemberDaoImpl.getInstance().insertUser(member);
		}
		return false;
		
	}

	@Override
	public Member getUserInfo(String userid, String userpass) {
		return MemberDaoImpl.getInstance().getUser(new Member(userid, userpass, null, 0));
		
		
	}

	@Override
	public boolean modifyUserInfo(Member modifiedInfo, String orgId) {
		// TODO Auto-generated method stub
		return MemberDaoImpl.getInstance().modifyUser(modifiedInfo, orgId);
	}

	@Override
	public boolean withdrawUser(String userpass, String userid) {
		return MemberDaoImpl.getInstance().deleteUser(new Member(userid, userpass, null, 0));
	}

}
