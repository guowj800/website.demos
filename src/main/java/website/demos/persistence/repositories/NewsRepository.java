package website.demos.persistence.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import website.demos.persistence.entities.News;


@Transactional
@Repository
public class NewsRepository extends GeneralRepository<News> {

	public List<News> getAllNews() {
		String queryString = "from News news";
		return this.query(queryString);
	}
	
	@Override
	protected Class<News> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}
}
