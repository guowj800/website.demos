package website.demos.persistence.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import website.demos.persistence.entities.NewsCategory;


@Transactional
@Repository
public class NewsCategoryRepository extends GeneralRepository<NewsCategory> {

	public List<NewsCategory> getAllNewsCategory() {
		String queryString = "from NewsCategory newsCategory";
		return this.query(queryString);
	}
	
	@Override
	protected Class<NewsCategory> getEntityType() {
		// TODO Auto-generated method stub
		return null;
	}
}
