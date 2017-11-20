package project.ton.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY", schema="DanielCandido")
public class Category implements Comparable<Category>{
	@Id()
	@Column(name="ID_CATEGORY")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GERADOR_IDCATEGORY")
	@SequenceGenerator(name = "GERADOR_IDCATEGORY", sequenceName = "IDCATEGORY_SEQ", allocationSize = 1)
	private int idCategory;

	@Column(name="NAME_CATEGORY")
	private String nameCategory;

	@Override
	public int compareTo(Category o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	
	

}
