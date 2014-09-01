package website.demos.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import website.demos.common.exceptions.CommonSystemException;
import website.demos.persistence.entities.News;
import website.demos.service.NewsService;
import website.demos.service.enums.ECommonService;
import website.demos.web.models.news.NewsCreationModel;
import website.demos.web.models.news.NewsGeneralModel;


@Controller
@RequestMapping("news")
public class NewsController{

	@Autowired
	@Resource
	private NewsService newsService;

	
	@RequestMapping("get-news")
	@ResponseBody
	public NewsGeneralModel getNews(int id) throws CommonSystemException {
		return new NewsGeneralModel(newsService.get(id));
	}
	
	@RequestMapping("get-all-news")
	@ResponseBody
	public List<NewsGeneralModel> getAllNews() throws CommonSystemException {
		List<NewsGeneralModel> models = new ArrayList<NewsGeneralModel>();
		for (News news : newsService.getAllNews()) {
			models.add(new NewsGeneralModel(news));
		}
		return models;
	}

	/*
	 * Create
	 */
	@RequestMapping(value="save-news", method = RequestMethod.POST)
	@ResponseBody
	public String saveNews(NewsCreationModel newsCreationModel) throws CommonSystemException{
		newsService.save(newsCreationModel.getEntity());
		return ECommonService.SUCCESS.getDescription();
	}

	/*
	 * Update
	 */
	@RequestMapping(value="update-news", method = RequestMethod.POST)
	@ResponseBody
	public String updateNews(NewsCreationModel newsCreationModel) throws CommonSystemException{
		newsService.update(newsCreationModel.getEntity());
		return ECommonService.SUCCESS.getDescription();
	}
	
	/*
	 * delete
	 */
	@RequestMapping(value="delete-news", method = RequestMethod.POST)
	@ResponseBody
	public String deleteNews(NewsCreationModel newsCreationModel) throws CommonSystemException{
		newsService.delete(newsCreationModel.getEntity());
		return ECommonService.SUCCESS.getDescription();
	}

}
