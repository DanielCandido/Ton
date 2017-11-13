package project.ton.dao.hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import project.ton.dao.i.UserDAO;
import project.ton.dao.jdbc.AcessDAO;
import project.ton.hibernate.HibernateUtil;
import project.ton.model.User;
import project.ton.util.ExceptionUtil;


public class UserDAOHibernate implements UserDAO
{ 
	public UserDAOHibernate(){
		
	}

	Connection myConnection;
	
	@Override
	public User createUser(User user) {
		try {
			// Obtendo a sessao hiberanate
			Session tFactory = HibernateUtil.getSessionFactory().openSession();
			// Salvando via hibernate
			
			tFactory.beginTransaction();
			tFactory.save(user);
			tFactory.getTransaction().commit();
			tFactory.close();

			return user;
		} catch (HibernateException tExcept) {

			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de criação do usuario");

		}
		return null;
	}
	
	public boolean loginUser(String emailLogin, String senhaLogin) {
		boolean result = false;

		try {
			AcessDAO acessoDAO = new AcessDAO();
			myConnection = acessoDAO.openConnection();
			PreparedStatement pstm = myConnection
					.prepareStatement("SELECT EMAIL_USER PASSWORD_USER FROM USERS WHERE EMAIL_USER = ? AND PASSWORD_USER = ?");
			pstm.setString(1, emailLogin);
			pstm.setString(2, senhaLogin);

			ResultSet retorno = pstm.executeQuery();

			if (retorno.next()) {
				System.out.println("Usuario encontrado" + emailLogin);
				result = true;
			}

			// Liberando os recursos JDBC
			pstm.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (myConnection != null && !myConnection.isClosed())
					myConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


	@Override
	public User recoveryUser(String email) {
		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Recuperando o objeto via hibernate
            Criteria tCriterio = tSessao.createCriteria(User.class)
                    .add(Restrictions.like("emailUser", email));

            if (tCriterio.list().isEmpty()) {
                return null;
            }

            User tUser = (User) tCriterio.list().get(0);
			return tUser;


		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Usuario");
		}
		return null;
	}


	@Override
	public User update(User user) {
		 try
	        {
	            // Obtendo a sessão hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Ataulizando o objeto via hibernate
	            tSessao.merge(user);
	            tSessao.flush();

	            // Retornando o objeto atualizado
	            return user;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Usuario");
	        }
	        return null;
	}

	@Override
	public boolean delete(String email, String senha) {
		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Removendo o objeto via hibernate
			User tUser = (User) tSessao.get(User.class, email);
			if (tUser == null)
				return false;

			tSessao.delete(tUser);
			tSessao.flush();

			// Retornando indicativo de sucesso
			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Usuario");
		}

		return false;
	}

	@Override
	public boolean deleteUser(String pCpf) {
		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Removendo o objeto via hibernate
			User tUser = (User) tSessao.get(User.class, pCpf);
			if (tUser == null)
				return false;

			tSessao.createQuery("DELETE FROM User Where cpfUser =" +pCpf);
			tSessao.flush();

			// Retornando indicativo de sucesso
			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Usuario");
		}

		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> search() {
		 // Criando a tLista de usuarios vazia
        List<User> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM User");

            System.out.println(tQuery);
            // Recuperando a lista via hibernate
            tLista = tQuery.list();
           

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Usuarios");
        }

        // Retornando a lista de Livros
        return tLista;
	}

	@SuppressWarnings("unchecked")
    @Override
	public List<User> searchByNome(String pNome) {
		String  tNomePesquisa = "%" + pNome + "%";
	    List<User> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sessão hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            
            Criteria tCriterio = tSessao.createCriteria(User.class).
            		add(Restrictions.like("firstNameUser", tNomePesquisa)
                            .ignoreCase());
            

            // Recuperando a lista via hibernate
            tLista = tCriterio.list();
            

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Usuarios");
        }

        // Retornando a lista de Livros
        return tLista;
    }
	@Override
	public List<User> searchByCellPhone(String pCellPhone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(String email, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

}
