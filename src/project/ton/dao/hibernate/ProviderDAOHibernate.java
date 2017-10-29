package project.ton.dao.hibernate;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import project.ton.dao.i.ProviderDAO;
import project.ton.hibernate.HibernateUtil;
import project.ton.model.Provider;
import project.ton.util.ExceptionUtil;

public class ProviderDAOHibernate implements ProviderDAO {
	
	Connection myConnection;
	
	public Provider createProvider(Provider provider)
	{
		try{
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSession = tFactory.getCurrentSession();

			// Salvando via hibernate
			
			tSession.save(provider);
			tSession.flush();
			tSession.close();

			return provider;
		} catch (HibernateException tExcept) {

			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de criação do usuario");

		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Provider> search() {
		List<Provider> tList = new ArrayList<>();
		

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM Provider");

            System.out.println(tQuery);
            // Recuperando a lista via hibernate
            tList = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Usuarios");
        }

        // Retornando a lista de Livros
        return tList;
		
		
	}

	@Override
	public Provider create(Provider provider) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provider recovery(int id) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Provider> searchByNome(String pNome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Provider> searchByCellPhone(String pCellPhone) {
		// TODO Auto-generated method stub
		return null;
	}

}
