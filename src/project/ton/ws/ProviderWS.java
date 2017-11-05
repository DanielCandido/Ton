package project.ton.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import project.ton.controller.ProviderController;
import project.ton.dto.ProviderDTO;
import project.ton.model.Provider;

@Path("/Servicos")
public class ProviderWS {
	
	@POST
	@Path("/Cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProviderDTO cadastrar(Provider tProvider){
		return new ProviderController().cadastrar(tProvider);
	}
	
	@GET
	@Path("/ListarServico")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ProviderDTO pesquisar(){
		return new ProviderController().pesquisar();
	}
	
}
