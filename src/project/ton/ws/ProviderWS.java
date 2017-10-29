package project.ton.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import project.ton.controller.ProviderController;
import project.ton.dto.ProviderDTO;

@Path("/Servicos")
public class ProviderWS {
	
	@GET
	@Path("/ListarServico")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public ProviderDTO pesquisar(){
		return new ProviderController().pesquisar();
	}
	
}
