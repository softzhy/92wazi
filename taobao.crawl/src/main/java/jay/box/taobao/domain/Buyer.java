package jay.box.taobao.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Buyer extends User {

	private static final long serialVersionUID = 1L;

	private Integer buyerCredit;
	
	private String userLocation;//where user comes from
	
	private Date lastLoginOn;
	
	private String ratingUrl;//user rating url

	public Integer getBuyerCredit() {
		return buyerCredit;
	}

	public void setBuyerCredit(Integer buyerCredit) {
		this.buyerCredit = buyerCredit;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public Date getLastLoginOn() {
		return lastLoginOn;
	}

	public void setLastLoginOn(Date lastLoginOn) {
		this.lastLoginOn = lastLoginOn;
	}

	public String getRatingUrl() {
		return ratingUrl;
	}

	public void setRatingUrl(String ratingUrl) {
		this.ratingUrl = ratingUrl;
	}
}
