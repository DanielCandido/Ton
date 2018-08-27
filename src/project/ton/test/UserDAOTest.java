package project.ton.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.ton.controller.JasperController;
import project.ton.model.OrderService;

public class UserDAOTest {

	public static void main(String[] args) throws Exception {
		
		/*Category c = new Category();
		CategoryDAOJdbc categoryD = new CategoryDAOJdbc();
		List<Category> list = categoryD.search();

		System.out.println(list);
		
		ProviderDAOJdbc pDAO = new ProviderDAOJdbc();
		List<Provider> listp = pDAO.search();
	
		System.out.println(listp);
	
		ProviderDAOJdbc yDAO = new ProviderDAOJdbc();
		List<Provider> listSeach = yDAO.searchByName("JOAO");
		System.out.println(listSeach);*/
		
		try{
			List<OrderService> ordens = new ArrayList<OrderService>();
		//Testa Jasper
		OrderService order = new OrderService();
		order.setIdOrder(28);
		order.setProvider("10000000001");
		order.setCepOrder("Rua xv");
		order.setDateOrder(new Date());
		order.setSituation("Em analise");
		order.setUserId("10000000002");
		
		ordens.add(order);
		JasperController jasper = new JasperController();
		jasper.imprimir(ordens);
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
	}	
}

