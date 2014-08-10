package website.demos.persistence.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import website.demos.persistence.entities.NavigationSecond;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
@Table(name = "T_NAVIGATIONFIRST")
public class NavigationFirst extends Navigation {

	private static final long serialVersionUID = 1L;
	
	@Basic
	@Column(name = "Type")
	private String type;

	@OneToMany
	private List<NavigationSecond> navigationSecond;

	public NavigationFirst() {
	}

	public String getType() {
		return type;
	}

	public void setType(String param) {
		this.type = param;
	}

	public List<NavigationSecond> getNavigationSecond() {
	    return navigationSecond;
	}

	public void setNavigationSecond(List<NavigationSecond> param) {
	    this.navigationSecond = param;
	}
}