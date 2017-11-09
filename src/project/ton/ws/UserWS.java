package project.ton.ws;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import project.ton.controller.UserController;
import project.ton.dto.UserDTO;
import project.ton.model.User;

@Path("/Usuario")
public class UserWS {
	

    @GET
    @Path("/RecuperarObjeto")
    public User login(@Context HttpServletRequest request) {

        try {
            HttpSession session = request.getSession();
            User user = new User();
            long cpfUser = session.getCreationTime(); 
            user.setCpfUser(cpfUser);

        } catch(NullPointerException ex) {

        }
        return null;

    }

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO pesquisar(){
		return new UserController().pesquisar();
	}

	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO pesquisarPorNome(@PathParam("nome") String pNome){
		return new UserController().pesquisarPorNome(pNome);
	}

	@GET
	@Path("/Atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDTO atualizar(User pUser)
	{
		return new UserController().atualizar(pUser);
	}

	@POST
    @Path("/Cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO cadastrar(User pUser)
    {
		return new UserController().cadastrar(pUser);
    }

	 @DELETE
	 @Path("/Remover/{cpf}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public UserDTO removerUsuario(@PathParam("cpf") String pCpf)
	 {
		 return new UserController().remover(pCpf);
	 }
}
