package project.ton.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import project.ton.dao.jdbc.ProviderDAOJdbc;
import project.ton.model.OrderService;
import project.ton.model.Provider;

@Named("providerBean")
@ManagedBean
public class ProviderBean implements Serializable {

	private static final long serialVersionUID = 1846656949930562956L;

	private Provider providerSelecionado;
	private ProviderDAOJdbc provider;
	private String nome;
	private List<Provider> searchList;
	private List<Provider> list = null;
	private OrderService orderService;
	/**
	 * Metodo para cadastrar
	 *
	 * @return
	 */
	public String registerProvider() {
		return null;

	}
	
	public void pesquisarNome(){
		searchList = provider.searchByName(nome);
	}
		
	public void abrirDialogo() {
		  Map<String, Object> optionsDialog = new HashMap<>();
		  optionsDialog.put("modal", true);
		  optionsDialog.put("resizable", false);
		  optionsDialog.put("contentHeight", 470);        

		  RequestContext.getCurrentInstance()
		      .openDialog("procedimentosPesquisaCompleta", optionsDialog, null);
		}
	
	public void Selecionar(Provider provider)
	{
		RequestContext.getCurrentInstance().closeDialog(provider);
	}
	
	public void ProviderSelect(SelectEvent event)
	{
		Provider provider = (Provider) event.getObject();
		orderService.setProvider(provider.getIdProvider());
		
	}

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
