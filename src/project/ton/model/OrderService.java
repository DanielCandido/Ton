package project.ton.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity()
@Table(name="ORDER_SERVICE", schema="DanielCandido")
public class OrderService implements Comparable<OrderService>{

    @Id()
    @Column(name="ID_ORDER")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GERADOR_IDORDER")
    @SequenceGenerator(name = "GERADOR_IDORDER", sequenceName = "IDORDERSERVICE_SEQ", allocationSize = 1)
    private int idOrder;
    @Column(name="SERVICE_PROVIDER_ID")
    private String provider;
    @Column(name="DATE_ORDER")
	private Date dateOrder;
	@Column(name="CEP_ORDER")
	private String cepOrder;
    @Column(name="STATUS_ORDER")
	private String situation;
	@Column(name="USER_ID_USER")
	private String userId;

	public OrderService(int pIdOrder, String pProvider,Date pDateOrder,String cepOrder,String pOrderSituation, String pUserID)
	{
	    super();
	    setIdOrder(pIdOrder);
	    setProvider(pProvider);
	    setDateOrder(pDateOrder);
	    setCepOrder(cepOrder);
	    setSituation(pOrderSituation);
	    setUserId(pUserID);
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


	public String getProvider() {
		return provider;
	}


	public void setProvider(String provider) {
		this.provider = provider;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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


	public String getSituation() {
		return situation;
	}


	public void setSituation(String situation) {
		this.situation = situation;
	}


	@Override
	public int compareTo(OrderService o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	 // Métodos da classe Object
    @Override
    public String toString()
    {
        StringBuilder tBuilder = new StringBuilder();
        tBuilder.append("Order_service[");
        tBuilder.append(getIdOrder());
        tBuilder.append(", ");
        tBuilder.append(getProvider());
        tBuilder.append(", ");
        tBuilder.append(getCepOrder());
        tBuilder.append(", ");
        tBuilder.append(getSituation());
        tBuilder.append(", ");
        tBuilder.append(getDateOrder());
        tBuilder.append(", ");
        tBuilder.append(getUserId());
        tBuilder.append("]");
        return tBuilder.toString();
    }

}
