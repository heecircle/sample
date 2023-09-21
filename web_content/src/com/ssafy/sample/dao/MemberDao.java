package com.ssafy.sample.dao;

import com.ssafy.sample.dto.Member;

public interface MemberDao {
	boolean insertUser(Member user);//c
	Member getUser(Member user); // r
	boolean modifyUser(Member user, String orgId);//u
	boolean deleteUser(Member user); // d
}
