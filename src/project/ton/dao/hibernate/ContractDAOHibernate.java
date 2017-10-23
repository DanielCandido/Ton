package project.ton.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import project.ton.dao.i.ContractDAO;
import project.ton.hibernate.HibernateUtil;
import project.ton.model.Contract;
import project.ton.util.ExceptionUtil;

public class ContractDAOHibernate implements ContractDAO{

	@Override
	public Contract createContract(Contract contract) {
		try {
			// Obtendo a sessao hiberanate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSession = tFactory.getCurrentSession();

			// Salvando via hibernate
			tSession.save(contract);
			tSession.flush();

			return contract;
		} catch (HibernateException tExcept) {

			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de criação do contrato");

		}
		return null;
	}

	@Override
	public Contract recoveryContract(int id) {
		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Recuperando o objeto via hibernate
			Contract tContract = (Contract) tSessao.get(Contract.class, id);

			// Retornando o objeto lido
			return tContract;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do Contrato");
		}
		return null;
	}

	@Override
	public Contract update(Contract contract) {
		 try
	        {
	            // Obtendo a sessão hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Ataulizando o objeto via hibernate
	            tSessao.merge(contract);
	            tSessao.flush();

	            // Retornando o objeto atualizado
	            return contract;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Contrato");
	        }
	        return null;
	}

	@Override
	public boolean delete(int id) {
		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Removendo o objeto via hibernate
			Contract tContract = (Contract) tSessao.get(Contract.class, id);
			if (tContract == null)
				return false;

			tSessao.delete(tContract);
			tSessao.flush();

			// Retornando indicativo de sucesso
			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Contrato");
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> search() {
		 List<Contract> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sessão hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o objeto para pesquisa
	            Query tQuery = tSessao.createQuery("FROM Contract");

	            // Recuperando a lista via hibernate
	            tLista = tQuery.list();

	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Contratos");
	        }

	        // Retornando a lista de Contratos
	        return tLista;
	}


}
