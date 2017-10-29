package project.ton.controller;

import java.util.List;

import project.ton.dao.hibernate.DaoFactory;
import project.ton.dao.i.ProviderDAO;
import project.ton.dto.ProviderDTO;
import project.ton.model.Provider;

public class ProviderController {
	
	 public ProviderDTO cadastrar(Provider tProvider)
	    {
	        // Validando os parÃ¢metros de entrada
	        if (tProvider == null)
	            return new ProviderDTO(false, "Tentativa de inserir um usuario nulo");

	        // Criando os objetos DAO
	        ProviderDAO tDaoUser = DaoFactory.getProviderDAO();
	        
	        tDaoUser.create(tProvider);

	        // Retornando o indicativo de sucesso com o objeto cadastrado
	        return new ProviderDTO(true, "Usuario cadastrado com sucesso", tProvider);
	    }
	 
	 public ProviderDTO pesquisar(){
		 ProviderDAO tProviderDAO = DaoFactory.getProviderDAO();
		 
		 List<Provider> tLista = tProviderDAO.search();
		 
		 return new ProviderDTO(true, "Lista de servi�os recuperada", tLista);
		 
		 
	 }

}
