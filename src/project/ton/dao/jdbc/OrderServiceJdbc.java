package project.ton.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.ton.dao.i.OrderServiceDAO;
import project.ton.model.OrderService;
import project.ton.util.ExceptionUtil;

public class OrderServiceJdbc extends AbstractDAO<OrderService> implements OrderServiceDAO {

	private static String sTabela = "ORDER_SERVICE";
	private static String sCampos1 = "ID_ORDER, SERVICE_PROVIDER_ID, DATE_ORDER, CEP_ORDER, STATUS_ORDER";
	private static String sCampos2 = sCampos1.replaceAll(",", " = ?,") + " = ?";
	private static String sCampos3 = sCampos2.replaceAll("[A-Z_]+ =", "");
	private static String sPrimaryKey = "ID_ORDER";
	
	Connection myConnection = null;
	@Override
	public OrderService createOrderService(OrderService orderService) {
		OrderService tObject;
		
		try {
			AcessDAO acessDAO = new AcessDAO();
			
			myConnection =  acessDAO.openConnection();
			
			//Criando comando sql
			String sqlRegister = "INSERT INTO " + sTabela + " (" + sCampos1 + ") VALUES ("
					+ sCampos3.replaceFirst("\\?", "IDORDER_SEQ.NEXTVAL") + ")";
			System.out.println(sqlRegister);
			PreparedStatement tComandoJDBC = myConnection.prepareStatement(sqlRegister, new String[] { "ID_ORDER" });
			
			//Colocando os parametros
			int i= 1;
			tComandoJDBC.setInt(i++, orderService.getIdOrder());
			tComandoJDBC.setObject(i++, orderService.getProvider());
			tComandoJDBC.setDate(i++, new java.sql.Date(orderService.getDateOrder().getTime()));
			tComandoJDBC.setString(i++, orderService.getCepOrder());
			tComandoJDBC.setString(i++, String.valueOf(orderService.getSituation()));
			tComandoJDBC.setString(i++, orderService.getUserId());
			
			tComandoJDBC.executeQuery();
			
			tObject = orderService;
			
			tComandoJDBC.close();
		} catch (SQLException | ClassNotFoundException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no metodo de cria��o do objeto");
		
		}
		return null;
	}

	@Override
	public OrderService recoveryOrderService(int id) {
		OrderService tObject = null;
		
		  try
	        {
	            // Criando o comando SQL e o comando JDBC
	            String tComandoSQL = "SELECT " + sCampos1 +
	                                 " FROM " + sTabela +
	                                 " WHERE " + sPrimaryKey;
	            PreparedStatement tComandoJDBC = myConnection.prepareStatement(tComandoSQL);

	            // Colocando o parâmetro recebido no comando JDBC
	            tComandoJDBC.setLong(1, id);

	            // Executando o comando e salvando o ResultSet para processar
	            ResultSet tResultSet = tComandoJDBC.executeQuery();

	            // Verificando se um registro foi lido
	            if (tResultSet.next())
	            {
	                // Salvando o objeto para retornar depois
	                tObject = loadingObject(tResultSet);
	            }

	            // Liberando os recursos JDBC
	            tResultSet.close();
	            tComandoJDBC.close();
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do objeto");
	        }

	        // Retornando o objeto
	        return tObject;
	}

	@Override
	public OrderService update(OrderService order) {
		OrderService tObjeto = null;

        try
        {
            // Criando o comando SQL e o comando JDBC
            String tComandoSQL = "UPDATE " + sTabela +
                                 " SET " + sCampos2 +
                                 " WHERE " + sPrimaryKey;
            PreparedStatement tComandoJDBC = myConnection.prepareStatement(tComandoSQL);

            // Colocando os parâmetros recebidos no comando JDBC
            int i = 1;
            tComandoJDBC.setDate(i++, new java.sql.Date(order.getDateOrder().getTime()));
            tComandoJDBC.setString(i++, order.getCepOrder());
            tComandoJDBC.setString(i++, String.valueOf(order.getSituation()));
           

            // Executando o comando de regravação e salvando o número de registros alterados
            int tQtdeReg = tComandoJDBC.executeUpdate();

            // Verificando se um registro foi alterado
            if (tQtdeReg == 1)
            {
                // Copiando o objeto para o retorno
                tObjeto = order;
            }

            // Liberando os recursos JDBC
            tComandoJDBC.close();
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do objeto");
        }

        // Retornando o objeto
        return tObjeto;
 
	}

	@Override
	public boolean deleteOrderService(int id) {
		  try
	        {
	            // Criando o comando SQL e o comando JDBC
	            String tComandoSQL = "DELETE " + sTabela +
	                                 " WHERE " + sPrimaryKey;
	            PreparedStatement tComandoJDBC = myConnection.prepareStatement(tComandoSQL);

	            // Colocando o parâmetro recebido no comando JDBC
	            tComandoJDBC.setLong(1, id);

	            // Executando o comando de remoção e salvando o número de registros removidos
	            int tQtdeReg = tComandoJDBC.executeUpdate();

	            // Liberando os recursos JDBC
	            tComandoJDBC.close();

	            // Verificando se um registro foi removido
	            if (tQtdeReg == 1)
	            {
	                // Indicado que a remoção foi efetuado com sucesso
	                return true;
	            }
	        }
	        catch (SQLException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de remoção do objeto");
	        }

		return false;
	}

	@Override
	public List<OrderService> search() {
		 // Criando a lista de objetos vazia
        List<OrderService> tLista = new ArrayList<>();

        try
        {
            // Criando o comando SQL e o comando JDBC
            String tComandoSQL = "SELECT " + sCampos1 +
                                 " FROM " + sTabela;
            PreparedStatement tComandoJDBC = myConnection.prepareStatement(tComandoSQL);

            executeSelect(tLista, tComandoJDBC);
        }
        catch (SQLException tExcept)
        {
            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de objetos");
        }

        // Retornando a lista de objetos
        return tLista;
	}

	@Override
	public List<OrderService> searchByNome(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected OrderService loadingObject(ResultSet tResultSet) throws SQLException {
		OrderService tOrder = new OrderService();
		
		tOrder.setIdOrder(tResultSet.getInt("ID_ORDER"));
		tOrder.setDateOrder(tResultSet.getDate("DATE_ORDER"));
		tOrder.setCepOrder(tResultSet.getString("CEP_ORDER"));
		tOrder.setSituation(tResultSet.getString("STATUS_ORDER"));
		return null;
	}

	
}
