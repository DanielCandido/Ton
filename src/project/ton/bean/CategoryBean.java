package project.ton.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import project.ton.dao.jdbc.CategoryDAOJdbc;
import project.ton.model.Category;

@ManagedBean(name="categoryBean")
@RequestScoped
public class CategoryBean implements Serializable{
	
	private static final long serialVersionUID = 6723241327106002097L;
	
	private Category categorySelecionado;
	private List<String> listCategory = null;

	public List<String> getListCategory() 
	{
		CategoryDAOJdbc categoryRN = new CategoryDAOJdbc();
		if(listCategory == null){
			listCategory = categoryRN.search();
		}
		
				return listCategory;
	}

	public Category getCategorySelecionado() {
		return categorySelecionado;
	}

	public void setCategorySelecionado(Category categorySelecionado) {
		this.categorySelecionado = categorySelecionado;
	}

	

}
