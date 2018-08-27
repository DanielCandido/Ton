package project.ton.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.ton.dao.i.CategoryDAO;
import project.ton.model.Category;
import project.ton.model.Provider;
import project.ton.util.ExceptionUtil;

public class CategoryDAOJdbc extends AbstractDAO<Category> implements CategoryDAO{
	
	private static String tabela = "CATEGORY";
	
	public CategoryDAOJdbc(){
		
	}
	
	Connection myConnection = null;

	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category recoveryCategory(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<String> search() {
		List<String> list = new ArrayList<>();
		
		try {
			
			AcessDAO acess = new AcessDAO();
			myConnection = acess.openConnection();
			
			String sqlSearch = "SELECT * FROM " + tabela;
			System.out.println(sqlSearch);
			PreparedStatement pstm = myConnection.prepareStatement(sqlSearch);
			
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next())
			 {
	            // Salvando o objeto retornado para adicionar na lista
	            //Category tObjeto = new Category();
	            
	            //tObjeto.setNameCategory(rs.getString("NAME_CATEGORY"));
	            // Adicionando o objeto na lista
	            
				list.add(rs.getString("ID_CATEGORY"));
	        }
			
		}
		catch (SQLException | ClassNotFoundException e)
		{
			ExceptionUtil.mostrarErro(e, "Erro na recuperação da lista");
		}
		return list;
		
	}

	@Override
	protected Category loadingObject(ResultSet tResultSet) throws SQLException {
		Category tCategory = new Category();
		tCategory.setIdCategory(tResultSet.getInt("ID_CATEGORY"));
		tCategory.setNameCategory(tResultSet.getString("NAME_CATEGORY"));
		return  null;
	}
	
	

}
