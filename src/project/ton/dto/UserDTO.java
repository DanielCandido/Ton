package project.ton.dto;

import java.util.List;

import project.ton.model.User;

public class UserDTO extends AbstractDto<User> {

	public UserDTO()
	{
		super();
	}
	/* Construtores de classe */

	public UserDTO(boolean pOK, String pMensagem) {
		super(pOK, pMensagem);
	}


	public UserDTO(boolean pOk, String pMensagem, List<User> pList) {
		super(pOk, pMensagem, pList);
	}

	public UserDTO(boolean pOK, String pMensagem, User pUser) {
		super(pOK, pMensagem);
	}

}
