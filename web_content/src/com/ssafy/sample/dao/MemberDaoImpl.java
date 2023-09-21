package com.ssafy.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.util.DBUtil;

public class MemberDaoImpl implements MemberDao{
	private static MemberDaoImpl manager = new MemberDaoImpl();
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		return manager;
	}
	@Override
	public boolean insertUser(Member user) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			String id =  user.getId();
			String pass = user.getPassword();
			String name = user.getName();
			int age = user.getAge();
			PreparedStatement pstmt = conn.prepareStatement("insert member (id,password, name, age) values (?,?, ? ,?)");
			
			pstmt.setString(1,id);
			pstmt.setString(2, pass);
			pstmt.setString(3, name);
			pstmt.setInt(4, age);
			System.out.printf("insert member (id,password, name, age) values (%s,%s, %s ,%d)", id, pass, name, age);
			pstmt.executeUpdate();
			System.out.println("?FLAKFJLKDSJF");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}

	@Override
	public Member getUser(Member user) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from member where id = '?'");
			pstmt.setString(1, user.getId());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				return new Member(rs.getString("id"), rs.getString("password"), rs.getString("name"), Integer.parseInt(rs.getString("age")));
			}
			return null;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean modifyUser(Member user, String orgId) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update  member set id ='?', password = '?', name = '?', age = '?'  from member where id = '?'");
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setInt(4, user.getAge());
			pstmt.setString(5, orgId);

			
			pstmt.executeUpdate();
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteUser(Member user) {
		// TODO Auto-generated method stub
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("delete member where id = '?'");
			pstmt.setString(1, user.getId());
			
			
			pstmt.executeUpdate();
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
