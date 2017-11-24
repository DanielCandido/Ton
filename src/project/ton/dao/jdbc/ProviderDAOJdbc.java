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
import project.ton.util.ExceptionUtil;

public class ProviderDAOJdbc extends AbstractDAO<Provider> implements ProviderDAO{
	
	private static String tabela = "SERVICE_PROVIDER";
	private static String campos = "ID_SERVICE_PROVIDER,NAME_PROVIDER,CATEGORY,DESCRICAO,SITUACAO";
	
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
}
