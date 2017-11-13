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

import project.ton.controller.UserController;
import project.ton.dao.hibernate.UserDAOHibernate;
import project.ton.dto.UserDTO;
import project.ton.model.User;
import project.ton.util.SessionUtils;
import project.ton.ws.UserWS;

@Named("userBean")
@SessionScoped
public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -826915979470770097L;

	// Atributos globais
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
	public void registerUser() throws JsonParseException, JsonMappingException, IOException {
		
		UserWS userWS = new UserWS();
		
		userWS.cadastrar(user);
		
		/*User tUser = getUser();
		UserController tUserController = new UserController();
		UserDTO tUserDTO = tUserController.cadastrar(tUser);
		
		if (tUserDTO.isOk()){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, tUserDTO.getMensagem(), "Processo de inclusão"));

		}
		else 
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, tUserDTO.getMensagem(),"Processo de inclusão"));*/
	}
	

	// Metodo de login
	public String fazerLogin() {

		boolean validar = userDAO.loginUser(emailLogin, senhaLogin);
		System.out.println("Login Efetivado");
		if (validar) {
			System.out.println("Entrou");

			HttpSession session = SessionUtils.getSession();
			session.setAttribute("EMAIL_USER", senhaLogin);
			return "home-page";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou senha incorreto", null));
			return "login_user";
		}
	}

	
	/* public void imprimir()
	    {
	        try
	        {
	            // Obtendo o relatório compilado
	            JasperReport jasperReport = JasperFactory.getRelacaoAlunosPesquisados();

	            // DataSource para a lista de alunos pesquisada
	            JRDataSource tDataSource = new JRBeanCollectionDataSource(listaAlunos);

	            // Preenchendo o relatório
	            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, tDataSource);

	            // Gerando o relatório em um array de bytes
	            byte[] tRelatorio = JasperExportManager.exportReportToPdf(jasperPrint);

	            // Obtendo o contexto externo da aplicação
	            FacesContext tCtxJsf = FacesContext.getCurrentInstance();
	            ExternalContext tCtxExterno = tCtxJsf.getExternalContext();

	            // Retirando algum header previamente colocado pelo JSF
	            tCtxExterno.responseReset();

	            // Obtendo o buffer de saida do contexto externo
	            OutputStream tSaida = tCtxExterno.getResponseOutputStream();

	            // Configurando os headers para o browse
	            tCtxExterno.setResponseContentType("application/pdf");
	            tCtxExterno.setResponseContentLength(tRelatorio.length);

	            // Gravando o relatório no stream de saida
	            tSaida.write(tRelatorio);

	            // Indicando para o JSF não renderizar a página
	            tCtxJsf.responseComplete();
	        }
	        catch (IOException | JRException tExcept)
	        {
	           throw new RuntimeException(tExcept);

	        }
	    }*/
	
	
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
