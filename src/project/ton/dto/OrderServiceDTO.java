package project.ton.dto;

import java.util.List;

import project.ton.model.OrderService;

public class OrderServiceDTO extends AbstractDto<OrderService> {

	/**
	 * @param pOK
	 * @param pMensagem
	 */
	/*atributos normais */
	private OrderService order;
	private List<OrderService> list;

		/*Construtores de classe*/

	public OrderServiceDTO(boolean pOK, String pMensagem) {
		super(pOK, pMensagem);
	}

	public OrderServiceDTO(boolean pOK, String pMensagem, OrderService pOrderService) {
		super(pOK, pMensagem);
		order = pOrderService;
	}
	   public OrderServiceDTO(boolean pOk, String pMensagem, List<OrderService> pList)
	    {
	        super(pOk, pMensagem);
	        list = pList;
	    }


	   /* metodos de acesso*/
	   public OrderService getOrderService()
	    {
	        return order;
	    }

	    public void setOrderService(OrderService pOrderService)
	    {
	       order = pOrderService;
	    }

	    public List<OrderService> getList()
	    {
	        return list;
	    }

	    public void setList(List<OrderService> pList)
	    {
	        list = pList;
	    }

}
