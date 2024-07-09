package model.dao;

import java.util.ArrayList;

import model.DBConnection;
import model.dto.UserDTO;

public class UserDAO {
	DBConnection dbConnection;
	
	public UserDAO() {
		dbConnection = new DBConnection("UserTable.txt");
	}
	
	public UserDTO getUserByUserid(String userid) {
		ArrayList<String[]> result = dbConnection.select(0, userid);
		
		if(result.size() > 0) {
			//{"apple","abcd1234","김사과","10",...}
			String[] line = result.get(0);
			UserDTO user = new UserDTO(line[0], line[1], line[2], Integer.parseInt(line[3]), line[4], line[5]);
			return user;
		}
		return null;
	}

	public boolean insertUser(UserDTO user) {
		String data = String.format("%s\t%s\t%s\t%d\t%s\t%s",
				user.getUserid(),user.getUserpw(),user.getUsername(),
				user.getUserage(),user.getUserphone(),user.getUseraddr());
		return dbConnection.insert(data);
	}
}













