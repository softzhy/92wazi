package jay.box.taobao.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String userId;//taobao id
	
	private String profilePage;
	
	private Date registeredOn;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProfilePage() {
		return profilePage;
	}

	public void setProfilePage(String profilePage) {
		this.profilePage = profilePage;
	}

	public Date getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(Date registeredOn) {
		this.registeredOn = registeredOn;
	}
}
