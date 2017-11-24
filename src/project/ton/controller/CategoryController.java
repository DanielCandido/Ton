package project.ton.controller;

import java.util.List;

import project.ton.dao.hibernate.DaoFactory;
import project.ton.dao.i.CategoryDAO;
import project.ton.dto.CategoryDTO;
import project.ton.model.Category;

public class CategoryController {
	
	 public CategoryDTO pesquisar()
	    {
	        // Criando os objetos DAO
	        CategoryDAO tCategory = DaoFactory.getCategoryDAO();

	        // Obtendo a lista de Users
	        List<String> tLista = tCategory.search();

	        // Retornando a lista obtida
	        return new CategoryDTO(true, "Lista de Usuarios recuperada", tLista);
	    }

}
