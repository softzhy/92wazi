/**
 * 
 */
package jay.box.taobao.crawl.hibernate;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * @author Jay
 *
 */
@Entity
public class TaobaoTransaction implements Serializable {

	private static final long serialVersionUID = 1L;

	public final static Integer RATE_OK = 0, RATE_NORMAL = 1, RATE_BAD = 2; 
	
	private Long id;
	
	private TaobaoItem taobaoItem;
	
	private TaobaoBuyer buyer;
	
	private Double offer;//offer a price
	
	private Integer amount;//how many he buys ?
	
	private Date dealTime;//when the deal happens ?
	
	private String status;//what is the status of this transaction ? it should always be 'deal'

	@ManyToOne
	public TaobaoItem getTaobaoItem() {
		return taobaoItem;
	}

	public void setTaobaoItem(TaobaoItem taobaoItem) {
		this.taobaoItem = taobaoItem;
	}

	@ManyToOne
	public TaobaoBuyer getBuyer() {
		return buyer;
	}

	public void setBuyer(TaobaoBuyer buyer) {
		this.buyer = buyer;
	}

	public Double getOffer() {
		return offer;
	}

	public void setOffer(Double offer) {
		this.offer = offer;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
