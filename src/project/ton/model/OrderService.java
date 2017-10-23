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

import project.ton.enums.OrderServiceSituation;
@Entity()
@Table(name="ORDER_SERVICE", schema="DanielDB")
public class OrderService {

    @Id()
    @Column(name="ID_ORDER")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GERADOR_IDORDER")
    @SequenceGenerator(name = "GERADOR_IDORDER", sequenceName = "IDORDERSERVICE_SEQ", allocationSize = 1)
    private int idOrder;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERVICE_PROVIDER_ID", referencedColumnName = "ID_PROVIDER" ,nullable = false)
    private Provider provider;
    @Column(name="DATE_ORDER")
	private Date dateOrder;
	@Column(name="CEP_ORDER")
	private String cepOrder;
	@Enumerated(EnumType.ORDINAL)
    @Column(name="STATUS_ORDER")
	private OrderServiceSituation situation;

	public OrderService(int pIdOrder, Provider pProvider,Date pDateOrder,String cepOrder,OrderServiceSituation pOrderSituation)
	{
	    super();
	    setIdOrder(pIdOrder);
	    setProvider(pProvider);
	    setDateOrder(pDateOrder);
	    setCepOrder(cepOrder);
	    setSituation(pOrderSituation);
	}


	public OrderService()
	{
	    super();

	}

	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	public Date getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}
	public String getCepOrder() {
		return cepOrder;
	}
	public void setCepOrder(String cepOrder) {
		this.cepOrder = cepOrder;
	}
	public OrderServiceSituation getSituation() {
		return situation;
	}
	public void setSituation(OrderServiceSituation situation) {
		this.situation = situation;
	}



}
