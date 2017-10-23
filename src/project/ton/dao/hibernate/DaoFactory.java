package project.ton.dao.hibernate;

import project.ton.dao.i.ContractDAO;
import project.ton.dao.i.OrderServiceDAO;
import project.ton.dao.i.UserDAO;

public class DaoFactory {

	public static UserDAO getUserDAO()
	{
		return new UserDAOHibernate();
	}

	public static OrderServiceDAO getOrderDAO()
	{
		return new OrdeServiceDAOHibernate();
	}

	public static ContractDAO getContractDAO()
	{
		return new ContractDAOHibernate();
	}
	
	
}
