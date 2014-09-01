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
import website.demos.persistence.entities.NewsCategory;
import website.demos.service.NewsCategoryService;
import website.demos.service.enums.ECommonService;
import website.demos.web.models.newscategory.NewsCategoryCreationModel;
import website.demos.web.models.newscategory.NewsCategoryGeneralModel;


@Controller
@RequestMapping("newscategory")
public class NewsCategoryController{

	@Autowired
	@Resource
	private NewsCategoryService newsCategoryService;

	
	@RequestMapping("get-newscategory")
	@ResponseBody
	public NewsCategoryGeneralModel getNewsCategory(int id) throws CommonSystemException {
		return new NewsCategoryGeneralModel(newsCategoryService.get(id));
	}
	
	@RequestMapping("get-all-newscategory")
	@ResponseBody
	public List<NewsCategoryGeneralModel> getAllNewsCategory() throws CommonSystemException {
		List<NewsCategoryGeneralModel> models = new ArrayList<NewsCategoryGeneralModel>();
		for (NewsCategory newsCategory : newsCategoryService.getAllNewsCategory()) {
			models.add(new NewsCategoryGeneralModel(newsCategory));
		}
		return models;
	}

	/*
	 * Create
	 */
	@RequestMapping(value="save-newscategory", method = RequestMethod.POST)
	@ResponseBody
	public String saveNewsCategory(NewsCategoryCreationModel newsCategoryCreationModel) throws CommonSystemException{
		newsCategoryService.save(newsCategoryCreationModel.getEntity());
		return ECommonService.SUCCESS.getDescription();
	}

	/*
	 * Update
	 */
	@RequestMapping(value="update-newscategory", method = RequestMethod.POST)
	@ResponseBody
	public String updateNewsCategory(NewsCategoryCreationModel newsCategoryCreationModel) throws CommonSystemException{
		
		newsCategoryService.update(newsCategoryCreationModel.getEntity());
		return ECommonService.SUCCESS.getDescription();
	}
	
	/*
	 * delete
	 */
	@RequestMapping(value="delete-newscategory", method = RequestMethod.POST)
	@ResponseBody
	public String deleteNewsCategory(NewsCategoryCreationModel newsCategoryCreationModel) throws CommonSystemException{
		
		newsCategoryService.delete(newsCategoryCreationModel.getEntity());
		return ECommonService.SUCCESS.getDescription();
	}

}
