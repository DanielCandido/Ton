package project.ton.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import project.ton.dao.i.OrderServiceDAO;
import project.ton.hibernate.HibernateUtil;
import project.ton.model.OrderService;
import project.ton.util.ExceptionUtil;

public class OrdeServiceDAOHibernate implements OrderServiceDAO
{

    @Override
    public OrderService createOrderService(OrderService OrderService)
    {
        try {
            // Obtendo a sessao hiberanate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSession = tFactory.getCurrentSession();

            // Salvando via hibernate
            tSession.save(OrderService);
            tSession.flush();

            return OrderService;
        } catch (HibernateException tExcept) {

            ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de cria��o do usuario");

        }
        return null;

    }

    @Override
    public OrderService recoveryOrderService(int pId)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Recuperando o objeto via hibernate
            OrderService tOrderService = (OrderService) tSessao.get(OrderService.class, pId);

            // Retornando o objeto lido
            return tOrderService;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do Livro");
        }
        return null;
    }
    @Override
    public OrderService update(OrderService pOrder)
    {
        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Ataulizando o objeto via hibernate
            tSessao.merge(pOrder);
            tSessao.flush();

            // Retornando o objeto atualizado
            return pOrder;
        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do Usuario");
        }
        return null;
}

    @Override
    public boolean deleteOrderService(int pId)
    {
        try {
        // Obtendo a sess�o hibernate
        SessionFactory tFactory = HibernateUtil.getSessionFactory();
        Session tSessao = tFactory.getCurrentSession();

        // Removendo o objeto via hibernate
        OrderService tOrderService = (OrderService) tSessao.get(OrderService.class, pId);
        if (tOrderService == null)
            return false;

        tSessao.delete(pId);
        tSessao.flush();

        // Retornando indicativo de sucesso
        return true;
    } catch (HibernateException tExcept) {
        ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do Livro");
    }

    return false;
}

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderService> search()
    {
        List<OrderService> tLista = new ArrayList<>();

        try
        {
            // Obtendo a sess�o hibernate
            SessionFactory tFactory = HibernateUtil.getSessionFactory();
            Session tSessao = tFactory.getCurrentSession();

            // Criando o objeto para pesquisa
            Query tQuery = tSessao.createQuery("FROM OrderService");

            // Recuperando a lista via hibernate
            tLista = tQuery.list();

        }
        catch (HibernateException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Usuarios");
        }

        // Retornando a lista de Livros
        return tLista;
    }
    @Override
    public List<OrderService> searchByNome(int pId)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
