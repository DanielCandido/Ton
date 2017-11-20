package project.ton.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import project.ton.dao.jdbc.CategoryDAOJdbc;
import project.ton.model.Category;

@ManagedBean(name="categoryBean")
@RequestScoped
public class CategoryBean {
	
	private Category category;
	private List<Category> listCategory = null;

	public List<Category> getListCategory() 
	{
		CategoryDAOJdbc categoryRN = new CategoryDAOJdbc();
		if(listCategory == null){
			listCategory = categoryRN.search();
		}
		
				return listCategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	


}
