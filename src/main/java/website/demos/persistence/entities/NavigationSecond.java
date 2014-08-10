package website.demos.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_NAVIGATIONSECOND")
public class NavigationSecond extends Navigation {

	private static final long serialVersionUID = 1L;
	public NavigationSecond() {
	}
}