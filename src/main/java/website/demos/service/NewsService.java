package website.demos.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import website.demos.persistence.entities.News;
import website.demos.persistence.repositories.NewsRepository;

@Service
public class NewsService {
	
	@Autowired
	@Resource
	private NewsRepository newsRepository;
	
	public List<News> getAllNews() {
		return newsRepository.getAllNews();
	}
	
	public News get(int id){
		return newsRepository.get(id);
	}
	
	public void save(News news){
		newsRepository.save(news);
	}
	
	public void update(News news){
		newsRepository.update(news);
	}
	
	public void delete(News news){
		newsRepository.delete(news);
	}

}
