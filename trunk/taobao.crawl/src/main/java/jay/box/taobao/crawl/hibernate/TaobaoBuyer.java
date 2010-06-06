package jay.box.taobao.crawl.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaobaoBuyer {
	
	private String nickname;
	
	private Integer level;
	
	private String userRateURL;//rating records of this user

	@Id
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getUserRateURL() {
		return userRateURL;
	}

	public void setUserRateURL(String userRateURL) {
		this.userRateURL = userRateURL;
	}
}
