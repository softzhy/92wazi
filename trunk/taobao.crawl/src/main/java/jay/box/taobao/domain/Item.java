package jay.box.taobao.domain;

import java.io.Serializable;

import javax.persistence.OneToOne;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToOne
	private Buyer belongsTo;//whom this item belongs to
	
	private String itemUrl;
	
	private Double price;
	
	private String title;
	
	private boolean isSnapshot;//snapshot 

	public Buyer getBelongsTo() {
		return belongsTo;
	}

	public void setBelongsTo(Buyer belongsTo) {
		this.belongsTo = belongsTo;
	}

	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isSnapshot() {
		return isSnapshot;
	}

	public void setSnapshot(boolean isSnapshot) {
		this.isSnapshot = isSnapshot;
	}
}
