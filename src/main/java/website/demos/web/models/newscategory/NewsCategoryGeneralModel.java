package website.demos.web.models.newscategory;

import website.demos.common.exceptions.CommonSystemException;
import website.demos.common.global.InstanceConverter;
import website.demos.persistence.entities.NewsCategory;

public class NewsCategoryGeneralModel extends NewsCategory {
	private static final long serialVersionUID = 1L;

	public NewsCategoryGeneralModel() {

	}

	public NewsCategoryGeneralModel(NewsCategory newsCategory) throws CommonSystemException {
		InstanceConverter.assignProperties(newsCategory, this);
	}
}
