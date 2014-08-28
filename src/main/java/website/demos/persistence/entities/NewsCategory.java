package website.demos.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import website.demos.persistence.entities.News;
import java.util.Collection;

@Entity
@Table(name = "T_NEWSCATEGORY")
public class NewsCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	public NewsCategory() {
	}

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "Id")
	private long id;
	
	@Basic
	@Column(name = "Name")
	private String name;

	@OneToMany(mappedBy = "newsCategory")
	private Collection<News> news;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String param) {
		this.name = param;
	}

	public Collection<News> getNews() {
	    return news;
	}

	public void setNews(Collection<News> param) {
	    this.news = param;
	}

}