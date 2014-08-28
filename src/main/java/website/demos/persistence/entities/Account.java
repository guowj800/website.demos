package website.demos.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import website.demos.persistence.entities.enums.EAccountType;
import website.demos.persistence.entities.News;

import java.util.Collection;

@Entity
@Table(name = "T_ACCOUNT")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	public Account() {
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "Id")
	private long id;
	
	@Basic
	@Column(name = "LoginId", unique = true, nullable = true)
	private String loginId;
	
	@Basic
	@Column(name = "Password", nullable = true)
	private String password;
	
	@Basic
	@Column(name = "Name")
	private String name;
	
	@Basic
	@Column(name = "CreatedDate")
	@Temporal(TemporalType.TIME)
	private Date creadtedDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Type")
	private EAccountType type;

	@OneToMany(mappedBy = "account", cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	private Collection<News> news;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String param) {
		this.loginId = param;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String param) {
		this.password = param;
	}

	public String getName() {
		return name;
	}

	public void setName(String param) {
		this.name = param;
	}

	public Date getCreadtedDate() {
		return creadtedDate;
	}

	public void setCreadtedDate(Date param) {
		this.creadtedDate = param;
	}

	public EAccountType getType() {
		return type;
	}

	public void setType(EAccountType param) {
		this.type = param;
	}

	public Collection<News> getNews() {
	    return news;
	}

	public void setNews(Collection<News> param) {
	    this.news = param;
	}

}