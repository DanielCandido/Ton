package project.ton.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import project.ton.controller.OrderServiceController;
import project.ton.dto.OrderServiceDTO;
import project.ton.model.OrderService;
import project.ton.model.Provider;

@ManagedBean(name="orderServiceBean")
@ViewScoped
public class OrderServiceBean {
	
	
	private OrderServiceController orderServiceController;
	
	private FacesMessage messages;
	
	private OrderService orderService;
	
	public void inicializar(){
		orderService = new OrderService();
	}
	
	
	public void clienteSelecionado(SelectEvent event){
		Provider provider = (Provider) event.getObject();
		orderService.setProvider(provider);
	}
	
	public String salvar(){
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		orderServiceController = new OrderServiceController();
		OrderServiceDTO oDto = new OrderServiceDTO();
		System.out.println("Ordem registrada: " + orderService);
		orderService.setSituation("Em analise");
		
		OrderService order = new OrderService();
		order = orderService;
		orderServiceController.cadastrar(order);
		
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
	
	@NotBlank
	public String getIdProvider() {
		return orderService.getProvider() == null 
				? null : orderService.getProvider().getNameProvider();
	}
	
	public void setIdProvider(String idProvider){
		
	}

	
}
