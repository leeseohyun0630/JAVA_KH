package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DBConnection;
import model.dto.ProductDTO;

public class ProductDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public ProductDAO() {
		conn = DBConnection.getConnection();
	}
	public boolean insertProduct(ProductDTO product) {
		String sql = "insert into product (prodname,prodprice,prodamount,prodinfo,userid) values(?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, product.getProdname());
			ps.setInt(2, product.getProdprice());
			ps.setInt(3, product.getProdamount());
			ps.setString(4, product.getProdinfo());
			ps.setString(5, product.getUserid());
			
			int result = ps.executeUpdate();
			
			return result == 1;
		} catch (SQLException e) {
		}
		return false;
	}
	public ArrayList<ProductDTO> getList(String userid, int choice, int asc) {
		ArrayList<ProductDTO> list = new ArrayList<>();
		
		//choice : 1(prodnum) / 2(prodname) / 3(prodprice) / 4(likecnt)
		//asc : 1(오름차순) / 2(내림차순)
		String[] cols = {"","prodnum","prodname","prodprice","likecnt"};
		String order_col = cols[choice];//정렬 기준이 되는 컬럼 명
		
		String sql = "select * from product where userid = ? order by "+order_col;
		if(asc == 1) {
			sql += " asc";
		}
		else {
			sql += " desc";
		}
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO(
						rs.getInt(1),	//rs.getInt("prodnum")
						rs.getString(2),//rs.getString("prodname")
						rs.getInt(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7)
				);
				list.add(product);
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		if(list.size() == 0) {
			return null;
		}
		else {
			return list;
		}
	}
	public boolean deleteProductByProdnum(int prodnum) {
		String sql = "delete from product where prodnum = "+prodnum;
		try {
			ps = conn.prepareStatement(sql);
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}
	public boolean updateProduct(int prodnum, String col, String newData) {
		try {
			String sql = "update product set "+col+" = ? where prodnum = "+prodnum;
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			
			return ps.executeUpdate() == 1;
		} catch (SQLException e) {
		}
		return false;
	}
	//														"지우"
	public ArrayList<ProductDTO> getProductByKeyword(String keyword) {
		ArrayList<ProductDTO> result = new ArrayList<>();
		//			  select * from product
		String sql = "select * from product "
//				   where prodname like('%  지우      %') 
				+ "where prodname like('%"+keyword+"%') "
//				   or prodinfo like('%    지우    %')
				+ "or prodinfo like('%"+keyword+"%') ";

//		"select * from product where prodname like('%지우%') or prodinfo like('%지우%') ";
		
		try {
			Integer.parseInt(keyword);
			//		or prodprice between 0.9*10000       and 1.1*10000
			sql += "or prodprice between 0.9*"+keyword+" and 1.1*"+keyword;
			
		} catch (NumberFormatException e) {
			
		}
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO(
						rs.getInt(1),	//rs.getInt("prodnum")
						rs.getString(2),//rs.getString("prodname")
						rs.getInt(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7)
				);
				result.add(product);
			}
		} catch (SQLException e) {
		}
		if(result.size() == 0) {
			return null;
		}
		else {
			return result;
		}
	}
	public ProductDTO getProductByProdnum(int prodnum) {
		String sql = "select * from product where prodnum = "+prodnum;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ProductDTO product = new ProductDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7)
				);
				return product;
			}
		} catch (SQLException e) {
		}
		return null;
	}
}
















