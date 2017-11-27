package project.ton.dao.hibernate;

import project.ton.dao.i.CategoryDAO;
import project.ton.dao.i.ContractDAO;
import project.ton.dao.i.OrderServiceDAO;
import project.ton.dao.i.ProviderDAO;
import project.ton.dao.i.UserDAO;
import project.ton.dao.jdbc.CategoryDAOJdbc;
import project.ton.dao.jdbc.OrderServiceJdbc;
import project.ton.dao.jdbc.ProviderDAOJdbc;
import project.ton.dao.jdbc.UserDaoJdbc;

public class DaoFactory {
	
	public static ProviderDAO getProviderDAO(){
		return new ProviderDAOJdbc();
	}
	
	public static CategoryDAO getCategoryDAO(){
		return new CategoryDAOJdbc();
	}

	public static UserDAO getUserDAO()
	{
		return new UserDaoJdbc();
	}

	public static OrderServiceDAO getOrderDAO()
	{
		return new OrderServiceJdbc();
	}

	public static ContractDAO getContractDAO()
	{
		return new ContractDAOHibernate();
	}
	
	
}
