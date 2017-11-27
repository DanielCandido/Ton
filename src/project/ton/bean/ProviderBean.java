package project.ton.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import project.ton.controller.ProviderController;
import project.ton.controller.UserController;
import project.ton.dao.jdbc.ProviderDAOJdbc;
import project.ton.dto.ProviderDTO;
import project.ton.model.OrderService;
import project.ton.model.Provider;
import project.ton.model.User;

@Named("providerBean")
@ManagedBean
public class ProviderBean implements Serializable {

	private static final long serialVersionUID = 1846656949930562956L;

	private Provider providerSelecionado;
	private ProviderDAOJdbc providerDAO;
	private String nome = "";
	private List<Provider> searchList;
	private List<Provider> list = null;
	private OrderService orderService;
	
	
	public ProviderBean(){
		
	}
	
	public String registerProvider() {
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		ProviderController providerC = new ProviderController();
		ProviderDTO providerD = new ProviderDTO();
		
		System.out.println("Prestador |Cadastrado: " + providerSelecionado);
		
		providerD = providerC.cadastrar(providerSelecionado);
		
		
		if (!contexto.getMessageList().isEmpty()) {
			return "login-user";
		}
		
		if (providerD.isOk()) {
			providerSelecionado = providerD.getObjeto();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, providerD.getMensagem(), null));
			providerC = new ProviderController();
			
		} else {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, providerD.getMensagem(), null));
		}
		
		providerSelecionado = new Provider();
		return "login-user";
	}
	
	public void pesquisarNome(String nomeUser){
		Provider provider = new Provider();
		System.out.println(this.getNome());
		searchList = providerDAO.searchByName(provider.getNameProvider());
	}
		
	public void abrirDialogo() {
		  Map<String, Object> optionsDialog = new HashMap<>();
		  optionsDialog.put("modal", true);
		  optionsDialog.put("resizable", false);
		  optionsDialog.put("contentHeight", 470);        

		  RequestContext.getCurrentInstance()
		      .openDialog("home-page", optionsDialog, null);
		}
	
	public void Selecionar(Provider provider)
	{
		RequestContext.getCurrentInstance().closeDialog(provider);
	}
	
	/*public void ProviderSelect(SelectEvent event)
	{
		Provider provider = (Provider) event.getObject();
		orderService.setProvider(provider.getIdProvider());
		
	}*/

    public List<Provider> getList()
    {
    	ProviderDAOJdbc providerRN = new ProviderDAOJdbc();
    	if(list == null){
    		list = providerRN.search();    
    		}
    	
        return list;
    }

    public void selecionar(Provider provider){
    	RequestContext.getCurrentInstance().closeDialog(provider);
    }
    
	public Provider getProviderSelecionado() {
		return providerSelecionado;
	}

	public void setProviderSelecionado(Provider providerSelecionado) {
		this.providerSelecionado = providerSelecionado;
	}

	public List<Provider> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<Provider> searchList) {
		this.searchList = searchList;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

    
}
