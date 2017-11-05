package project.ton.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.ton.dao.i.UserDAO;
import project.ton.model.User;
import project.ton.util.ExceptionUtil;

public class UserDaoJdbc extends AbstractDAO<User> implements UserDAO {

	private static String sTabela = "USERS";
	private static String sCampos1 = "ID_USER, FIRSTNAME_USER, LASTNAME_USER, EMAIL_USER, RG_USER, CPF_USER,"
			+ " PHONE_USER, CELLPHONE_USER, ADRESS_USER, CEP_USER, PASSWORD_USER, REGISTER_DATE, PROVIDER";

	private static String sCampos4 = "FIRSTNAME_USER, LASTNAME_USER, EMAIL_USER, PHONE_USER,"
			+ " CELLPHONE_USER, ADRESS_USER, CEP_USER, PASSWORD_USER, REGISTER_DATE";
	private static String sCampos5 = "FIRSTNAME_USER = ?, LASTNAME_USER = ?, EMAIL_USER = ?, PHONE_USER = ?,"
			+ " CELLPHONE_USER = ?, ADRESS_USER = ?, CEP_USER = ?, PASSWORD_USER = ?, PROVIDER = ?";
	private static String sCampos2 = sCampos1.replaceAll(",", " = ?,") + " = ?";
	private static String sCampos3 = sCampos2.replaceAll("[A-Z_]+ =", "");
	private static String sOrdem = "ORDER BY UPPER(FIRSTNAME_USER)";

	public UserDaoJdbc() {

	}

	Connection myConnection = null;
	private User user;

	@Override
	public User createUser(User pUser) {
		User tObject = null;

		try {

			AcessDAO acessoDAO = new AcessDAO();

			myConnection = acessoDAO.openConnection();
			// Criando o comando SQL e o comando JDBC
			String sqlRegister = "INSERT INTO " + sTabela + " (" + sCampos1 + ") VALUES ("
					+ sCampos3.replaceFirst("\\?", "IDUSER_SEQ.NEXTVAL") + ")";
			System.out.println(sqlRegister);
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlRegister, new String[] { "ID_USER" });

			// Colocando os parametros recebidos no JDBC
			int i = 1;
			tComandoJDBC.setString(i++, pUser.getFirstNameUser());
			tComandoJDBC.setString(i++, pUser.getLastNameUser());
			tComandoJDBC.setString(i++, pUser.getEmailUser());
			tComandoJDBC.setString(i++, pUser.getRgUser());
			tComandoJDBC.setString(i++, pUser.getCpfUser());
			tComandoJDBC.setString(i++, pUser.getPhoneUser());
			tComandoJDBC.setString(i++, pUser.getCellPhoneUser());
			tComandoJDBC.setString(i++, pUser.getAdressUser());
			tComandoJDBC.setString(i++, pUser.getCepUser());
			tComandoJDBC.setString(i++, pUser.getPasswordUser());
			tComandoJDBC.setDate(i++, new java.sql.Date(pUser.getRegisterDate().getTime()));
			tComandoJDBC.setString(i++, String.valueOf(pUser.getSituation()));
			// executando o comando de grava��o
			tComandoJDBC.executeUpdate();

			// Copiando o objeto para retorno
			tObject = pUser;

			// Liberando os recursos do JDBC
			tComandoJDBC.close();
		} catch (SQLException | ClassNotFoundException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de cria��o do objeto");
		}

		return tObject;
	}

	@Override
	public User recoveryUser(String emailUser) {

		User tObject = null;

		try {
			AcessDAO acessoDAO = new AcessDAO();
			myConnection = acessoDAO.openConnection();

			// Criando comando sql e jdbc
			String sqlRecovery = "SELECT " + sCampos4 + " FROM " + sTabela + " WHERE EMAIL_USER = ?";
			System.out.println("" + sqlRecovery);
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlRecovery);

			// Colocando o parametro recebido no JDBC
			tComandoJDBC.setString(1, emailUser);

			// Executando o comando e salvando o ResulSet para processar
			ResultSet tResultSet = tComandoJDBC.executeQuery();

			// Verificando se um registro foi lido
			if (tResultSet.next()) {
				// Salvando o objeto para retornar
				tObject = carregarObjeto(tResultSet);
			}

			// liberando os recursos jdbc
			tResultSet.close();
			tComandoJDBC.close();

		} catch (SQLException | ClassNotFoundException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de recupera��o do objeto");
		}
		return tObject;

	}

	// Metodo para atualiza��o de usuario
	/*public User updateUser(User puser) {
		User tObject = null;

		try {

			// iniciando objeto de conex�o
			AcessDAO acessoDAO = new AcessDAO();
			myConnection = acessoDAO.openConnection();

			// Criando comando sql e jdbc
			String sqlUpdate = "UPDATE " + sTabela + " SET " + sCampos2 + " WHERE EMAIL_USER = ?";
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlUpdate);
			System.out.println("Comando: " + sqlUpdate);

			// Colocando os parametros recebidos no jdbc
			int i = 1;

			tComandoJDBC.setString(i++, puser.getFirstNameUser());
			tComandoJDBC.setString(i++, puser.getLastNameUser());
			tComandoJDBC.setString(i++, puser.getEmailUser());
			tComandoJDBC.setString(i++, puser.getPhoneUser());
			tComandoJDBC.setString(i++, puser.getCellPhoneUser());
			tComandoJDBC.setString(i++, puser.getAdressUser());
			tComandoJDBC.setString(i++, puser.getCepUser());
			tComandoJDBC.setString(i++, puser.getPasswordUser());
			tComandoJDBC.setString(i++, String.valueOf(puser.getSituation()));
			tComandoJDBC.setString(i++, puser.getEmailUser());

			// executando o comando de grava��o

			int tQtdeReg = tComandoJDBC.executeUpdate();

			// Verificando se um registro foi alterado
			if (tQtdeReg == 1) {
				// Copiando o objeto para retorno
				tObject = puser;
			}

			tComandoJDBC.close();
		} catch (SQLException | ClassNotFoundException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do objeto");
		}

		// Retornando o objeto
		return tObject;

	}
*/
	@Override
	public boolean delete(String email, String senha) {
		try {

			AcessDAO acessDAO = new AcessDAO();
			myConnection = acessDAO.openConnection();
			// Criando o comando SQL e o comando JDBC
			String sqlDelete = "DELETE " + sTabela + " WHERE EMAIL_USER = ? AND PASSWORD_USER = ?";
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlDelete);

			// Colocando o parâmetro recebido no comando JDBC
			tComandoJDBC.setString(1, email);

			// Executando o comando de remoção e salvando o número de
			// registros removidos
			int tQtdeReg = tComandoJDBC.executeUpdate();

			// Liberando os recursos JDBC
			tComandoJDBC.close();

			// Verificando se um registro foi removido
			if (tQtdeReg == 1) {
				// Indicado que a remoção foi efetuado com sucesso
				return true;
			}
		} catch (SQLException | ClassNotFoundException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de remoção do objeto");
		}

		// Se chegou nesse ponto a remo��o n�o foi efetuada
		return false;
	}

	@Override
	public boolean deleteUser(String cpf) {
		try {

			AcessDAO acessDAO = new AcessDAO();
			myConnection = acessDAO.openConnection();
			// Criando o comando SQL e o comando JDBC
			String sqlDelete = "DELETE " + sTabela + " WHERE CPF_USER = ?";
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlDelete);

			// Colocando o parâmetro recebido no comando JDBC
			tComandoJDBC.setString(1, cpf);

			// Executando o comando de remoção e salvando o número de
			// registros removidos
			int tQtdeReg = tComandoJDBC.executeUpdate();

			// Liberando os recursos JDBC
			tComandoJDBC.close();

			// Verificando se um registro foi removido
			if (tQtdeReg == 1) {
				// Indicado que a remoção foi efetuado com sucesso
				return true;
			}
		} catch (SQLException | ClassNotFoundException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de remoção do objeto");
		}

		// Se chegou nesse ponto a remo��o n�o foi efetuada
		return false;
	}

	@Override
	public List<User> search() {

		// Criando a lista vazia
		List<User> tlist = new ArrayList<>();

		try {
			// Criando o comando sql
			String sqlSearch = "SELECT " + sCampos1 + " FROM " + sTabela;
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlSearch);

			executeSelect(tlist, tComandoJDBC);
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de recuperacao da lista de objetos");
		}
		// Retornando a lista de objetos
		return tlist;

	}

	public User carregarObjeto(ResultSet tResultSet) throws SQLException {
		// Criando um novo objeto para armazenar as informações lidas
		user = new User();

		// Recuperando as informações do ResultSet e colocando no objeto
		// criado

		user.setFirstNameUser(tResultSet.getString("FIRSTNAME_USER"));
		user.setLastNameUser(tResultSet.getString("LASTNAME_USER"));
		user.setEmailUser(tResultSet.getString("EMAIL_USER"));
		user.setPhoneUser(tResultSet.getString("PHONE_USER"));
		user.setCellPhoneUser(tResultSet.getString("CELLPHONE_USER"));
		user.setAdressUser(tResultSet.getString("ADRESS_USER"));
		user.setCepUser(tResultSet.getString("CEP_USER"));
		user.setPasswordUser(tResultSet.getString("PASSWORD_USER"));
		user.setRegisterDate(tResultSet.getDate("REGISTER_DATE"));

		return user;
	}

	// Método para pesquisar por nome todos os objetos da base de dados (SELECT
	// WHERE)
	@Override
	public List<User> searchByNome(String pNome) {
		// Acertando o critério de pesquisa
		String tNomePesquisa = " % " + pNome + " % ";

		// Criando a lista de objetos vazia
		List<User> tLista = new ArrayList<>();

		try {
			// Criando o comando SQL e o comando JDBC
			String tComandoSQL = "SELECT " + sCampos1 + " FROM " + sTabela
					+ " WHERE UPPER(FIRSTNAME_USER) LIKE UPPER(?) " + sOrdem;
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(tComandoSQL);

			// Colocando os parâmetros recebidos no comando JDBC
			tComandoJDBC.setString(1, tNomePesquisa);

			executeSelect(tLista, tComandoJDBC);
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo da pesquisa por nome dos objetos");
		}

		// Retornando a lista de objetos
		return tLista;
	}

	// Método para pesquisar por nome todos os objetos da base de dados (SELECT
	// WHERE)
	@Override
	public List<User> searchByCellPhone(String pCellPhone) {
		// Acertando o critério de pesquisa
		String tNomePesquisa = "%" + pCellPhone + "%";

		// Criando a lista de objetos vazia
		List<User> tLista = new ArrayList<>();

		try {
			// Criando o comando SQL e o comando JDBC
			String tComandoSQL = "SELECT " + sCampos1 + " FROM " + sTabela
					+ " WHERE UPPER(CELLPHONE_USER) LIKE UPPER(?) " + sOrdem;
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(tComandoSQL);

			// Colocando os parâmetros recebidos no comando JDBC
			tComandoJDBC.setString(1, tNomePesquisa);

			executeSelect(tLista, tComandoJDBC);
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo da pesquisa por nome dos objetos");
		}

		// Retornando a lista de objetos
		return tLista;
	}

	@Override
	public User updateUser(String email, String senha) {
		// Definindo o objeto de retorno
		User tObjeto = null;
		user = new User();
		try {
			// Criando o comando SQL e o comando JDBC
			String tComandoSQL = "UPDATE " + sTabela + " SET " + sCampos2
					+ " WHERE EMAIL_USER = ? AND PASSWORD_USER = ?";
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(tComandoSQL);

			
			// Colocando os parâmetros recebidos no comando JDBC
			int i = 1;
			tComandoJDBC.setString(i++, user.getFirstNameUser());
			tComandoJDBC.setString(i++, user.getLastNameUser());
			tComandoJDBC.setString(i++, user.getEmailUser());
			tComandoJDBC.setString(i++, user.getPhoneUser());
			tComandoJDBC.setString(i++, user.getCellPhoneUser());
			tComandoJDBC.setString(i++, user.getAdressUser());
			tComandoJDBC.setString(i++, user.getCepUser());
			tComandoJDBC.setString(i++, user.getPasswordUser());
	

			// Executando o comando de regravação e salvando o número de
			// registros alterados
			int tQtdeReg = tComandoJDBC.executeUpdate();

			// Verificando se um registro foi alterado
			if (tQtdeReg == 1) {
				// Copiando o objeto para o retorno
				tObjeto = user;
			}

			// Liberando os recursos JDBC
			tComandoJDBC.close();
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do objeto");
		}

		// Retornando o objeto
		return tObjeto;
	}

	@Override
	public User update(User pUser) {
		// Definindo o objeto de retorno
		User tObjeto = null;
		String email = null;

		try {
			// Criando o comando SQL e o comando JDBC
			String tComandoSQL = "UPDATE " + sTabela + " SET " + sCampos5 + " WHERE EMAIL_USER =  ?";
			System.out.println(tComandoSQL);
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(tComandoSQL);
			
			// Colocando os parâmetros recebidos no comando JDBC
			int i = 1;
			tComandoJDBC.setString(i++, pUser.getFirstNameUser());
			tComandoJDBC.setString(i++, pUser.getLastNameUser());
			tComandoJDBC.setString(i++, pUser.getEmailUser());
			tComandoJDBC.setString(i++, pUser.getPhoneUser());
			tComandoJDBC.setString(i++, pUser.getCellPhoneUser());
			tComandoJDBC.setString(i++, pUser.getAdressUser());
			tComandoJDBC.setString(i++, pUser.getCepUser());
			tComandoJDBC.setString(i++, pUser.getPasswordUser());
			tComandoJDBC.setString(i++, pUser.getSituation());
			tComandoJDBC.setString(i++, pUser.getEmailUser());

			// Executando o comando de regravação e salvando o número de
			// registros alterados
			int tQtdeReg = tComandoJDBC.executeUpdate();

			// Verificando se um registro foi alterado
			if (tQtdeReg == 1) {
				// Copiando o objeto para o retorno
				tObjeto = pUser;
			}

			// Liberando os recursos JDBC
			tComandoJDBC.close();
		} catch (SQLException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do objeto");
		}

		// Retornando o objeto
		return tObjeto;
	}

	@Override
	protected User loadingObject(ResultSet tResultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
