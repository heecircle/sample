package com.ssafy.sample.service;

import java.util.ArrayList;

import com.ssafy.sample.dto.Product;

public interface ProductService {
	boolean registerProduct(Product product); // c
	Product getProductInfo(Product product); // r
	boolean modifyProductInfo(Product product, int orgIdx);//u
	boolean withdrawProduct(Product product); // d
	ArrayList<Product> showProductsInfo(int startidx, int cnt);
}
