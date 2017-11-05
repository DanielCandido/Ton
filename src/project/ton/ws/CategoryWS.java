package project.ton.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import project.ton.controller.CategoryController;
import project.ton.dto.CategoryDTO;

@Path("/Categorias")
public class CategoryWS {

	@GET
	@Path("/ListarCategorias")
	@Produces(MediaType.APPLICATION_JSON)
	public CategoryDTO pesquisar(){
		return new CategoryController().pesquisar();
	}
}
