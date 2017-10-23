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

	@Id()
	@Column(name="ID_PROVIDER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GERADOR_IDPROVIDER")
	@SequenceGenerator(name = "GERADOR_IDPROVIDER", sequenceName = "IDPROVIDER_SEQ", allocationSize = 1)
	private Integer idProvider;
	@Column(name="SUBCATEGORY")
	private int subcategory;
	@Column(name="TIME_OPEN")
	private String timeOpen;
	@Column(name="TIME_CLOSE")
	private String timeClose;

	public Provider(int pId, int pSubcategory, String pTimeOpen, String pTimeClose ){
		super();
		setIdProvider(pId);
		setSubcategory(pSubcategory);
		setTimeOpen(pTimeOpen);
		setTimeClose(pTimeClose);
	}


	public Provider(){
		super();
	}
	public int getIdProvider() {
		return idProvider;
	}
	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}
	public int getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(int subcategory) {
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
