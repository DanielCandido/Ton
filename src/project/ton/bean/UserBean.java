package project.ton.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import project.ton.controller.UserController;
import project.ton.dao.hibernate.UserDAOHibernate;
import project.ton.model.User;
import project.ton.util.JsonUtil;
import project.ton.util.SessionUtils;

@Named("userBean")
@SessionScoped
public class UserBean  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -826915979470770097L;
	
	//Atributos globais
	private User user;
	private UserController userController;
	private UserDAOHibernate userDAO;
	private String emailLogin;

	private String senhaLogin;

	public UserBean() {
		user = new User();
		userController = new UserController();
		userDAO = new UserDAOHibernate();
		
	}
	
	/**
	 * Metodo para cadastrar
	 * 
	 * @return
	 */
	public String registerUser() throws JsonParseException, JsonMappingException, IOException {
		
		User user = new User();
		user.setIdUser(1);
		ObjectMapper tConversorJsonJava = new ObjectMapper();
		
		String tUserJson1 = tConversorJsonJava.writeValueAsString(user);
		
		System.out.println("Incluindo os usuarios validos");
		JsonUtil.enviarPost("http://localhost:8180/TON-WS/WS/Usuario/Cadastrar", tUserJson1);
		return null;
		
		
		
	}
	
	//Metodo de login
	public String fazerLogin(){
		
		boolean validar = userDAO.loginUser(emailLogin, senhaLogin);	
		System.out.println("Login Efetivado");
				if(validar){
					System.out.println("Entrou");
					
					HttpSession session =  SessionUtils.getSession();
					session.setAttribute("EMAIL_USER", senhaLogin);
					return "home-page";
				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou senha incorreto", null));
					return "LoginDoador";
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
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserController getUserController() {
		return userController;
	}

	public void setUserController(UserController userController) {
		this.userController = userController;
	}

	public UserDAOHibernate getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAOHibernate userDAO) {
		this.userDAO = userDAO;
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
