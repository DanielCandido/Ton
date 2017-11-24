package project.ton.dto;

import java.util.List;

import project.ton.model.Category;

public class CategoryDTO {

	private boolean ok;
	private String mensagem;
	private Category category;
	private List<String> list;
	

	public CategoryDTO(boolean pOK, String pMensagem) {
		super();
		ok = pOK;
		mensagem = pMensagem;
	}

	public CategoryDTO(boolean pOK, String pMensagem, Category pCategory) {
		super();
		ok = pOK;
		mensagem = pMensagem;
		category = pCategory;
	}
	   public CategoryDTO(boolean pOk, String pMensagem, List<String> pList)
	    {
	      super();
	      ok = pOk;
	      mensagem = pMensagem;
	      list = pList;
	      
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

	
	

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

		public List<String> getList() {
			return list;
		}

		public void setList(List<String> list) {
			this.list = list;
		}

		public boolean isOk() {
			return ok;
		}

		public void setOk(boolean ok) {
			this.ok = ok;
		}
	    
}
