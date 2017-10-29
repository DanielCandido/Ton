package project.ton.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import project.ton.dao.hibernate.ProviderDAOHibernate;
import project.ton.model.Provider;

@ManagedBean
@ViewScoped
public class ProviderListBean  implements Serializable {
	
	private List<Provider> provider1;
	
	private Provider selectProvider;
	
	@ManagedProperty("#{orderService}")
	private ProviderDAOHibernate service;
	
	@PostConstruct
	public void Init(){
		
	}
	

}
