package project.ton.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import project.ton.dao.i.ProviderDAO;
import project.ton.model.Provider;
import project.ton.model.User;
import project.ton.util.ExceptionUtil;

public class ProviderDAOJdbc extends AbstractDAO<Provider> implements ProviderDAO{
	
	private static String tabela = "SERVICE_PROVIDER";
	private static String campos = "ID_SERVICE_PROVIDER,NAME_PROVIDER,CATEGORY,DESCRICAO,SITUACAO,EMAIL_PROVIDER,"
			+ "PHONE_PROVIDER, CELLPHONE_PROVIDER, PASSWORD_PROVIDER";
	
	public ProviderDAOJdbc(){
		
	}
	
	@Inject
	private EntityManager manager;
	Connection myConnection = null;
	private Provider provider;
	
	@Override
	public Provider create (Provider provider)
	{
		Provider tObject = null;
		try 
		{
			AcessDAO acess = new AcessDAO();
			
			myConnection = acess.openConnection();
			String sqlRegister = "INSERT INTO"+ tabela + " (" + campos + ") VALUES (?,?,?,?,?)";
			System.out.println(sqlRegister);
			PreparedStatement pstm = myConnection.prepareStatement(sqlRegister);
			
			int i = 1;
			pstm.setString(i++, provider.getIdProvider());
			pstm.setString(i++, provider.getNameProvider());
			pstm.setInt(i++, provider.getCategory());
			pstm.setString(i++, provider.getSubcategory());
			pstm.setString(i++, provider.getSituacao());
			pstm.setString(i++, provider.getEmailProvider());
			pstm.setString(i++, provider.getPhoneProvider());
			pstm.setString(i++, provider.getCellphoneProvider());
			pstm.setString(i++, provider.getPasswordProvider());
			pstm.setDate(i++, new java.sql.Date(provider.getRegisterDate().getTime()));
			
			pstm.executeQuery();
			
			tObject = provider;
			pstm.close();
		}
		catch (SQLException|ClassNotFoundException e)
		{
			ExceptionUtil.mostrarErro(e, "Erro na criacao do objeto");
		}
		return tObject;
	}
	
	
	
	@Override
	public List<Provider> search(){
		
		List<Provider> tlist = new ArrayList<>();
		
		
		try
		{
			AcessDAO acess = new AcessDAO();
			myConnection = acess.openConnection();
			
			String sqlsearch = "SELECT * from " + tabela + " WHERE SITUACAO = 'aprovado'";
			System.out.println(sqlsearch);
			PreparedStatement pstm = myConnection.prepareStatement(sqlsearch);
			
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next())
			 {
	            // Salvando o objeto retornado para adicionar na lista
	            Provider tObjeto = new Provider();
	            
	            tObjeto.setNameProvider(rs.getString("NAME_PROVIDER"));
	            tObjeto.setSubcategory(rs.getString("DESCRICAO"));

	            // Adicionando o objeto na lista
	            tlist.add(tObjeto);
	        }
			
		}
		catch (SQLException | ClassNotFoundException e)
		{
			ExceptionUtil.mostrarErro(e, "Erro na recuperação da lista");
		}
		return tlist;
		
	}

	@Override
	public List<Provider> searchByName(String nome){
		
		List<Provider> tlist = new ArrayList<>();
		
		try {
			
			AcessDAO acess = new AcessDAO();
			myConnection = acess.openConnection();
			
			String sqlSearch = "SELECT * FROM SERVICE_PROVIDER WHERE NAME_PROVIDER = '%"+nome+"%'";
			
			PreparedStatement pstm = myConnection.prepareStatement(sqlSearch);
			
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next())
			 {
	            // Salvando o objeto retornado para adicionar na lista
	            Provider tObjeto = new Provider();
	            
	            tObjeto.setNameProvider(rs.getString("NAME_PROVIDER"));
	            tObjeto.setSubcategory(rs.getString("DESCRICAO"));

	            // Adicionando o objeto na lista
	            tlist.add(tObjeto);
	        }
			
		}
		catch (SQLException | ClassNotFoundException e)
		{
			ExceptionUtil.mostrarErro(e, "Erro na recuperação da lista");
		}
		return tlist;
		
	}
	
	@Override
	public Provider update(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provider update(Provider provider) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String email, String senha) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String pCpf) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Provider loadingObject(ResultSet tResultSet) throws SQLException {
		Provider tProvider = new Provider();
		
		tProvider.setNameProvider(tResultSet.getString("NAME_PROVIDER"));
		tProvider.setSubcategory(tResultSet.getString("SUBCATEGORY"));
		return null;
	}



	public Provider recoveryProvider(String email, String idProvider) {
	
		Provider tObject = null;
		
		try {
			
			AcessDAO acess = new AcessDAO();
			myConnection = acess.openConnection();
			
			String sqlRecovery = "SELECT " + campos + " FROM " + tabela + " WHERE EMAIL_PROVIDER = ? and ID_SERVICE_PROVIDER = ?";
			System.out.println("" + sqlRecovery);
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlRecovery);

			// Colocando o parametro recebido no JDBC
			tComandoJDBC.setString(1, email);
			tComandoJDBC.setString(2, idProvider);

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
			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de recuperação do objeto");
		}
		return tObject;
	}
	
	public Provider carregarObjeto(ResultSet tResultSet) throws SQLException {
		// Criando um novo objeto para armazenar as informaÃ§Ãµes lidas
		provider = new Provider();

		// Recuperando as informaÃ§Ãµes do ResultSet e colocando no objeto
		// criado

		provider.setIdProvider(tResultSet.getString("ID_SERVICE_PROVIDER"));
		provider.setNameProvider(tResultSet.getString("NAME_PROVIDER"));
		provider.setCategory(tResultSet.getInt("CATEGORY"));
		provider.setSubcategory(tResultSet.getString("DESCRICAO"));
		provider.setSituacao(tResultSet.getString("SITUACAO"));
		provider.setEmailProvider(tResultSet.getString("EMAIL_PROVIDER"));
		provider.setPhoneProvider(tResultSet.getString("PHONE_PROVIDER"));
		provider.setCellphoneProvider(tResultSet.getString("CELLPHONE_PROVIDER"));
		provider.setPasswordProvider(tResultSet.getString("PASSWORD_PROVIDER"));
		provider.setRegisterDate(tResultSet.getDate("REGISTER_DATE"));
		

		return provider;
	}
}
