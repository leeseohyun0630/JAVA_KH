package controller;

import java.util.ArrayList;

import model.Session;
import model.dao.ProductDAO;
import model.dto.ProductDTO;

public class ProductController {

	public boolean addProduct(ProductDTO product) {
		ProductDAO pdao = new ProductDAO();
		int newNum = pdao.getNewNum();
		String loginUser = (String)Session.getData("loginUser");
		
		product.setProdnum(newNum);
		product.setUserid(loginUser);
		
		return pdao.insertProduct(product);
	}

	public boolean modifyProduct(int prodnum, int choice, String update) {
		ProductDAO pdao = new ProductDAO();
		return pdao.updateProductByProdnum(prodnum, choice, update);
		
	}

	public boolean deleteProduct(int prodnum) {
		ProductDAO pdao = new ProductDAO();
		return pdao.deleteProductByProdnum(prodnum);
		
	}

	public ArrayList<ProductDTO> getList(int choice, int asc) {
		ProductDAO pdao = new ProductDAO();
		String userid = (String)Session.getData("loginUser");
		return pdao.getList(userid, choice, asc);
	}


}








