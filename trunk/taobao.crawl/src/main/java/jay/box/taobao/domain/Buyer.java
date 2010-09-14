package jay.box.taobao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Buyer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String userId;//taobao id
	
	private Integer buyerCredit;
	
	private String userLocation;//where user comes from
	
	private Date registeredOn;//date registered
	
	private Date lastLoginOn;
	
	private String ratingUrl;//user rating url

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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

	public Date getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(Date registeredOn) {
		this.registeredOn = registeredOn;
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
