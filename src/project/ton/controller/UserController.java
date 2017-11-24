package project.ton.controller;


import java.util.Date;
import java.util.List;

import project.ton.dao.hibernate.DaoFactory;
import project.ton.dao.i.UserDAO;
import project.ton.dto.UserDTO;
import project.ton.model.User;

public class UserController {
	
	public UserDTO validarUsuario(String pCellPhone, String pSenha){
		if (pCellPhone == null)
            return new UserDTO(false, "Email invalido");
        if (pSenha == null || pSenha.isEmpty())
            return new UserDTO(false, "Senha invalida");

        // Criando os objetos DAO
        UserDAO tUserDAO = DaoFactory.getUserDAO();

        // Lendo o User
        User tUser = tUserDAO.recoveryUser(pCellPhone);

        // Verificando se houve erro de recuperação
        if (tUser == null)
            return new UserDTO(false, "Usuario não existe no cadastro");

        // Validar a senha
        if (tUser.getPasswordUser().equals(pSenha))
        {
            // Retornando o indicativo de sucesso com o objeto recuperado
            return new UserDTO(true, "Usuario identificado com sucesso", tUser);
        }
        else
        {
            // Retornando o indicativo de sucesso com o objeto recuperado
            return new UserDTO(false, "Problema na identificação do usuario");
        }
	}
	
	 public UserDTO cadastrar(User pUser)
	    {
		 
	        // Validando os parÃ¢metros de entrada
	        if (pUser == null)
	            return new UserDTO(false, "Tentativa de inserir um usuario nulo");

	        // Criando os objetos DAO
	        UserDAO tDaoUser = DaoFactory.getUserDAO();
	        
	        MailController mail = new MailController();

	        // Verificando se o User jÃ¡ estÃ¡ cadastrado
	        User tUser = tDaoUser.recoveryUser(pUser.getEmailUser());
	        if (tUser != null)
	            return new UserDTO(false, "ja existe usuario cadastrado com esse email");
	        // Inserindo o User
	        
	        pUser.setRegisterDate(new Date());
	        System.out.println("Chegou isso: " + pUser);
	        tUser = tDaoUser.createUser(pUser);

	        // Verificando se houve erro de criaÃ§Ã£o
	        if (tUser == null)
	            return new UserDTO(false, "Problemas na grava��o do usuario");

	        // Retornando o indicativo de sucesso com o objeto cadastrado
	        String mensagem = "<h1>Ol� " + tUser.getFirstNameUser() + ", Bem vindo ao ton";
	        mail.sendMail(tUser.getEmailUser(), mensagem);
	        return new UserDTO(true, "Usuario cadastrado com sucesso", tUser);
	        	
	        
	    }
	 
	  public UserDTO recuperar(String pCpf)
	    {
	        // Validando os parÃ¢metros de entrada
	        if (pCpf == null)
	            return new UserDTO(false, "cpf invalido");

	        // Criando os objetos DAO
	        UserDAO tDaoUser = DaoFactory.getUserDAO();

	        // Lendo o usuario
	        User tUser = tDaoUser.recoveryUser(pCpf);

	        // Verificando se houve erro de recuperaÃ§Ã£o
	        if (tUser == null)
	            return new UserDTO(false, "Usuario n�o existe");

	        // Retornando o indicativo de sucesso com o objeto recuperado
	        return new UserDTO(true, "usuario recuperado com sucesso", tUser);
	    }
	  
	  public UserDTO atualizar(User pUser)
	    {
	        // Validando os parÃ¢metros de entrada
	        if (pUser == null)
	            return new UserDTO(false, "Tentativa de atualizar um usuario nulo");

	        // Criando os objetos DAO
	        UserDAO tDaoUser = DaoFactory.getUserDAO();

	        // Atualizando o usuario
	        User tUser = tDaoUser.update(pUser);

	        // Verificando se houve erro de atualizaÃ§Ã£o
	        if (tUser == null)
	            return new UserDTO(false, "Usuario n�o existe no cadastro");

	        // Retornando o indicativo de sucesso com o objeto atualizado
	        return new UserDTO(true, "Usuario atualizado com sucesso", tUser);
	    }
	  

	    public UserDTO remover(String pCpf)
	    {
	        // Validando os parÃ¢metros de entrada
	        if (pCpf == null )
	            return new UserDTO(false, "Cpf invalido");

	        // Criando os objetos DAO
	        UserDAO tDaoUser = DaoFactory.getUserDAO();

	        User tUser = tDaoUser.recoveryUser(pCpf);
	        if (tUser == null)
	            return new UserDTO(false, "User nao existe no cadastro");
	        // Removendo o User
	        tDaoUser.deleteUser(pCpf);

	        // Retornando o indicativo de sucesso com o objeto removido
	        return new UserDTO(true, "User removido com sucesso", tUser);
	    }

	    public UserDTO pesquisar()
	    {
	        // Criando os objetos DAO
	        UserDAO tDaoUser = DaoFactory.getUserDAO();

	        // Obtendo a lista de Users
	        List<User> tLista = tDaoUser.search();

	        // Retornando a lista obtida
	        return new UserDTO(true, "Lista de Usuarios recuperada", tLista);
	    }

	    public UserDTO pesquisarPorNome(String pNome)
	    {
	        // Caso o nome de pesquisa seja nulo ou vazio, retorna a lista geral
	        if (pNome == null || pNome.isEmpty())
	            return pesquisar();

	        // Criando os objetos DAO
	        UserDAO tDaoUser = DaoFactory.getUserDAO();

	        // Obtendo a lista de Users
	        List<User> tLista = tDaoUser.searchByNome(pNome);

	        // Retornando a lista obtida
	        return new UserDTO(true, "Lista de Users com nome '" + pNome + "' recuperada", tLista);
	    }

	    public UserDTO pesquisarCelular(String pCellPhone)
	    {
	        // Caso o e-mail de pesquisa seja nulo ou vazio, retorna a lista geral
	        if (pCellPhone == null || pCellPhone.isEmpty())
	            return pesquisar();

	        // Criando os objetos DAO
	        UserDAO tDaoUser = DaoFactory.getUserDAO();

	        // Obtendo a lista de Users
	        List<User> tLista = tDaoUser.searchByCellPhone(pCellPhone);

	        // Retornando a lista obtida
	        return new UserDTO(true, "Lista de Users com e-mail '" + pCellPhone + "' recuperada", tLista);
	    }

}
