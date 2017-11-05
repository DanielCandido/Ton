package project.ton.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.ton.controller.ProviderController;
import project.ton.dao.hibernate.ProviderDAOHibernate;
import project.ton.model.Provider;
import project.ton.model.User;
import project.ton.util.JsonUtil;

@Named("providerBean")
@ManagedBean
public class ProviderBean implements Serializable {
	
	private static final long serialVersionUID = 1846656949930562956L;
	
	private Provider provider;
	private ProviderController providerController;
	private ProviderDAOHibernate providerDAO;

	public ProviderBean() {
		provider = new Provider();
		providerController = new ProviderController();
		providerDAO = new ProviderDAOHibernate();
	}

	/**
	 * Metodo para cadastrar
	 * 
	 * @return
	 */
	public String registerProvider() throws JsonParseException, JsonMappingException, IOException {
		
		User user = new User();
		Provider provider = new Provider();
		provider.setIdProvider(user.getIdUser());
		ObjectMapper tConversorJsonJava = new ObjectMapper();
		
		String tUserJson1 = tConversorJsonJava.writeValueAsString(provider);
		
		System.out.println("Incluindo os usuarios validos");
		JsonUtil.enviarPost("http://localhost:8180/TON-WS/WS/Servicos/Cadastrar", tUserJson1);
		return null;
		
		
		
	}
	
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public ProviderController getProviderController() {
		return providerController;
	}

	public void setProviderController(ProviderController providerController) {
		this.providerController = providerController;
	}

	public ProviderDAOHibernate getProviderDAO() {
		return providerDAO;
	}

	public void setProviderDAO(ProviderDAOHibernate providerDAO) {
		this.providerDAO = providerDAO;
	}

}
