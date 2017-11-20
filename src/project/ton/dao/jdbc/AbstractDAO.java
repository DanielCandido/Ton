package project.ton.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import project.ton.model.Provider;
import project.ton.model.User;



public abstract class AbstractDAO<T> {
	  protected void executeSelect(List<T> pLista, PreparedStatement pComandoJDBC) throws SQLException
	    {
	        // Executando o comando e salvando o ResultSet para processar
	        ResultSet tResultSet = pComandoJDBC.executeQuery();

	        // Enquanto houver registros, processa
	        while (tResultSet.next())
	        {
	            // Salvando o objeto retornado para adicionar na lista
	            T tObjeto = loadingObject(tResultSet);

	            // Adicionando o objeto na lista
	            pLista.add(tObjeto);
	        }

	        // Liberando os recursos JDBC
	        tResultSet.close();
	        pComandoJDBC.close();
	    }

	    protected abstract T loadingObject(ResultSet tResultSet) throws SQLException;

		public List<User> searchByNome(String pNome) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<Provider> searchByName(String pNome) {
			// TODO Auto-generated method stub
			return null;
		}
		public List<User> searchByCellPhone(String pCellPhone) {
			// TODO Auto-generated method stub
			return null;
		}


}
