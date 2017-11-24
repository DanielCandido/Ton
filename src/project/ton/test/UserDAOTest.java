package project.ton.test;

import java.util.Date;

import project.ton.controller.UserController;
import project.ton.dao.jdbc.UserDaoJdbc;
import project.ton.model.User;

public class UserDAOTest {

	public static void main(String[] args) throws Exception {
		
		/*Category c = new Category();
		CategoryDAOJdbc categoryD = new CategoryDAOJdbc();
		List<Category> list = categoryD.search();

		System.out.println(list);
		
		ProviderDAOJdbc pDAO = new ProviderDAOJdbc();
		List<Provider> listp = pDAO.search();
	
		System.out.println(listp);
	
		ProviderDAOJdbc yDAO = new ProviderDAOJdbc();
		List<Provider> listSeach = yDAO.searchByName("JOAO");
		System.out.println(listSeach);*/
		
		
		//Testa Jasper
		User user = new User();
		user.setCpfUser("10228281218");
		user.setFirstNameUser("Maria");
		user.setLastNameUser("Mendonça");
		user.setEmailUser("mariamendoca@gmail.com");
		user.setRgUser("114115111");
		user.setPhoneUser("(41)3837-3837");
		user.setCellPhoneUser("(41)8789-8789");
		user.setCepUser("88.555-000");
		user.setAdressUser("rua teste");
		user.setPasswordUser("123456");
		user.setRegisterDate(new Date());
		
		UserDaoJdbc userC = new UserDaoJdbc();
		userC.createUser(user);
	}	
}

