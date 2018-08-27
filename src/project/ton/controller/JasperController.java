package project.ton.controller;


import java.util.List;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import project.ton.model.OrderService;

public class JasperController {
	
	private String path;

	private String pathToReportPackage;
	
	public JasperController(){
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = "C:/Users/Daniel Candido/Desktop/";
		System.out.println(path);
	}
	
	
	public void imprimir(List<OrderService> order) throws Exception	
	{
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "orderservice.jrxml");
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(order));
 
		JasperExportManager.exportReportToPdfFile(print, "C:/Users/Daniel Candido/Desktop/Relatorio_de_Ordens.pdf");		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPathToReportPackage() {
		return pathToReportPackage;
	}

	public void setPathToReportPackage(String pathToReportPackage) {
		this.pathToReportPackage = pathToReportPackage;
	}
	
	
}
