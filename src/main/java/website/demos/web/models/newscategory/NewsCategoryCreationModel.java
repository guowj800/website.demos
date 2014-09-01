package website.demos.web.models.newscategory;

import website.demos.common.exceptions.CommonSystemException;
import website.demos.common.global.InstanceConverter;
import website.demos.persistence.entities.NewsCategory;

public class NewsCategoryCreationModel extends NewsCategory {
	private static final long serialVersionUID = 1L;

	public NewsCategoryCreationModel() {

	}

	public NewsCategoryCreationModel(NewsCategory newsCategory) throws CommonSystemException {
		InstanceConverter.assignProperties(newsCategory, this);
	}

	public NewsCategory getEntity() throws CommonSystemException {
		NewsCategory entity = new NewsCategory();
		return InstanceConverter.assignProperties(this, entity);
	}

}
