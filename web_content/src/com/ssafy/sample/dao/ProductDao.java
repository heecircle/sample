package com.ssafy.sample.dao;

import java.util.ArrayList;

import com.ssafy.sample.dto.Product;

public interface ProductDao {
	boolean insertProduct(Product product);//c
	Product getProduct(Product product); // r
	boolean modifyProduct(Product product, int orgProductIdx);//u
	boolean deleteProduct(Product product); // d
	
	ArrayList<Product> getProductbyPage(int startidx, int cnt); // r
}
