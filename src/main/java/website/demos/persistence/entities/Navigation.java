package website.demos.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "T_NAVIGATION")
public class Navigation implements Serializable {

	private static final long serialVersionUID = 1L;

	public Navigation() {
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "Id")
	private long id;

	@Basic
	@Column(name = "Title")
	private String title;

	@Basic
	@Column(name = "Url")
	private String url;

	@Basic
	@Column(name = "Visiable")
	private Boolean visiable;

	@Basic
	@Column(name = "CreatedDate")
	@Temporal(TemporalType.TIME)
	private Date createdDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String param) {
		this.title = param;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String param) {
		this.url = param;
	}

	public Boolean getVisiable() {
		return visiable;
	}

	public void setVisiable(Boolean param) {
		this.visiable = param;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date param) {
		this.createdDate = param;
	}

}