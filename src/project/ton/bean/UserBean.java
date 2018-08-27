package project.ton.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import project.ton.controller.UserController;
import project.ton.dao.jdbc.UserDaoJdbc;
import project.ton.dto.UserDTO;
import project.ton.model.Provider;
import project.ton.model.User;
import project.ton.util.SessionUtils;

@ManagedBean(name="userBean")
@ViewScoped
public class UserBean implements Serializable {

	
	public UserBean(){
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -826915979470770097L;

	// Atributos globais
	private User userSelect = new User();
	private Provider providerSelect = new Provider();
	private UserController userController;
	private UserDaoJdbc userDAO;
	private String emailLogin;

	private String senhaLogin;

	/**
	 * Metodo para cadastrar
	 * @return 
	 * @return 
	 * 
	 * @return
	 */

	public String saveUser() {	
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		UserController userRN = new UserController();
		UserDTO userDTO = new UserDTO();
		
		System.out.println("Usuario Cadastrado:  " + userSelect);
		userDTO = userRN.cadastrar(userSelect);
		
		if (!contexto.getMessageList().isEmpty()) {
			return "login-user";
		}
		
		if (userDTO.isOk()) {
			userSelect = userDTO.getObjeto();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, userDTO.getMensagem(), null));
			userRN = new UserController();
			
		} else {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, userDTO.getMensagem(), null));
		}
		
		userSelect = new User();
		return "login-user";
	}
	

	// Metodo de login
	public String fazerLogin() {

		userDAO = new UserDaoJdbc();
		boolean validar = userDAO.loginUser(emailLogin, senhaLogin);
		System.out.println("Login Efetivado");
		if (validar) {
			System.out.println("Entrou");

			HttpSession session = SessionUtils.getSession();
			session.setAttribute("EMAIL_USER", emailLogin);
			return "menu-principal";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou senha incorreto", null));
			return "login-user";
		}
	}

	
	
	
	public void info() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Campo Obrigatorio"));
	}

	public void warning() {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Impossivel inserir, Campo nulo"));
	}


	public User getUserSelect() {
		return userSelect;
	}


	public void setUserSelect(User userSelect) {
		this.userSelect = userSelect;
	}

	public Provider getProviderSelect() {
		return providerSelect;
	}


	public void setProviderSelect(Provider providerSelect) {
		this.providerSelect = providerSelect;
	}


	public String getEmailLogin() {
		return emailLogin;
	}


	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}


	public String getSenhaLogin() {
		return senhaLogin;
	}


	public void setSenhaLogin(String senhaLogin) {
		this.senhaLogin = senhaLogin;
	}


}
