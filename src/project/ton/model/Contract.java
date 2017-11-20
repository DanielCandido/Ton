package project.ton.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import project.ton.enums.ContractSituation;

@Entity()
@Table(name="CONTRACT", schema="DanielCandido")
public class Contract implements Comparable<Contract>{

	@Id()
	@Column(name="ID_CONTRACT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GERADOR_IDCONTRACT")
	@SequenceGenerator(name = "GERADOR_IDCONTRACT", sequenceName = "IDCONTRACT_SEQ", allocationSize = 1)
	private int idContract;

	@Column(name="CONTRACT_DATE")
	private Date dateContract;

	@Enumerated(EnumType.ORDINAL)
	@Column(name="STATUS_CONTRACT")
	private ContractSituation contractSituation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ID_PROVIDER_CONTRACT", referencedColumnName="ID_SERVICE_PROVIDER",nullable = false)
	private Provider provider;

	public Contract(int pIdContract, Date pDateContract, ContractSituation pContractSituation, Provider pProvider){
		super();
		setIdContract(pIdContract);
		setDateContract(pDateContract);
		setContractSituation(pContractSituation);
		setProvider(pProvider);
	}

	public Contract()
	{
		super();
	}
	public int getIdContract() {
		return idContract;
	}
	public void setIdContract(int idContract) {
		this.idContract = idContract;
	}
	public Date getDateContract() {
		return dateContract;
	}
	public void setDateContract(Date dateContract) {
		this.dateContract = dateContract;
	}
	public ContractSituation getContractSituation() {
		return contractSituation;
	}
	public void setContractSituation(ContractSituation contractSituation) {
		this.contractSituation = contractSituation;
	}


	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@Override
	public int compareTo(Contract o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
