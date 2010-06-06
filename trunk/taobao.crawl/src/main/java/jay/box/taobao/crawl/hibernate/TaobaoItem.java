package jay.box.taobao.crawl.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaobaoItem {
	
	public static Integer RSMS = 0x1;
	
	public static Integer QTTH = 0x10;
	
	private String itemURL;
	
	private String itemTitle;
	
	private String ownerURL;
	
	private String ownerNickname;
	
	private Double price;
	
	private String place;
	
	private Integer sale; //how many has been sell recently
	
	private Double shipping; //shipping price
	
	private Integer baozhang;//baozhang

	@Id
	public String getItemURL() {
		return itemURL;
	}

	public void setItemURL(String itemURL) {
		this.itemURL = itemURL;
	}

	public String getOwnerURL() {
		return ownerURL;
	}

	public void setOwnerURL(String ownerURL) {
		this.ownerURL = ownerURL;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Integer getSale() {
		return sale;
	}

	public void setSale(Integer sale) {
		this.sale = sale;
	}

	public Double getShipping() {
		return shipping;
	}

	public void setShipping(Double shipping) {
		this.shipping = shipping;
	}

	public String getOwnerNickname() {
		return ownerNickname;
	}

	public void setOwnerNickname(String ownerNickname) {
		this.ownerNickname = ownerNickname;
	}

	public Integer getBaozhang() {
		return baozhang;
	}

	public void setBaozhang(Integer baozhang) {
		this.baozhang = baozhang;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
}
