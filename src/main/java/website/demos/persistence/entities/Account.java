package website.demos.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import website.demos.persistence.entities.enums.EAccountType;

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
	@Column(name = "AccountId", unique = true, nullable = true)
	private String accountId;
	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String param) {
		this.accountId = param;
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

}