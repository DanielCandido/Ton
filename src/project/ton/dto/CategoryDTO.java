package project.ton.dto;

import java.util.List;

import project.ton.model.Category;

public class CategoryDTO extends AbstractDto<Category>{

	private Category category;
	private List<Category> list;
	

	public CategoryDTO(boolean pOK, String pMensagem) {
		super(pOK, pMensagem);
	}

	public CategoryDTO(boolean pOK, String pMensagem, Category pCategory) {
		super(pOK, pMensagem);
	}
	   public CategoryDTO(boolean pOk, String pMensagem, List<Category> pList)
	    {
	      super (pOk,pMensagem,pList);
	    }


	   /* metodos de acesso*/
	   public Category getCategory()
	    {
	        return category;
	    }

	    public void setCategory(Category pCategory)
	    {
	       category = pCategory;
	    }

	    public List<Category> getList()
	    {
	        return list;
	    }

	    public void setList(List<Category> pList)
	    {
	        list = pList;
	    }
}
