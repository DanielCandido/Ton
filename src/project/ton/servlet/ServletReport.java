package project.ton.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import project.ton.dao.jdbc.OrderServiceJdbc;

public class ServletReport extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 574809409830930505L;
	OrderServiceJdbc order = new OrderServiceJdbc();
	String url = "C:/Users/Daniel Candido/Desktop/";
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	byte[] pdfReport = null;
    	
    	try {
    		JasperReport reportStream = JasperCompileManager.compileReport(url + "orderservice.jrxml");
    		/*JasperPrint report = JasperFillManager.fillReport(reportStream, null, new JRBeanCollectionDataSource(controller.getNotas(id)));
    		pdfReport = JasperExportManager.exportReportToPdf(report);*/
    		pdfReport = JasperRunManager.runReportToPdf(reportStream, null, new JRBeanCollectionDataSource(order.search()));
    		
    	} catch (Exception e) {
    		System.out.println("Erro na geração de pdf");
    	}

    	
        ServletOutputStream outputStream = response.getOutputStream();
        response.addHeader("Content-Type", "application/pdf");
        response.addHeader("Content-Disposition", "attachment; filename=historico-ordens.pdf");
        response.setContentLength((int) pdfReport.length);
        
        outputStream.write(pdfReport);
        outputStream.flush();
    }

}
