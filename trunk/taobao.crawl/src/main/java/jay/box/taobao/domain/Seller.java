package jay.box.taobao.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Seller extends User{

	private static final long serialVersionUID = 1L;
	
	private String name;//shop name
	
	private String taobaoId;//taobao used for identifying this shop
	
	private String url;//shop url
	
	private String ratingUrl;//page contains detail info about the seller
	
	//rating
	private Double serviceLevel;//communication and service
	
	private Double asDescribedLevel;// item as described
	
	private Double shippingLevel;//shipping time
	
	private Integer itemQuantity;//quantity of items
	
	private Date shopCreatedOn;
	
	private Integer hotIndex;//how many people favorites this shop.
	
	private String shopLocation;//where shop located
	
	private Integer sellerCredit;//shop credit
	
	private Integer buyerCredit;//buyer credit
	
	private String industryCategory;//which industry it belongs to

	private Date discoveredAt;
	
	private Date updatedAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaobaoId() {
		return taobaoId;
	}

	public void setTaobaoId(String taobaoId) {
		this.taobaoId = taobaoId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRatingUrl() {
		return ratingUrl;
	}

	public void setRatingUrl(String ratingUrl) {
		this.ratingUrl = ratingUrl;
	}

	public Double getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(Double serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public Double getAsDescribedLevel() {
		return asDescribedLevel;
	}

	public void setAsDescribedLevel(Double asDescribedLevel) {
		this.asDescribedLevel = asDescribedLevel;
	}

	public Double getShippingLevel() {
		return shippingLevel;
	}

	public void setShippingLevel(Double shippingLevel) {
		this.shippingLevel = shippingLevel;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Date getShopCreatedOn() {
		return shopCreatedOn;
	}

	public void setShopCreatedOn(Date shopCreatedOn) {
		this.shopCreatedOn = shopCreatedOn;
	}

	public Integer getHotIndex() {
		return hotIndex;
	}

	public void setHotIndex(Integer hotIndex) {
		this.hotIndex = hotIndex;
	}

	public String getShopLocation() {
		return shopLocation;
	}

	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}

	public Integer getSellerCredit() {
		return sellerCredit;
	}

	public void setSellerCredit(Integer sellerCredit) {
		this.sellerCredit = sellerCredit;
	}

	public Integer getBuyerCredit() {
		return buyerCredit;
	}

	public void setBuyerCredit(Integer buyerCredit) {
		this.buyerCredit = buyerCredit;
	}

	public String getIndustryCategory() {
		return industryCategory;
	}

	public void setIndustryCategory(String industryCategory) {
		this.industryCategory = industryCategory;
	}

	public Date getDiscoveredAt() {
		return discoveredAt;
	}

	public void setDiscoveredAt(Date discoveredAt) {
		this.discoveredAt = discoveredAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
