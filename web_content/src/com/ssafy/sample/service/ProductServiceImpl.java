package com.ssafy.sample.service;

import java.util.ArrayList;

import com.ssafy.sample.dao.ProductDaoImpl;
import com.ssafy.sample.dto.Product;

public class ProductServiceImpl implements ProductService{
	private static ProductServiceImpl manager = new ProductServiceImpl();
	private ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	public static ProductServiceImpl getInstance() {
		return manager;
	}
	@Override
	public boolean registerProduct(Product product) {
		if(ProductDaoImpl.getInstance().getProduct(product) == null) {
			return ProductDaoImpl.getInstance().insertProduct(product);
		}
		return false;
	}

	@Override
	public Product getProductInfo(Product product) {
		
		return ProductDaoImpl.getInstance().getProduct(product);
	}

	@Override
	public boolean modifyProductInfo(Product product, int orgIdx) {
		
		return ProductDaoImpl.getInstance().modifyProduct(product, orgIdx);
	}

	@Override
	public boolean withdrawProduct(Product product) {

		return ProductDaoImpl.getInstance().deleteProduct(product);
	}

	@Override
	public ArrayList<Product> showProductsInfo(int startidx, int cnt) {
		
		return ProductDaoImpl.getInstance().getProductbyPage(startidx, cnt);
	}


}
