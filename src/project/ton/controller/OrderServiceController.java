package project.ton.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import project.ton.dao.hibernate.DaoFactory;
import project.ton.dao.i.OrderServiceDAO;
import project.ton.dto.OrderServiceDTO;
import project.ton.model.OrderService;

public class OrderServiceController {
	public  OrderServiceDTO validarPedido(int idOrder, String pSenha){
		if (idOrder == 0)
            return new OrderServiceDTO(false, "Email invalido");
        if (pSenha == null || pSenha.isEmpty())
            return new OrderServiceDTO(false, "Senha invalida");

        // Criando os objetos DAO
        OrderServiceDAO tOrderServiceDAO = DaoFactory.getOrderDAO();

        // Lendo o User
        OrderService tOrder = tOrderServiceDAO.recoveryOrderService(idOrder);

        // Verificando se houve erro de recuperação
        if (tOrder == null)
            return new OrderServiceDTO(false, "Pedido não existe na lista");

        // Retornando o indicativo de sucesso com o objeto recuperado
		return new OrderServiceDTO(true, "Usuario identificado com sucesso", tOrder);
	}
	
	 public OrderServiceDTO cadastrar(OrderService pOrder)
	    {
	        // Validando os parÃ¢metros de entrada
	        if (pOrder == null)
	            return new OrderServiceDTO(false, "Tentativa de inserir um usuario nulo");

	        // Criando os objetos DAO
	        OrderServiceDAO tDaoOrder = DaoFactory.getOrderDAO();
	        // Inserindo o User
	        pOrder.setDateOrder(new Date());
	        pOrder.setSituation("Em analise");
	        System.out.println("Na controller" + pOrder);
	        OrderService tOrder = tDaoOrder.createOrderService(pOrder);

	        // Verificando se houve erro de criaÃ§Ã£o
	        if (tOrder == null)
	            return new OrderServiceDTO(false, "Problemas na grava��o do pedido");

	        // Retornando o indicativo de sucesso com o objeto cadastrado
	        return new OrderServiceDTO(true, "Pedido cadastrado com sucesso", tOrder);
	    }
	 
	  public OrderServiceDTO recuperar(int pIdOrder)
	    {
	        // Validando os parÃ¢metros de entrada
	        if (pIdOrder == 0)
	            return new OrderServiceDTO(false, "id invalido");

	        // Criando os objetos DAO
	        OrderServiceDAO tDaoOrder = DaoFactory.getOrderDAO();

	        // Lendo o usuario
	        OrderService tOrder = tDaoOrder.recoveryOrderService(pIdOrder);

	        // Verificando se houve erro de recuperaÃ§Ã£o
	        if (tOrder == null)
	            return new OrderServiceDTO(false, "Ordem n�o existe");

	        // Retornando o indicativo de sucesso com o objeto recuperado
	        return new OrderServiceDTO(true, "usuario recuperado com sucesso", tOrder);
	    }
	  
	  public OrderServiceDTO atualizar(OrderService pOrder)
	    {
	        // Validando os parÃ¢metros de entrada
	        if (pOrder == null)
	            return new OrderServiceDTO(false, "Tentativa de atualizar um pedido nulo");

	        // Criando os objetos DAO
	        OrderServiceDAO tDaoOrder = DaoFactory.getOrderDAO();

	        // Atualizando o usuario
	        OrderService tOrder = tDaoOrder.update(pOrder);

	        // Verificando se houve erro de atualizaÃ§Ã£o
	        if (tOrder == null)
	            return new OrderServiceDTO(false, "Pedido n�o existe no cadastro");

	        // Retornando o indicativo de sucesso com o objeto atualizado
	        return new OrderServiceDTO(true, "Usuario atualizado com sucesso", tOrder);
	    }
	  

	    public OrderServiceDTO remover(int pIdOrder)
	    {
	        // Validando os parÃ¢metros de entrada
	        if (pIdOrder == 0)
	            return new OrderServiceDTO(false, "Id invalido");

	        // Criando os objetos DAO
	        OrderServiceDAO tDaoOrder = DaoFactory.getOrderDAO();

	        OrderService tOrder = tDaoOrder.recoveryOrderService(pIdOrder);
	        if (tOrder == null)
	            return new OrderServiceDTO(false, "Pedido nao existe no cadastro");
	        // Removendo o User
	        tDaoOrder.deleteOrderService(pIdOrder);

	        // Retornando o indicativo de sucesso com o objeto removido
	        return new OrderServiceDTO(true, "Pedido removido com sucesso", tOrder);
	    }

	    public OrderServiceDTO pesquisar()
	    {
	        // Criando os objetos DAO
	        OrderServiceDAO tDaoOrder = DaoFactory.getOrderDAO();

	        // Obtendo a lista de Users
	        List<OrderService> tLista = tDaoOrder.search();

	        // Retornando a lista obtida
	        return new OrderServiceDTO(true, "Lista de Pedidos recuperada", tLista);
	    }

	    public OrderServiceDTO pesquisarId(int pId)
	    {
	        // Caso o nome de pesquisa seja nulo ou vazio, retorna a lista geral
	        if (pId == 0 )
	            return pesquisar();

	        // Criando os objetos DAO
	        OrderServiceDAO tDaoOrder = DaoFactory.getOrderDAO();

	        // Obtendo a lista de Users
	        List<OrderService> tLista = tDaoOrder.searchByNome(pId);

	        // Retornando a lista obtida
	        return new OrderServiceDTO(true, "Lista de pedidos com id '" + pId + "' recuperada", tLista);
	    }

	    
}
