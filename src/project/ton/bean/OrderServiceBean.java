package project.ton.bean;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import project.ton.controller.OrderServiceController;
import project.ton.dao.jdbc.AcessDAO;
import project.ton.dao.jdbc.OrderServiceJdbc;
import project.ton.dto.OrderServiceDTO;
import project.ton.jasper.JasperFactory;
import project.ton.model.OrderService;
import project.ton.model.Provider;
import project.ton.model.User;

@ManagedBean(name="orderServiceBean")
@ViewScoped
public class OrderServiceBean {
	
	
	private OrderServiceController orderServiceController;
	
	private OrderService orderService;
	
	private List<OrderService> list = new ArrayList<>();
	
	public void inicializar(){
		orderService = new OrderService();
	}
	
	
	public void clienteSelecionado(SelectEvent event){
		Provider provider = (Provider) event.getObject();
		orderService.setProvider(provider.getIdProvider());
	}
	
	
	/*public void gerar()
	{
		Connection myConnection = null;
		try {
		AcessDAO acess = new AcessDAO();
		myConnection = acess.openConnection();
        String tComandoSQL = "SELECT * FROM ORDER_SERVICE";
        PreparedStatement tComandoJDBC = myConnection.prepareStatement(tComandoSQL);

        
        ResultSet rs = tComandoJDBC.executeQuery();
		
        myConnection.close();
        
        JRResultSetDataSource jr = new JRResultSetDataSource(rs);
        
        Map parameters = new HashMap();
        
        byte[] pdf = JasperRunManager.runReportToPdf("C:/Users/Daniel Candido/Documents/OPET/JAVA/TON_WS/src/project/ton/jasper/orderservice.jrxml", parameters);
		
        FacesContext tCtxJsf = FacesContext.getCurrentInstance();
        ExternalContext tCtxExterno = tCtxJsf.getExternalContext();

        // Retirando algum header previamente colocado pelo JSF
        tCtxExterno.responseReset();

        // Obtendo o buffer de saida do contexto externo
        OutputStream tSaida = tCtxExterno.getResponseOutputStream();
        
        // Configurando os headers para o browse
        tCtxExterno.setResponseContentType("application/pdf");
        tCtxExterno.setResponseContentLength(pdf.length);

        // Gravando o relatório no stream de saida
        tSaida.write(pdf);

        // Indicando para o JSF não renderizar a página
        tCtxJsf.responseComplete();
		} catch (SQLException | ClassNotFoundException | JRException | IOException e) {
			e.printStackTrace();
		}
        
        
	}*/
	
	public void imprimir()
    {
        try
        {
        	
            // Obtendo o relatório compilado
            JasperReport jasperReport = JasperFactory.getOrderService();

            // DataSource para a lista de alunos pesquisada
            JRDataSource tDataSource = new JRBeanCollectionDataSource(list);
            System.out.println(list);
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
    }

	
	 public String loginRecovery(@Context HttpServletRequest request) {

	        try {
	            HttpSession session = request.getSession();
	            User user = new User();
	            String cpfUser = session.getId(); 
	            user.setCpfUser(cpfUser);

	        } catch(NullPointerException ex) {

	        }
	        return loginRecovery(request);

	    }
	
	public String salvar(){
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		OrderServiceController oController = new OrderServiceController();
		OrderServiceDTO oDto = new OrderServiceDTO();
		
		System.out.println("Ordem registrada: " + orderService);
		oDto = oController.cadastrar(orderService);
		
		if(!contexto.getMessageList().isEmpty()){
			return "menu-principal";
		}
	

		if (oDto.isOk()) {
			orderService = oDto.getObjeto();
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, oDto.getMensagem(), null));
			orderServiceController = new OrderServiceController();
			
		} else {
			contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, oDto.getMensagem(), null));
		}
		
		orderService = new OrderService();
		return "servicos-contrato";
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
	public String getNameProvider() {
			return orderService.getProvider()== null 
				? null : orderService.getProvider();
	}
	
	@NotBlank
	public String getIdUser(){
		return orderService.getUserId()==null
				?null : orderService.getUserId();
	}
	
	public void setIdProvider(String idProvider){
		
	}


	public List<OrderService> getList() {
		OrderServiceJdbc oJdbc = new OrderServiceJdbc();
		if(list == null){
    		list = oJdbc.search();    
    		}
    	
        return list;
    }

	public void setList(List<OrderService> list) {
		this.list = list;
	}
		
}
