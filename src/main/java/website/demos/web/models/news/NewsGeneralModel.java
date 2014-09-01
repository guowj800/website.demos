package website.demos.web.models.news;

import website.demos.common.exceptions.CommonSystemException;
import website.demos.common.global.InstanceConverter;
import website.demos.persistence.entities.News;
import website.demos.persistence.entities.NewsCategory;

public class NewsGeneralModel extends NewsCategory {
	private static final long serialVersionUID = 1L;

	public NewsGeneralModel() {

	}

	public NewsGeneralModel(News news) throws CommonSystemException {
		InstanceConverter.assignProperties(news, this);
	}
}
