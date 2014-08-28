package website.demos.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import website.demos.persistence.entities.NewsCategory;
import website.demos.persistence.entities.Account;

@Entity
@Table(name = "T_NEWS")
public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	public News() {
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "Id")
	private long id;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "NewsCategoryId")
	private NewsCategory newsCategory;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "AccountId")
	private Account account;
	
	@Basic
	@Column(name = "Title")
	private String title;
	
	@Basic
	@Column(name = "Brief")
	private String brief;
	
	@Basic
	@Column(name = "Picture")
	private String picture;
	
	@Basic
	@Column(name = "Content")
	private String content;
	
	@Basic
	@Column(name = "Attachment")
	private String attachment;
	
	@Basic
	@Column(name = "CreatedDate")
	@Temporal(TemporalType.TIME)
	private Date createdDate;
	
	@Basic
	@Column(name = "ModifiedDate")
	@Temporal(TemporalType.TIME)
	private Date modifiedDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public NewsCategory getNewsCategory() {
		return newsCategory;
	}

	public void setNewsCategory(NewsCategory param) {
		this.newsCategory = param;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account param) {
		this.account = param;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String param) {
		this.title = param;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String param) {
		this.brief = param;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String param) {
		this.picture = param;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String param) {
		this.content = param;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String param) {
		this.attachment = param;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date param) {
		this.createdDate = param;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date param) {
		this.modifiedDate = param;
	}

}