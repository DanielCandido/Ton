package project.ton.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.ton.controller.ProviderController;
import project.ton.dao.hibernate.ProviderDAOHibernate;
import project.ton.dao.jdbc.AcessDAO;
import project.ton.dto.ProviderDTO;
import project.ton.model.Provider;
import project.ton.util.JsonUtil;

@Named("providerBean")
@ManagedBean
public class ProviderBean implements Serializable {
	
	private static final long serialVersionUID = 1846656949930562956L;
	
	private Provider provider;
	private ProviderController providerController;
	private ProviderDAOHibernate providerDAO;

	private ArrayList<Provider>list;
	
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
	
		Provider provider = new Provider();
		ObjectMapper tConversorJsonJava = new ObjectMapper();
		
		String tUserJson1 = tConversorJsonJava.writeValueAsString(provider);
		
		System.out.println("Incluindo os usuarios validos");
		JsonUtil.enviarPost("http://localhost:8180/TON-WS/WS/Servicos/Cadastrar", tUserJson1);
		return null;
		
	}
	
	/*public ArrayList<Provider> listProvider(){
		String query = "SELECT * FROM SERVICE_PROVIDER";
		list = new ArrayList<Provider>();
		ProviderDTO providerDTO = new ProviderDTO();
		try {
			
			AcessDAO acess = new AcessDAO();
			Connection myConnection = null;
			
			myConnection = acess.openConnection();
			
			PreparedStatement pstm = myConnection.prepareStatement(query);
			
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()){
				provider.setIdProvider(rs.getString("ID_SERVICE_PROVIDER"));
				provider.setNameProvider(rs.getString("NAME_PROVIDER"));
				provider.setCategory(rs.getInt("CATEGORY"));
				provider.setSubcategory(rs.getString("SUBCATEGORY"));
				provider.setTimeOpen(rs.getString("TIME_OPEN"));
				provider.setTimeClose(rs.getString("TIME_CLOSE"));
				
				list.add(provider);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}*/
	
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

	public ArrayList<Provider> getList() {
		return list;
	}

	public void setList(ArrayList<Provider> list) {
		this.list = list;
	}

}
