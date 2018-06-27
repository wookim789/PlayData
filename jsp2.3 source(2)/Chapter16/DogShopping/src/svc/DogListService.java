package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.DogDAO;
import vo.Dog;
public class DogListService {

	public ArrayList<Dog> getDogList() {
		DogDAO dogDAO = DogDAO.getInstance();
		Connection con = getConnection();
		dogDAO.setConnection(con);		
		ArrayList<Dog> dogList = dogDAO.selectDogList();
		close(con);
		return dogList;
	}
	
}