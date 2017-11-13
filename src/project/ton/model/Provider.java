package project.ton.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SERVICE_PROVIDER", schema="DanielDB")
@SequenceGenerator(name="IDPROVIDER_SEQ", sequenceName="IDPROVIDER_SEQ")
public class Provider {

	@Id
	@Column(name="ID_SERVICE_PROVIDER")
	private String idProvider;
	@Column(name="NAME_PROVIDER")
	private String nameProvider;
	@Column(name="CATEGORY")
	private int category;
	@Column(name="SUBCATEGORY")
	private String subcategory;
	@Column(name="TIME_OPEN")
	private String timeOpen;
	@Column(name="TIME_CLOSE")
	private String timeClose;

	public Provider(String pId, String pName, int pCategory, String pSubcategory, String pTimeOpen, String pTimeClose ){
		super();
		setIdProvider(pId);
		setNameProvider(pName);
		setCategory(pCategory);
		setSubcategory(pSubcategory);
		setTimeOpen(pTimeOpen);
		setTimeClose(pTimeClose);
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

	public String getTimeOpen() {
		return timeOpen;
	}

	public void setTimeOpen(String timeOpen) {
		this.timeOpen = timeOpen;
	}

	public String getTimeClose() {
		return timeClose;
	}

	public void setTimeClose(String timeClose) {
		this.timeClose = timeClose;
	}


	
}
