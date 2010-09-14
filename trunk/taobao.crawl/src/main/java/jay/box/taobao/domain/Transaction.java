package jay.box.taobao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.OneToOne;

public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public final static Integer RATE_GOOD = 1, RATE_BAD = 3, RATE_NORMAL = 2;
	
	@OneToOne
	private Shop shop;
	
	@OneToOne
	private Buyer buyer;
	
	@OneToOne
	private Item item;
	
	private Double dealPrice;//deal price
	
	private Integer rate;//good, bad, normal
	
	private Date sellerRatedAt;
	
	private Date buyerRatedAt;

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Double getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(Double dealPrice) {
		this.dealPrice = dealPrice;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Date getSellerRatedAt() {
		return sellerRatedAt;
	}

	public void setSellerRatedAt(Date sellerRatedAt) {
		this.sellerRatedAt = sellerRatedAt;
	}

	public Date getBuyerRatedAt() {
		return buyerRatedAt;
	}

	public void setBuyerRatedAt(Date buyerRatedAt) {
		this.buyerRatedAt = buyerRatedAt;
	}
}
