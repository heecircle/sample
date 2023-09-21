package com.ssafy.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.sample.dto.Member;
import com.ssafy.sample.dto.Product;
import com.ssafy.sample.util.DBUtil;

public class ProductDaoImpl implements ProductDao{
private static ProductDaoImpl manager = new ProductDaoImpl();
	
	private ProductDaoImpl() {}
	
	public static ProductDaoImpl getInstance() {
		return manager;
	}
	@Override
	public boolean insertProduct(Product product) {
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert member (name, price, describe_) values (?, ? ,?)");
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getDescribe());
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public Product getProduct(Product product) {

		try {
			Connection conn = DBUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from product where productid = ?");
			pstmt.setInt(1, product.getIdx());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				return new Product(Integer.parseInt(rs.getString("productid")), rs.getString("name"), Integer.parseInt(rs.getString("price")), rs.getString("describe_"));
			}
			return null;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	

	@Override
	public boolean modifyProduct(Product product, int orgProductIdx) {
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update  product set name = '?', price = ? , decribe_ = '?' where productid = ?");
			
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getDescribe());
			pstmt.setInt(4, orgProductIdx);

			
			pstmt.executeUpdate();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("delete product where productidx = '?'");
			pstmt.setInt(1, product.getIdx());
			
			
			pstmt.executeUpdate();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Product> getProductbyPage(int startidx, int cnt) {
		try {
			Connection conn = DBUtil.getInstance().getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from product limit ? , ?");
			pstmt.setInt(1, startidx);
			pstmt.setInt(2, cnt);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<Product> products = new ArrayList<>();
			
			while(rs.next()) {
				products.add(new Product(Integer.parseInt(rs.getString("productid")), rs.getString("name"), Integer.parseInt(rs.getString("price")), rs.getString("describe_")));
				
			}
			return products;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}
