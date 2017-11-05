package project.ton.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import project.ton.dao.i.CategoryDAO;
import project.ton.hibernate.HibernateUtil;
import project.ton.model.Category;
import project.ton.util.ExceptionUtil;

public class CategoryDAOHibernate implements CategoryDAO {

	@Override
	public Category createCategory(Category category) {
		try {

			// Obtendo a sessao hiberanate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSession = tFactory.getCurrentSession();

			// Salvando via hibernate
			tSession.save(category);
			tSession.flush();

			return category;
		} catch (HibernateException e) {
			ExceptionUtil.mostrarErro(e, "Erro no metodo de criação da categoria");
		}
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> search() {
		List<Category> tLista = new ArrayList<>();

		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o objeto para pesquisa
			Query tQuery = tSessao.createQuery("FROM Category");

			System.out.println(tQuery);
			// Recuperando a lista via hibernate
			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Categorias");
		}

		// Retornando a lista de Contratos
		return tLista;
	}
}
