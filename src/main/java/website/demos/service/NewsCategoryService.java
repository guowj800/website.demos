package website.demos.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import website.demos.persistence.entities.NewsCategory;
import website.demos.persistence.repositories.NewsCategoryRepository;

@Service
public class NewsCategoryService {
	
	@Autowired
	@Resource
	private NewsCategoryRepository newsCategoryRepository;
	
	public List<NewsCategory> getAllNewsCategory() {
		return newsCategoryRepository.getAllNewsCategory();
	}
	
	public NewsCategory get(int id){
		return newsCategoryRepository.get(id);
	}
	
	public void save(NewsCategory newsCategory){
		newsCategoryRepository.save(newsCategory);
	}
	
	public void update(NewsCategory newsCategory){
		newsCategoryRepository.update(newsCategory);
	}
	
	public void delete(NewsCategory newsCategory){
		newsCategoryRepository.delete(newsCategory);
	}

}
