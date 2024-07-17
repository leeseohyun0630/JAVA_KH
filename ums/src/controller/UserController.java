package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Session;
import model.dao.ProductDAO;
import model.dao.UserDAO;
import model.dto.ProductDTO;
import model.dto.UserDTO;

public class UserController {
	public boolean checkId(String userid) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		return user == null;
	}

	public boolean join(UserDTO user) {
		UserDAO udao = new UserDAO();
		return udao.insertUser(user);
	}

	public boolean login(String userid, String userpw) {
		UserDAO udao = new UserDAO();
		UserDTO user = udao.getUserByUserid(userid);
		if(user != null) {
			if(user.getUserpw().equals(userpw)) {
				Session.setData("loginUser", user.getUserid());
				return true;
			}
		}
		return false;
	}

	public HashMap<String, Object> getDetail(String loginUser) {
		UserDAO udao = new UserDAO();
		ProductDAO pdao = new ProductDAO();
		
		UserDTO user = udao.getUserByUserid(loginUser);
		ArrayList<ProductDTO> list = pdao.getList(loginUser, 1, 1);
		int prodCnt = (list == null ? 0 : list.size());
		
		HashMap<String, Object> datas = new HashMap<>();
		datas.put("user", user);
		datas.put("prodCnt", prodCnt);
		
		return datas;
	}

	public boolean modifyUser(String loginUser, int choice, String newData) {
		UserDAO udao = new UserDAO();
		String[] cols = {"", "userpw", "userphone", "useraddr"};
		String col = cols[choice];
		return udao.upDataUser(loginUser, col, newData);
	}

	public boolean leaveId(String loginUser) {
		UserDAO udao = new UserDAO();
		ProductDAO pdao = new ProductDAO();
		
		ArrayList<ProductDTO> list = pdao.getList(loginUser, 1, 1);
		for(ProductDTO product : list) {
			pdao.deleteProductByProdnum(product.getProdnum());
		}
		
		udao.deleteUser(loginUser);
		
		Session.setData("loginUser", null);
		
		return true;
	}
	
}








