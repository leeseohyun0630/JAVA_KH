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

	public boolean modifyProduct(int prodnum, int choice, String newData) {
		//choice : 1(이름 수정) / 2(가격 수정) / 3(수량 수정) / 4(설명 수정)
		ProductDAO pdao = new ProductDAO();
		String[] cols = {"","prodname","prodprice","prodamount","prodinfo"};
		return pdao.updateProduct(prodnum,cols[choice],newData);
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

	public ArrayList<ProductDTO> search(String keyword) {
		ProductDAO pdao = new ProductDAO();
		ArrayList<ProductDTO> list = pdao.getAllProduct();
		if(list == null) {
			return null;
		}
		else {
			ArrayList<ProductDTO> result = new ArrayList<>();
			for(ProductDTO product : list) {
				if(product.getProdname().contains(keyword)) {
					result.add(product);
				}
				else if(product.getProdinfo().contains(keyword)) {
					result.add(product);
				}
				else if(isDigit(keyword)) {
					int price = Integer.parseInt(keyword);
					int min = (int)(price*0.9);
					int max = (int)(price*1.1);
					if(product.getProdprice()>=min && product.getProdprice()<=max) {
						result.add(product);
					}
				}

			}
			return result;
		}
	}

	private boolean isDigit(String msg) {
		for (int i = 0; i < msg.length(); i++) {
			char ch = msg.charAt(i);
			if(ch>'9' || ch<'0') {
				return false;
			}
		} 
		return true;
	}

	public ProductDTO getDetail(int prodnum) {
		ProductDAO pdao = new ProductDAO();
		return pdao.getProductByProdnum(prodnum);
	}

	public void updateLikecnt(int prodnum) {
		ProductDAO pdao = new ProductDAO();
		int likecnt = pdao.getProductByProdnum(prodnum).getLikecnt();
		pdao.updateProduct(prodnum, "likecnt", likecnt+1+"");
	   
	}
}










