package project.ton.test;

import java.util.List;

import project.ton.dao.jdbc.CategoryDAOJdbc;
import project.ton.dao.jdbc.ProviderDAOJdbc;
import project.ton.model.Category;
import project.ton.model.Provider;

public class UserDAOTest {

	public static void main(String[] args) {
		
		Category c = new Category();
		CategoryDAOJdbc categoryD = new CategoryDAOJdbc();
		List<Category> list = categoryD.search();

		System.out.println(list);
		
		ProviderDAOJdbc pDAO = new ProviderDAOJdbc();
		List<Provider> listp = pDAO.search();
	
		System.out.println(listp);
	
		ProviderDAOJdbc yDAO = new ProviderDAOJdbc();
		List<Provider> listSeach = yDAO.searchByName("JOAO");
		System.out.println(listSeach);
	}	
}

