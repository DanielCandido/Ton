package project.ton.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;


@Entity()
@Table(name="USERS", schema="DanielDB" , uniqueConstraints={@UniqueConstraint(columnNames="CPF_USER)")})
public class User implements Comparable<User>{
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid" , strategy = "uuid2")
	@Column(name="CPF_USER")
	private String cpfUser;
	
	@Column(name="FIRSTNAME_USER")
	private String firstNameUser;

	@Column(name="LASTNAME_USER")
	private String lastNameUser;

	@Column(name="EMAIL_USER")
	private String emailUser;

	@Column(name="RG_USER")
	private String rgUser;

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
	private String situation;



	public User(String pFirstNameUser, String pLastNameUser, String pEmailUser, String pRgUser,
			String pCpfUser, String pPhoneUser, String pCellPhoneUser, String pAdressuser, String pCepUser, String pPasswordUser,
			Date pRegisterDate, String pSituation)
	{
		super();
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

	public void setCpfUser(String i) {
		this.cpfUser = i;
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

	
	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	/*public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
*/
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

