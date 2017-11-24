package project.ton.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SERVICE_PROVIDER", schema="DanielCandido")
public class Provider {

	@Id
	@Column(name="ID_SERVICE_PROVIDER")
	private String idProvider;
	@Column(name="NAME_PROVIDER")
	private String nameProvider;
	@Column(name="CATEGORY")
	private int category;
	@Column(name="DESCRICAO")
	private String subcategory;
	@Column(name="SITUACAO")
	private String situacao;
	
	public Provider(String pId, String pName, int pCategory, String pSubcategory, String pSituacao){
		super();
		setIdProvider(pId);
		setNameProvider(pName);
		setCategory(pCategory);
		setSubcategory(pSubcategory);
		setSituacao(pSituacao);
	}

	public Provider() {
		// TODO Auto-generated constructor stub
	}

	public String getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(String idProvider) {
		this.idProvider = idProvider;
	}

	public String getNameProvider() {
		return nameProvider;
	}

	public void setNameProvider(String nameProvider) {
		this.nameProvider = nameProvider;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	

}
