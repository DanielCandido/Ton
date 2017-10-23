package project.ton.test;

import java.util.Date;
import java.util.List;

import project.ton.dao.hibernate.DaoFactory;
import project.ton.dao.i.UserDAO;
import project.ton.enums.ProviderSituation;
import project.ton.hibernate.HibernateUtil;
import project.ton.model.User;
import project.ton.util.ExceptionUtil;

public class UserDAOTest {

	public static void main(String[] args) {


		try{
		// Iniciando sessão hibernate
        HibernateUtil.iniciarTransacao();
		System.out.println("Iniciando transação");
		System.out.println();
		//Criando objetos
		User user1 = new User(5,"Maria","Dolores","mariadolores@gmail.com","12.212.313-5","101.201.801-18","(41)3535-3636",
				"9897-9798","Rua dos milagres, 38","80.580-070","123456",new Date(),ProviderSituation.N);
		User user2 = new User(6,"Daenerys","Targaryen","dracarys@drogon.com","12.412.717-71","101.101.101-10","3131-3232",
				"(41)9896-9896","Rua das Oliveiras, 87","87.587-080","123456",new Date(),ProviderSituation.S);

		//Criando objeto de persistencia
		UserDAO tUser = DaoFactory.getUserDAO();

		//Criando DAO para receber objeto
		user1 = tUser.createUser(user1);
		if (user1 != null)
		System.out.println("Objeto Incluso...:" + user1);
		else
		System.out.println("falha na inlcusão...:" + user1);


		user2 = tUser.createUser(user2);
		if(user2 != null)
			System.out.println("Objeto incluso...:" + user2);
		else
			System.out.println("falha na inclusão...:" + user2);


		//Recuperando objetos
		System.out.println();
		System.out.println("Recuperando objetos");
		User user3 =  tUser.recoveryUser(user1.getEmailUser());
		if (user3 != null)
			System.out.println("Recuperado..." + user3.getFirstNameUser() +" " + user3.getLastNameUser());
		else
			System.out.println("Erro na recuperação");

		User user4 = tUser.recoveryUser(user2.getEmailUser());
		if(user4 != null)
			System.out.println("Recuperado..." + user4.getFirstNameUser() +" " +user4.getLastNameUser());
		else
			System.out.println("Erro na recuperação");

		//atualizando objetos
		System.out.println();
		System.out.println("Atualizando objetos");

		user1.setFirstNameUser(user1.getFirstNameUser());
		user1.setLastNameUser("Rodri");
		user1.setEmailUser(user1.getEmailUser());
		user1.setPhoneUser(user1.getPhoneUser());
		user1.setCellPhoneUser(user1.getCellPhoneUser());
		user1.setAdressUser(user1.getAdressUser());
		user1.setCepUser(user1.getCepUser());
		user1.setPasswordUser("789456");
		user1.setSituation(ProviderSituation.S);


		User pUser =  tUser.update(user1);
		if (pUser != null)
			System.out.println("Atualizado: " + pUser);
		else
			System.out.println("Erro no metodo de atualização");

		/*user2.setCepUser("82.582-080");
		user2.setPasswordUser("456789");*/

		/*tUser.update(user2);*/

		//Listando Objeto cadastrados
		System.out.println();
		System.out.println("Listando Usuarios");
		List<User> tList1 = tUser.search();

		for (User tObjeto : tList1)
		{
			System.out.println("Relação de usuario cadastrados: " + tObjeto);
		}

		//dELETANDO USUARIO]

		 // Confirmar Transação
		  HibernateUtil.confirmarTransacao();
    }
    catch (Exception tExcept)
    {
        // Cancelar Transação
        ExceptionUtil.mostrarErro(tExcept, "Erro na excecução do teste");
        HibernateUtil.cancelarTransacao();
    }
    finally
    {
        // Fechando a conexão Hibernate
        HibernateUtil.fecharConexao();
    }

	}

}

