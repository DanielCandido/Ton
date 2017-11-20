package project.ton.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;

import project.ton.dao.jdbc.ProviderDAOJdbc;
import project.ton.model.Provider;

@Named("providerBean")
@ManagedBean
public class ProviderBean implements Serializable {

	private static final long serialVersionUID = 1846656949930562956L;

	private Provider providerSelecionado;
	private List<Provider> searchList =  null;
	private List<Provider> list = null;
	/**
	 * Metodo para cadastrar
	 *
	 * @return
	 */
	public String registerProvider() {
		return null;

	}
	
	
	
	private EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	/* public void actionCarregaUsuarioSelecionado(ActionEvent event){
	        HtmlDataTable dataTable = (HtmlDataTable) event.getComponent().getParent();
			Provider obj = ((Provider) dataTable.getRowData());
	  }*/


    public List<Provider> getList()
    {
    	ProviderDAOJdbc providerRN = new ProviderDAOJdbc();
    	if(list == null){
    		list = providerRN.search();    
    		}
    	
        return list;
    }

	public Provider getProviderSelecionado() {
		return providerSelecionado;
	}

	public void setProviderSelecionado(Provider providerSelecionado) {
		this.providerSelecionado = providerSelecionado;
	}

	public List<Provider> getSearchList(String nome) {
		
		ProviderDAOJdbc providerCN = new ProviderDAOJdbc();
		if(list == null){
			list = providerCN.searchByName(nome);
		}
		
		return list;
	}

    
}
