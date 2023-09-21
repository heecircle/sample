package com.ssafy.sample.service;

import com.ssafy.sample.dto.Member;

public interface MemberService {
	boolean registerUser(Member member); // c
	Member getUserInfo(String userid, String userpass); // r
	boolean modifyUserInfo(Member modifiedInfo, String orgId);//u
	boolean withdrawUser(String userpass, String userid); // d
}
