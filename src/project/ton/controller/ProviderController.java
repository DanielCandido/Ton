package project.ton.controller;

import java.util.Date;
import java.util.List;

import project.ton.dao.hibernate.DaoFactory;
import project.ton.dao.i.ProviderDAO;
import project.ton.dto.ProviderDTO;
import project.ton.dto.UserDTO;
import project.ton.model.Provider;
import project.ton.model.User;

public class ProviderController {
	
	 public ProviderDTO cadastrar(Provider pProvider)
	    {
	        // Validando os parÃ¢metros de entrada
	        if (pProvider == null)
	            return new ProviderDTO(false, "Tentativa de inserir um usuario nulo");

	        // Criando os objetos DAO
	        ProviderDAO tDaoProvider = DaoFactory.getProviderDAO();
	        
	        MailController mail = new MailController();

	        // Verificando se o User jÃ¡ estÃ¡ cadastrado
	        Provider tProvider = tDaoProvider.recoveryProvider(pProvider.getEmailProvider(), pProvider.getIdProvider());
	        if (tProvider != null)
	            return new ProviderDTO(false, "ja existe usuario cadastrado com esse email");
	        // Inserindo o User
	        
	        pProvider.setSituacao("Em Analise");
	        pProvider.setRegisterDate(new Date());
	        System.out.println("Chegou isso: " + pProvider);
	        tProvider = tDaoProvider.create(pProvider);

	        // Verificando se houve erro de criaÃ§Ã£o
	        if (tProvider == null)
	            return new ProviderDTO(false, "Problemas na grava��o do usuario");

	        // Retornando o indicativo de sucesso com o objeto cadastrado
	        String mensagem = "<h1>Ol� " + tProvider.getNameProvider() + ", Bem vindo ao ton";
	        mail.sendMail(tProvider.getEmailProvider(), mensagem);
	        return new ProviderDTO(true, "Prestador cadastrado com sucesso", tProvider);
	        	
	    }
	 
	 public ProviderDTO pesquisar(){
		 ProviderDAO tProviderDAO = DaoFactory.getProviderDAO();
		 
		 List<Provider> tLista = tProviderDAO.search();
		 
		 return new ProviderDTO(true, "Lista de servi�os recuperada", tLista);
		 
		 
	 }

}
