package project.ton.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;

import project.ton.controller.OrderServiceController;
import project.ton.dto.OrderServiceDTO;
import project.ton.model.OrderService;

@ManagedBean(name="orderServiceBean")
@ViewScoped
public class OrderServiceBean {
	
	@Inject 
	private OrderServiceController orderServiceController;
	
	
	@Inject 
	private FacesMessage messages;
	
	private OrderService orderService;
	
	public void inicializar(){
		orderService = new OrderService();
	}
	
	
	public void clienteSelecionado(SelectEvent event){
		OrderService orderservice = (OrderService) event.getObject();
		orderService.setProvider(orderservice.getUserId());
	}
	
	public String Salvar(){
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		orderServiceController = new OrderServiceController();
		OrderServiceDTO oDto = new OrderServiceDTO();
		System.out.println("Ordem registrada: " +orderService);
		orderServiceController.cadastrar(orderService);
		
		if(!contexto.getMessageList().isEmpty()){
			return "visualiza-order";
		}
	

		if (oDto.isOk()) {
			orderService = oDto.getObjeto();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, oDto.getMensagem(), null));
			orderServiceController = new OrderServiceController();
			
		} else {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, oDto.getMensagem(), null));
		}
		
		orderService = new OrderService();
		return "home-page";
	}
	public OrderServiceBean() {
		// TODO Auto-generated constructor stub
	}


	public OrderServiceController getOrderServiceController() {
		return orderServiceController;
	}


	public void setOrderServiceController(OrderServiceController orderServiceController) {
		this.orderServiceController = orderServiceController;
	}


	public OrderService getOrderService() {
		return orderService;
	}


	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public String getNomeCliente() {
		return orderService.getProvider() == null 
				? null : orderService.getProvider();
	}

}
