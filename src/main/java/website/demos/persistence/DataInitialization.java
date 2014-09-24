package website.demos.persistence;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import website.demos.persistence.entities.Account;
import website.demos.persistence.entities.News;
import website.demos.persistence.entities.NewsCategory;
import website.demos.persistence.repositories.AccountRepository;
import website.demos.persistence.repositories.NewsCategoryRepository;
import website.demos.persistence.repositories.NewsRepository;

public class DataInitialization {
	
	@Autowired
	@Resource
	AccountRepository accountRepository;
	
	@Autowired
	@Resource
	NewsCategoryRepository newsCategoryRepository;
	
	@Autowired
	@Resource
	NewsRepository newsRepository;

	@PostConstruct
	public void initialize() {
		// clearData();
		initialAccounts();
	}
	
	public void initialAccounts() {
		System.out.println("Data Init");
		
		//Init accounts
		Account jack = new Account();
		jack.setLoginId("jack");
		jack.setPassword("000000");
		jack.setName("Jack Zhang");
		
		Account penny = new Account();
		penny.setLoginId("penny");
		penny.setPassword("000000");
		penny.setName("Penny Zheng");
		
		//accountRepository.save(jack, penny);
		
		//System.out.println(accountRepository.getAccountByLoginId("jack"));
		
		//Init newscategory
		NewsCategory newsCategory_1 = new NewsCategory();
		newsCategory_1.setName("新闻动态");
		
		NewsCategory newsCategory_2 = new NewsCategory();
		newsCategory_2.setName("最近资讯");
		
		//Init news
		News news_1 = new News();
		news_1.setTitle("Title1 Title1 Title1 Title1 Title1 Title1 Title1 Title1 Title1 Title1");
		news_1.setContent("Content1 Content1 Content1 Content1 Content1 Content1 Content1");
		
		News news_2 = new News();
		news_2.setTitle("Title2 Title2 Title2 Title2 Title2 Title2 Title2 Title2 Title2 Title2");
		news_2.setContent("Content2 Content2 Content2 Content2 Content2 Content2 Content2");
		
		
		//Relations
		jack.getNews().add(news_1);
		newsCategory_1.getNews().add(news_1);
		
		penny.getNews().add(news_2);
		newsCategory_2.getNews().add(news_2);
		
		//Persist
		accountRepository.save(jack, penny);
		newsCategoryRepository.save(newsCategory_1, newsCategory_1);
		newsRepository.save(news_1, news_1);
	}
}
