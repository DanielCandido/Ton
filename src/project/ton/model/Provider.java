package project.ton.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SERVICE_PROVIDER", schema="DanielCandido")
public class Provider implements Comparable<Provider>{

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
	@Column(name="EMAIL_PROVIDER")
	private String emailProvider;
	@Column(name="PHONE_PROVIDER")
	private String phoneProvider;
	@Column(name="CELLPHONE_PROVIDER")
	private String cellphoneProvider;
	@Column(name="ADRESS_PROVIDER")
	private String adressProvider;
	@Column(name="PASSWORD_PROVIDER")
	private String passwordProvider;
	@Column(name="REGISTER_DATE")
	private Date registerDate;
	
	public Provider(String pId, String pName, int pCategory, String pSubcategory, String pSituacao, String pEmail, String pPhone,
				String cellphone, String adress, String password, Date register){
		super();
		setIdProvider(pId);
		setNameProvider(pName);
		setCategory(pCategory);
		setSubcategory(pSubcategory);
		setSituacao(pSituacao);
		setEmailProvider(pEmail);
		setPhoneProvider(pPhone);
		setCellphoneProvider(cellphone);
		setAdressProvider(adress);
		setPasswordProvider(password);
		setRegisterDate(register);
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

	public String getEmailProvider() {
		return emailProvider;
	}

	public void setEmailProvider(String emailProvider) {
		this.emailProvider = emailProvider;
	}

	public String getPhoneProvider() {
		return phoneProvider;
	}

	public void setPhoneProvider(String phoneProvider) {
		this.phoneProvider = phoneProvider;
	}

	public String getCellphoneProvider() {
		return cellphoneProvider;
	}

	public void setCellphoneProvider(String cellphoneProvider) {
		this.cellphoneProvider = cellphoneProvider;
	}

	public String getAdressProvider() {
		return adressProvider;
	}

	public void setAdressProvider(String adressProvider) {
		this.adressProvider = adressProvider;
	}

	public String getPasswordProvider() {
		return passwordProvider;
	}

	public void setPasswordProvider(String passwordProvider) {
		this.passwordProvider = passwordProvider;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public int compareTo(Provider o) {
		// TODO Auto-generated method stub
		return 0;
	}

	 // Métodos da classe Object
    @Override
    public String toString()
    {
        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("Service_provider[");
        tBuilder.append(getIdProvider());
        tBuilder.append(", ");
        tBuilder.append(getNameProvider());
        tBuilder.append(", ");
        tBuilder.append(getEmailProvider());
        tBuilder.append(", ");
        tBuilder.append(getCategory());
        tBuilder.append(", ");
        tBuilder.append(getSubcategory());
        tBuilder.append(", ");
        tBuilder.append(getAdressProvider());
        tBuilder.append(", ");
        tBuilder.append(getCellphoneProvider());
        tBuilder.append(", ");
        tBuilder.append(getPhoneProvider());
        tBuilder.append(", ");
        tBuilder.append(getPasswordProvider());
        tBuilder.append(", ");
        tBuilder.append(getRegisterDate());
        tBuilder.append(", ");
        tBuilder.append(getSituacao());
        tBuilder.append("]");
        return tBuilder.toString();
    }
	

}
