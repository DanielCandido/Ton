package project.ton.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import project.ton.enums.ProviderSituation;
import project.ton.json.ProviderSituationDeserializerJson;
import project.ton.json.ProviderSituationSerializeJson;

@Entity()
@Table(name="USERS", schema="TONDBA")
@SequenceGenerator(name="IDUSER_SEQ", sequenceName="IDUSER_SEQ")
public class User implements Comparable<User>{
	@Id()
	@Column(name="ID_USER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GERADOR_IDUSER")
	@SequenceGenerator(name = "GERADOR_IDUSER", sequenceName = "IDUSER_SEQ", allocationSize = 1)
	private Integer idUser;

	@Column(name="FIRSTNAME_USER")
	private String firstNameUser;

	@Column(name="LASTNAME_USER")
	private String lastNameUser;

	@Column(name="EMAIL_USER")
	private String emailUser;

	@Column(name="RG_USER")
	private String rgUser;

	@Column(name="CPF_USER")
	private String cpfUser;

	@Column(name="PHONE_USER")
	private String phoneUser;

	@Column(name="CELLPHONE_USER")
	private String cellPhoneUser;

	@Column(name="ADRESS_USER")
	private String adressUser;

	@Column(name="CEP_USER")
	private String cepUser;

	@Column(name="PASSWORD_USER")
	private String passwordUser;

	@Column(name="REGISTER_DATE")
	private Date registerDate;

	@Column(name="PROVIDER")
	@Enumerated(EnumType.ORDINAL)
	@JsonSerialize(using = ProviderSituationSerializeJson.class)
	@JsonDeserialize(using = ProviderSituationDeserializerJson.class)
	private ProviderSituation situation;



	public User(Integer pId,String pFirstNameUser, String pLastNameUser, String pEmailUser, String pRgUser,
			String pCpfUser, String pPhoneUser, String pCellPhoneUser, String pAdressuser, String pCepUser, String pPasswordUser,
			Date pRegisterDate, ProviderSituation pSituation)
	{
		super();
		setIdUser(pId);
		setFirstNameUser(pFirstNameUser);
		setLastNameUser(pLastNameUser);
		setEmailUser(pEmailUser);
		setRgUser(pRgUser);
		setCpfUser(pCpfUser);
		setPhoneUser(pPhoneUser);
		setCellPhoneUser(pCellPhoneUser);
		setAdressUser(pAdressuser);
		setCepUser(pCepUser);
		setPasswordUser(pPasswordUser);
		setRegisterDate(pRegisterDate);
		setSituation(pSituation);

	}

	public User() {
		super();
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstNameUser() {
		return firstNameUser;
	}

	public void setFirstNameUser(String firstNameUser) {
		this.firstNameUser = firstNameUser;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public String getRgUser() {
		return rgUser;
	}

	public void setRgUser(String rgUser) {
		this.rgUser = rgUser;
	}

	public String getCpfUser() {
		return cpfUser;
	}

	public void setCpfUser(String cpfUser) {
		this.cpfUser = cpfUser;
	}

	public String getPhoneUser() {
		return phoneUser;
	}

	public void setPhoneUser(String phoneUser) {
		this.phoneUser = phoneUser;
	}

	public String getCellPhoneUser() {
		return cellPhoneUser;
	}

	public void setCellPhoneUser(String cellPhoneUser) {
		this.cellPhoneUser = cellPhoneUser;
	}

	public String getAdressUser() {
		return adressUser;
	}

	public void setAdressUser(String adressUser) {
		this.adressUser = adressUser;
	}

	public String getCepUser() {
		return cepUser;
	}

	public void setCepUser(String cepUser) {
		this.cepUser = cepUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public ProviderSituation getSituation() {
		return situation;
	}

	public void setSituation(ProviderSituation situation) {
		this.situation = situation;
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}

	 // Métodos da classe Object
    @Override
    public String toString()
    {
        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("Users [");
        tBuilder.append(getIdUser());
        tBuilder.append(", ");
        tBuilder.append(getFirstNameUser());
        tBuilder.append(", ");
        tBuilder.append(getLastNameUser());
        tBuilder.append(", ");
        tBuilder.append(getEmailUser());
        tBuilder.append(", ");
        tBuilder.append(getRgUser());
        tBuilder.append(", ");
        tBuilder.append(getCpfUser());
        tBuilder.append(", ");
        tBuilder.append(getRgUser());
        tBuilder.append(", ");
        tBuilder.append(getPhoneUser());
        tBuilder.append(", ");
        tBuilder.append(getCellPhoneUser());
        tBuilder.append(", ");
        tBuilder.append(getAdressUser());
        tBuilder.append(", ");
        tBuilder.append(getCepUser());
        tBuilder.append(", ");
        tBuilder.append(getPasswordUser());
        tBuilder.append(", ");
        tBuilder.append(getRegisterDate());
        tBuilder.append(", ");
        tBuilder.append(getSituation());
        tBuilder.append("]");
        return tBuilder.toString();
    }


}

